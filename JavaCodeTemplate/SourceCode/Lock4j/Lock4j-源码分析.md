# Lock4j源码分析

最近看到了一篇分布式锁的文章，突然想到之前学习分布式锁时，看过Lock4j的源码，但当时只是快速搂了一眼，没有写点啥记录下来。

这次趁着有这个想法了，就写篇文章记录下源码的执行流程吧，也顺便给自己复习下分布式锁相关的内容。

## 1、手动加解锁

官方README上的手动上锁代码如下：

```Java
@Service
public class ProgrammaticService {
    @Autowired
    private LockTemplate lockTemplate;

    public void programmaticLock(String userId) {
        // 各种查询操作 不上锁
        // ...
        // 尝试获取锁
        final LockInfo lockInfo = lockTemplate.lock(userId, 30000L, 5000L, RedissonLockExecutor.class);
        if (null == lockInfo) {
            // 获取锁失败
            throw new RuntimeException("业务处理中,请稍后再试");
        }
        // 获取锁成功，处理业务
        try {
            System.out.println("执行简单方法1 , 当前线程:" + Thread.currentThread().getName() + " , counter：" + (counter++));
        } finally {
            //释放锁
            lockTemplate.releaseLock(lockInfo);
        }
        //结束
    }
}
```

- 整体清晰易懂，主要就是通过LockTemplate这个类获取锁。如果获取锁成功，则进行业务处理，此时其他线程获取锁会失败。如果获取锁失败，则表示其他线程正在处理业务，当前线程阻塞等待。
- 重点在LockTemplate上，从代码中发现是自动注入了，因此我们很容易想到，Lock4j框架应该使用了Springboot的自动注入能力，即我们是能够在代码中找到xxxAutoConfiguration.java这个类，该类将LockTemplate注入到了Spring容器中。

接下来我们便来看看这个xxxAutoConfiguration吧。

## 2、自动注入

自动注入的代码如下所示：

```Java
// LockAutoConfiguration.java
@Configuration
// 激活Lock4jProperties配置，用户的 lock4j.xxx 的配置可以注解注入到当前Lock4jProperties属性中
@EnableConfigurationProperties(Lock4jProperties.class)
@RequiredArgsConstructor
public class LockAutoConfiguration {

    private final Lock4jProperties properties;

    @SuppressWarnings("rawtypes")
    @Bean
    @ConditionalOnMissingBean
    // 自动注入 LockTemplate 对象
    // LockExecutor是分布式锁核心处理器，这里通过引入不同框架（RedisTemplate、Redisson、zk）使用不同的分布式锁能力
    public LockTemplate lockTemplate(List<LockExecutor> executors) {
        LockTemplate lockTemplate = new LockTemplate();
        lockTemplate.setProperties(properties);
        lockTemplate.setExecutors(executors);
        return lockTemplate;
    }
    @Bean
    @ConditionalOnMissingBean
    // 自动注入 LockKeyBuilder 对象，用于构造分布式锁的key
    public LockKeyBuilder lockKeyBuilder() {
        return new DefaultLockKeyBuilder();
    }
    @Bean
    @ConditionalOnMissingBean
    // 自动注入 DefaultLockFailureStrategy 对象，获取锁失败的处理策略
    public LockFailureStrategy lockFailureStrategy() {
        return new DefaultLockFailureStrategy();
    }
    @Bean
    @ConditionalOnMissingBean
    // 自动注入 LockInterceptor 对象，分布式锁的拦截器
    public LockInterceptor lockInterceptor(LockTemplate lockTemplate, LockKeyBuilder lockKeyBuilder,
                                           LockFailureStrategy lockFailureStrategy) {
        return new LockInterceptor(lockTemplate, lockKeyBuilder, lockFailureStrategy, properties);
    }
    @Bean
    @ConditionalOnMissingBean
    // 自动注入 LockAnnotationAdvisor 对象，分布式锁的注解通知对象
    public LockAnnotationAdvisor lockAnnotationAdvisor(LockInterceptor lockInterceptor) {
        return new LockAnnotationAdvisor(lockInterceptor, Ordered.HIGHEST_PRECEDENCE);
    }
}
```

- 整个注入就是向Spring容器中添加了一些bean对象，包括
  - LockTemplate：用于加锁、解锁
  - LockKeyBuilder：用于构造分布式锁的key
  - LockFailureStrategy：获取锁失败的处理策略
  - LockInterceptor：分布式锁的拦截器，用在LockAnnotationAdvisor中，AOP核心处理逻辑就在其中
  - LockAnnotationAdvisor：分布式锁的注解通知对象

## 3、获取锁

获取锁的代码如下：

