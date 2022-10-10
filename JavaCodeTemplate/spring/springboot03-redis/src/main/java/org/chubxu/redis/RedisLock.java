package org.chubxu.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisLock
 * @Description TODO
 * @Since 1.0.0
 * @Date 2022/10/10 22:46
 * @Author chubxu
 */
@Component
public class RedisLock {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    // setnx
    public boolean tryLock(String k, String v) {
        if (Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(k, v))) {
            return true;
        }
        return false;
    }

    // setnx + expire
    public boolean tryLock2(String k, String v, Long timeout, TimeUnit unit) {
        if (Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(k, v))) {
            redisTemplate.expire(k, timeout, unit);
            return true;
        }
        return false;
    }

    // set nx ex
    public boolean tryLock3(String k, String v, Long timeout, TimeUnit unit) {
        if (Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(k, v, timeout, unit))) {
            return true;
        }
        return false;
    }

    public boolean tryLock4(String lockKey, String value, int expireTime) {
        boolean ret = false;
        try {
            // String script = "if redis.call('setNx',KEYS[1],ARGV[1]) then if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('expire',KEYS[1],ARGV[2]) else return 0 end end";
            String script = "if redis.call('setNx',KEYS[1],ARGV[1])==1 then\n" +
                    "    if redis.call('get',KEYS[1])==ARGV[1] then\n" +
                    "        return redis.call('expire',KEYS[1],ARGV[2])\n" +
                    "    else\n" +
                    "        return 0\n" +
                    "    end\n" +
                    "else\n" +
                    "    return 0\n" +
                    "end";
            RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
            redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
            Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), value, expireTime);
            if (Boolean.TRUE.equals(result)) {
                ret = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    // 释放锁
    public boolean releaseLock(String key, String value) {
        String lua = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(lua, Long.class);
        Long result = redisTemplate.execute(redisScript, Collections.singletonList(key), value);
        return 1L == Optional.ofNullable(result).orElse(0L);
    }
}