```Java
// LockTemplate.java
public LockInfo lock(String key) {
    return lock(key, 0, -1);
}

public LockInfo lock(String key, long expire, long acquireTimeout) {
    return lock(key, expire, acquireTimeout, null);
}

/**
 * 加锁方法
 *
 * @param key            锁key 同一个key只能被一个客户端持有
 * @param expire         过期时间(ms) 防止死锁
 * @param acquireTimeout 尝试获取锁超时时间(ms)
 * @param executor       执行器
 * @return 加锁成功返回锁信息 失败返回null
 */
public LockInfo lock(String key, long expire, long acquireTimeout, Class<? extends LockExecutor> executor) {
    // 校验超时时间
    acquireTimeout = acquireTimeout < 0 ? properties.getAcquireTimeout() : acquireTimeout;
    // 获取重试间隔
    long retryInterval = properties.getRetryInterval();
    // 获取执行器，默认使用顺序为 redisson>redisTemplate>zookeeper，如果仅注入了一个，就使用注入的那个
    LockExecutor lockExecutor = obtainExecutor(executor);
    log.debug(String.format("use lock class: %s", lockExecutor.getClass()));
    expire = !lockExecutor.renewal() && expire <= 0 ? properties.getExpire() : expire;
    int acquireCount = 0;
    String value = LockUtil.simpleUUID();
    // 记录获取锁的开始时间
    long start = System.currentTimeMillis();
    try {
        do {
            acquireCount++;
            // 尝试通过执行器获取锁实例
            Object lockInstance = lockExecutor.acquire(key, value, expire, acquireTimeout);
            if (null != lockInstance) {
                // 如果锁实例不为null，表示获取锁成功，此时封装一个LockInfo返回
                return new LockInfo(key, value, expire, acquireTimeout, acquireCount, lockInstance, lockExecutor);
            }
            // 获取锁失败，当前线程睡眠间隔时间，之后再次尝试获取锁
            TimeUnit.MILLISECONDS.sleep(retryInterval);
        } 
        // 如果没有超过超时时间，则继续尝试获取锁，否则直接返回null
        while (System.currentTimeMillis() - start < acquireTimeout);
    } catch (InterruptedException e) {
        log.error("lock error", e);
        throw new LockException();
    }
    return null;
}
```

- 代码流程在注释中已经说的很清楚了，具体的获取锁的流程我们稍后在各个框架（redisson、redisTemplate、zookeeper）再中分析。这里我们看下LockTemplate是如何获取LockExecutor执行器的，即obtainExecutor方法的执行流程。

obtainExecutor方法如下：

```Java
// LockTemplate.java
protected LockExecutor obtainExecutor(Class<? extends LockExecutor> clazz) {
    if (null == clazz || clazz == LockExecutor.class) {
        // 如果没有指定执行器，则使用系统优先定义的执行器
        return primaryExecutor;
    }
    // 如果指定了执行器，看看执行器有没有被成功加载进executorMap中，如果没有成功加载，则抛出异常
    final LockExecutor lockExecutor = executorMap.get(clazz);
    Assert.notNull(lockExecutor, String.format("can not get bean type of %s", clazz));
    return lockExecutor;
}
```

- 获取逻辑还是非常清晰的，指定了执行器的类名，则校验是否成功加载再返回；如果没有指定，则使用系统优化定义的执行器，即redisson>redisTemplate>zookeeper。

primaryExecutor和executorMap又是怎么来的呢？我们来看看LockTemplate的afterPropertiesSet方法，它会在LockTemplate被初始化后执行。通过下面的代码我们便可以知道executor的加载逻辑了。

```Java
// LockTemplate.java
@Override
public void afterPropertiesSet() throws Exception {

    Assert.isTrue(properties.getAcquireTimeout() >= 0, "tryTimeout must least 0");
    Assert.isTrue(properties.getExpire() >= -1, "expireTime must lease -1");
    Assert.isTrue(properties.getRetryInterval() >= 0, "retryInterval must more than 0");
    Assert.hasText(properties.getLockKeyPrefix(), "lock key prefix must be not blank");
    Assert.notEmpty(executors, "executors must have at least one");
    // executors是在自动注入时注入进来的，如果三个框架的依赖都添加了，则有三个executor
    for (LockExecutor executor : executors) {
        // 添加进executorMap中
        executorMap.put(executor.getClass(), executor);
    }

    final Class<? extends LockExecutor> primaryExecutor = properties.getPrimaryExecutor();
    if (null == primaryExecutor) {
        // 如果primaryExecutor未在配置中配置，则获取第一个executors，executors通过order注解标注了加载优先级
        this.primaryExecutor = executors.get(0);
    } else {
        this.primaryExecutor = executorMap.get(primaryExecutor);
        Assert.notNull(this.primaryExecutor, "primaryExecutor must be not null");
    }
}
```

现在可以看看具体如何获得锁的了。这里仅分析下redisTemplate获取锁的方式，其他两个大差不差。

```Java
// RedisTemplateLockExecutor.java
// 执行获取锁的脚本
private static final RedisScript<String> SCRIPT_LOCK = new DefaultRedisScript<>("return redis.call('set',KEYS[1]," +
            "ARGV[1],'NX','PX',ARGV[2])", String.class);
@Override
public String acquire(String lockKey, String lockValue, long expire, long acquireTimeout) {
    String lock = redisTemplate.execute(SCRIPT_LOCK,
            redisTemplate.getStringSerializer(),
            redisTemplate.getStringSerializer(),
            Collections.singletonList(lockKey),
            lockValue, String.valueOf(expire));
    final boolean locked = LOCK_SUCCESS.equals(lock);
    return obtainLockInstance(locked, lock);
}
```

- 获取锁的方式还是非常简单的，就是执行了一段set nx px脚本去获取锁。该方法能简单解决分布式锁的获取场景，但当业务逻辑执行时长大于锁的过期时间话，还是会导致竞争出现，因此更加推荐使用Redisson分布式锁，Redisson在底层解决了大部分竞争问题。

## 4、释放锁

释放锁也非常简单，对于redisTemplate来说，就是执行了一段删除key的脚本。

```Java
// LockTemplate.java
public boolean releaseLock(LockInfo lockInfo) {
    if (null == lockInfo) {
        return false;
    }
    return lockInfo.getLockExecutor().releaseLock(lockInfo.getLockKey(), lockInfo.getLockValue(),
            lockInfo.getLockInstance());
}

// RedisTemplateLockExecutor.java
private static final RedisScript<String> SCRIPT_UNLOCK = new DefaultRedisScript<>("if redis.call('get',KEYS[1]) " +
          "== ARGV[1] then return tostring(redis.call('del', KEYS[1])==1) else return 'false' end", String.class);
@Override
public boolean releaseLock(String key, String value, String lockInstance) {
    String releaseResult = redisTemplate.execute(SCRIPT_UNLOCK,
            redisTemplate.getStringSerializer(),
            redisTemplate.getStringSerializer(),
            Collections.singletonList(key), value);
    return Boolean.parseBoolean(releaseResult);
}
```

## 5、AOP加解锁

在介绍自动注入时，说了LockInterceptor时AOP处理的关键逻辑（这个就涉及到Spring AOP内容，在此不过多叙述）。

其核心执行如下所示：

```Java
@Override
public Object invoke(MethodInvocation invocation) throws Throwable {
    //fix 使用其他aop组件时,aop切了两次.
    Class<?> cls = AopProxyUtils.ultimateTargetClass(invocation.getThis());
    if (!cls.equals(invocation.getThis().getClass())) {
        return invocation.proceed();
    }
    // 获取Log4j注解信息
    Lock4j lock4j = invocation.getMethod().getAnnotation(Lock4j.class);
    LockInfo lockInfo = null;
    try {
        // 构造锁的key
        String prefix = lock4jProperties.getLockKeyPrefix() + ":";
        prefix += StringUtils.hasText(lock4j.name()) ? lock4j.name() :
                invocation.getMethod().getDeclaringClass().getName() + invocation.getMethod().getName();
        String key = prefix + "#" + lockKeyBuilder.buildKey(invocation, lock4j.keys());
        // 尝试获取锁
        lockInfo = lockTemplate.lock(key, lock4j.expire(), lock4j.acquireTimeout(), lock4j.executor());
        if (null != lockInfo) {
            // 获取成功，继续往下执行
            return invocation.proceed();
        }
        // 获取锁失败，采用失败策略。这里允许用户自定义自己的失败处理方式
        lockFailureStrategy.onLockFailure(key, invocation.getMethod(), invocation.getArguments());
        return null;
    } finally {
        if (null != lockInfo && lock4j.autoRelease()) {
            // 执行完流程后，自动释放锁
            final boolean releaseLock = lockTemplate.releaseLock(lockInfo);
            if (!releaseLock) {
                log.error("releaseLock fail,lockKey={},lockValue={}", lockInfo.getLockKey(),
                        lockInfo.getLockValue());
            }
        }
    }
}
```

- AOP加锁逻辑也非常清晰，采用环绕通知方式，用加解锁逻辑将业务流程包装起来。注释中已经非常清晰了，大家自行看看即可。

## 6、总结

总而言之，Lock4j是一个非常轻量级的分布式锁框架。它并没有从0到1的去实现一个分布式锁，而是灵活使用Springboot、SpringAOP的扩展功能，将常用的分布式锁封装起来，为用户提供一种更加便捷、简单的使用工具。