## 1、基本使用

```Java
String resource = "org/mybatis/example/mybatis-config.xml";
InputStream inputStream = Resources.getResourceAsStream(resource);
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
try (SqlSession session = sqlSessionFactory.openSession()) {
  BlogMapper mapper = session.getMapper(BlogMapper.class);
  Blog blog = mapper.selectBlog(101);
}
```

## 2、主路径

SqlSessionFactoryBuilder根据（`Reader | InputStream | Configuration`）构建SqlSessionFactory

- 如果是（`Reader | InputStream`），则会将传入的资源解析成Configuration对象后构建，如果传入的是Configuration对象，则直接构建SqlSessionFactory。
- MyBatis会创建XMLConfigBuilder解析器构建Configuration对象，该解析器会将xxx-Config.xml文件解析成Configuration对象。(ps：注意，MyBatis中存在多种类似的解析器，都在`builder.xml`包中，例如`XMLConfigBuilder`用于解析config.xml；`XMLMapperBuilder`用于解析mapper.xml；`XMLStatementBuilder`用于解析每个SQL语句；`MapperAnnotationBuilder`用于解析注解格式的SQL方法。）
- MyBatis会依次解析config.xml文件中的所有节点（`properties | settings | typeAliases | plugins | objectFactory | objectWrapperFactory | reflectorFactory | environments | databaseIdProvider | typeHandlers | mappers`），并将其转换成相对应的内存对象，保存在Configuration对象中。
- 上述节点的解析过程都非常简单，首先解析节点名称、然后解析节点属性、然后解析子节点、最后将解析完的数据存放在Configuration对象中。大部分节点的解析过程都是如此，其中mapper稍有不同。因为mapper节点主要配置mapper.xml文件，因此解析完该节点后，MyBatis还要再解析mapper.xml文件。

接下来就是解析mapper节点了，mapper节点允许多种配置，但总体上来说就是两种：一种通过Java注解配置；另一种通过配置文件配置。

- 通过Java注解配置会扫描mapper节点配置的包，获取其中所有的接口文件，获取接口上的注解信息，利用这些信息构建MappedStatement对象，最终存放在Configuration中。每个MappedStatement封装了一个Mapper接口方法的所有信息，包括sql语句，是否使用缓存，接口参数等等。上述过程主要通过`MapperAnnotationBuilder`解析。
- 通过mapper.xml文件首先构建`XMLMapperBuilder`，然后依次解析（`mapper | cache-ref | cache | parameterMap | resultMap | sql | select | insert | update | delete`）等节点。其中（`select | insert | update | delete`）节点数据会经由XMLStatementBuilder解析成MappedStatement对象，存放在Configuration中。
- 至此，配置解析流程就结束了，即SqlSessionFactory就能够被构建出来，所有的配置也都转化为Configuration中的一部分了。

接下来是创建SqlSession，流程主要如下。

- 获取Configuration中的Environment。这个在解析配置时，已经将config.xml的environment节点数据解析成Environment对象存放在Configuration中，因此获取没有问题。
- 获取Environment中的TransactionFactory，这个也没问题，理由同上。
- 通过TransactionFactory创建一个Transaction对象。
- 通过Transaction对象创建一个Executor对象，Executor非常重要，后面我们的SQL语句都是通过Executor执行的。在创建Executor时，也有两点需要注意：1）如果激活了缓存配置，即一级缓存，最终会使用CachingExecutor；2）executor会被所有的plugin（如果有的话）给一层层的动态代理起来，也就是说，如果配置了plugin，你最终获得的executor其实是一个动态代理对象，其中插入了所有plugin的代理逻辑。
- 使用Configuration和Executor对象创建SqlSession。

有了SqlSession后，我们便可以获得Mapper对象了。进而通过JDK动态代理执行真正的SQL语句。

- Mapper其实还是从SqlSession中的Configuration获取。
- Configuration中有`Map<Class<?>, MapperProxyFactory<?>>`的映射对象，每个mapper都对应一个`MapperProxyFactory`代理工厂，最终获取的mapper对象是由该代理工厂创建的JDK动态代理对象。代理逻辑在MapperProxy类中，委托PlainMethodInvoker→SqlSession执行，因此，最终执行SQL语句的还是SqlSession对象。

## 3、SqlSessionFactory构建

使用MyBatis首先得构造SqlSessionFactory，也就是如下代码：

```Java
String resource = "org/mybatis/example/mybatis-config.xml";
InputStream inputStream = Resources.getResourceAsStream(resource);
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
```

前两行与MyBatis无关，我们来看看build这个过程究竟做了什么？

- SqlSessionFactoryBuilder没有构造函数，因此`new SqlSessionFactoryBuilder()`仅是调用空构造创建一个对象而已。
- build()方法的链路如下代码所示。（当然也可以通过Reader对象进行构建，但都大差不差）
- 获取SqlSessionFactory的过程就是：
  - 通过传入的xml数据流构建一个解析器XMLConfigBuilder。
  - 利用该解析器解析config.xml文件，然后将xml文件数据转化成内存中的Configuration对象。
  - 利用Configuration对象new一个DefaultSqlSessionFactory对象，DefaultSqlSessionFactory对象也是SqlSessionFactory接口的默认实现类。

```Java
// SqlSessionFactoryBuilder.java
public SqlSessionFactory build(InputStream inputStream) {
  return build(inputStream, null, null);
}
public SqlSessionFactory build(InputStream inputStream, String environment, Properties properties) {
  try {
    // 首先创建 XMLConfigBuilder，这是一个解析器，用于解析config.xml文件，将文件数据转化成内存中的Configuration对象，此时environment和properties都为null
    XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, environment, properties);
    return build(parser.parse());
  } catch (Exception e) {
    throw ExceptionFactory.wrapException("Error building SqlSession.", e);
  } finally {
    ErrorContext.instance().reset();
    try {
      if (inputStream != null) {
        inputStream.close();
      }
    } catch (IOException e) {
      // Intentionally ignore. Prefer previous error.
    }
  }
}
public SqlSessionFactory build(Configuration config) {
  return new DefaultSqlSessionFactory(config);
}
// DefaultSqlSessionFactory.java，DefaultSqlSessionFactory是SqlSessionFactory接口的默认实现类
public DefaultSqlSessionFactory(Configuration configuration) {
  this.configuration = configuration;
}
```

刨除config.xml的解析过程，SqlSessionFactory构建还是非常清晰易懂的。

## 4、Config配置解析

从第三节可知，构建过程中，有一个config配置解析过程，重点就在其中的`parse()`方法。

```Java
// SqlSessionFactoryBuilder.java
XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, environment, properties);
return build(parser.parse());
```

这里先给出完整的config配置文件，即代码中的`inputStream`数据流

```xml
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <properties />
    <settings />
    <typeAliases />
    <typeHandlers />
    <objectFactory />
    <objectWrapperFactory />
    <reflectorFactory />
    <plugins />
    <environments>
        <environment>
            <transactionManager />
            <dataSource />
        </environment>
    </environments>
    <databaseIdProvider />
    <mappers />
</configuration>
```

parse()源码链路如下：

- parse()链路异常清晰，就是解析config.xml配置文件中的所有节点。

```Java
// XMLConfigBuilder.java
public Configuration parse() {
  // 防止二次解析
  if (parsed) {
    throw new BuilderException("Each XMLConfigBuilder can only be used once.");
  }
  parsed = true;
  // 获取顶层 configuration 节点，并开启解析过程
  parseConfiguration(parser.evalNode("/configuration"));
  // 返回解析完的 configuration 对象
  return configuration;
}
private void parseConfiguration(XNode root) {
  try {
    // issue #117 read properties first
    // 依次解析所有子节点
    propertiesElement(root.evalNode("properties"));
    Properties settings = settingsAsProperties(root.evalNode("settings"));
    loadCustomVfs(settings);
    loadCustomLogImpl(settings);
    typeAliasesElement(root.evalNode("typeAliases"));
    pluginElement(root.evalNode("plugins"));
    objectFactoryElement(root.evalNode("objectFactory"));
    objectWrapperFactoryElement(root.evalNode("objectWrapperFactory"));
    reflectorFactoryElement(root.evalNode("reflectorFactory"));
    settingsElement(settings);
    // read it after objectFactory and objectWrapperFactory issue #631
    environmentsElement(root.evalNode("environments"));
    databaseIdProviderElement(root.evalNode("databaseIdProvider"));
    typeHandlerElement(root.evalNode("typeHandlers"));
    mapperElement(root.evalNode("mappers"));
  } catch (Exception e) {
    throw new BuilderException("Error parsing SQL Mapper Configuration. Cause: " + e, e);
  }
}
```

### 4.1、properties节点解析

这里先给一个比较完整的properties配置：

```XML
<properties resource="org/mybatis/example/config.properties">
  <property name="username" value="dev_user"/>
  <property name="password" value="F2Fa3!33TYyg"/>
</properties>
```

解析过程如下所示，代码中的注释已经非常清楚了，这里稍微总结下：

- 解析properties所有子节点的name和value属性，作为Properties对象的KV。
- 解析properties节点的resource或者url属性，将配置的资源转化为Properties对象并合并。
- 如果Configuration原先已有配置也合并。
- 将最终合并的配置传入Configuration中。

```Java
// XMLConfigBuilder.java
private void propertiesElement(XNode context) throws Exception {
  if (context != null) {
    // 如果properties节点不为空，则将所有子节点作为Properties对象返回，其实就是解析子节点中的name和value属性，作为properties的KV
    Properties defaults = context.getChildrenAsProperties();
    // 获取properties节点的resource属性
    String resource = context.getStringAttribute("resource");
    // 获取properties节点的url属性
    String url = context.getStringAttribute("url");
    // resource和url属性仅能设置一个
    if (resource != null && url != null) {
      throw new BuilderException(
          "The properties element cannot specify both a URL and a resource based property file reference.  Please specify one or the other.");
    }
    if (resource != null) {
      // 解析resource数据，并转化成Properties对象返回
      defaults.putAll(Resources.getResourceAsProperties(resource));
    } else if (url != null) {
      // 解析url数据，并转化成Properties对象返回
      defaults.putAll(Resources.getUrlAsProperties(url));
    }
    // 合并configuration中已经设置的属性，一般来说都为null，但是用户可以通过Java API的方式提前设置，因此这里判断下。
    Properties vars = configuration.getVariables();
    if (vars != null) {
      defaults.putAll(vars);
    }
    // 将properties中的数据存放进解析器和Configuration对象
    parser.setVariables(defaults);
    configuration.setVariables(defaults);
  }
}

// XNode.java
public Properties getChildrenAsProperties() {
  Properties properties = new Properties();
  // 遍历所有子节点，将子节点的name和value属性作为Properties对象的KV
  for (XNode child : getChildren()) {
    String name = child.getStringAttribute("name");
    String value = child.getStringAttribute("value");
    if (name != null && value != null) {
      properties.setProperty(name, value);
    }
  }
  return properties;
}
```

### 4.2、setting节点解析

这里先给一个比较完整的settings节点配置：

```XML
<settings>
  <setting name="cacheEnabled" value="true"/>
  <setting name="lazyLoadingEnabled" value="true"/>
  <setting name="aggressiveLazyLoading" value="true"/>
</settings>
```

解析过程如下所示，如果已经掌握了properties节点解析，那么这个也就非常好看懂了，但是还有一个点提一下：

- 在遍历所有settings节点的name和value属性时，MyBatis通过MetaClass 判断settings子节点配置的name是否都存在Configuration对象中，如果不存在则抛出异常。这样就能够避免用户配置了MyBatis不认识的一些配置项。

```Java
// XMLConfigBuilder.java
private Properties settingsAsProperties(XNode context) {
  if (context == null) {
    return new Properties();
  }
  Properties props = context.getChildrenAsProperties();
  MetaClass metaConfig = MetaClass.forClass(Configuration.class, localReflectorFactory);
  for (Object key : props.keySet()) {
    // 通过MetaClass校验settings子节点配置的name属性都存在Configuration对象中
    if (!metaConfig.hasSetter(String.valueOf(key))) {
      throw new BuilderException(
          "The setting " + key + " is not known.  Make sure you spelled it correctly (case sensitive).");
    }
  }
  return props;
}
```

这里并没有立即将settings节点设置进Configuration对象中，而是直接返回，并在后面依次set。其实在这里直接set应该也没啥问题，大概作者认为中间过程还有可能改变这些设置才会延后的吧。

### 4.3、typeAliases节点解析

这里先给一个比较完整的typeAliases节点配置：

```XML
<typeAliases>
  <package name="domain.blog"/>
  <typeAlias alias="Author" type="domain.blog.Author"/>
</typeAliases>
```

解析过程如下所示，typeAliases节点允许配置两类子节点，一类是package，指定包名，另一类是typeAlias，指定类型别名和类型全路径：

- 如果指定了包名，则该包下的所有JavaBean都将使用类名的首字母小写的非限定类名来作为它的别名
- 如果直接指定了别名和全限定类名，则直接添加进typeAliasRegistry（类型别名注册器）的别名映射中

```Java
// XMLConfigBuilder.java
private void typeAliasesElement(XNode parent) {
  if (parent != null) {
    for (XNode child : parent.getChildren()) {
      if ("package".equals(child.getName())) {
        // 如果子节点是package，则利用Configuration中的typeAliasRegistry（类型别名注册器）解析包名下的所有JavaBean，在没有注解的情况下，会使用 Bean 的首字母小写的非限定类名来作为它的别名。
        String typeAliasPackage = child.getStringAttribute("name");
        configuration.getTypeAliasRegistry().registerAliases(typeAliasPackage);
      } else {
        // 这里就是解析typeAlias子节点，将alias和type属性添加进typeAliasRegistry（类型别名注册器）的别名映射中
        String alias = child.getStringAttribute("alias");
        String type = child.getStringAttribute("type");
        try {
          Class<?> clazz = Resources.classForName(type);
          if (alias == null) {
            typeAliasRegistry.registerAlias(clazz);
          } else {
            typeAliasRegistry.registerAlias(alias, clazz);
          }
        } catch (ClassNotFoundException e) {
          throw new BuilderException("Error registering typeAlias for '" + alias + "'. Cause: " + e, e);
        }
      }
    }
  }
}
```

这里大家可以多看一眼typeAliasRegistry（类型别名注册器），它在初始化的时候会事先添加一些类型别名，这也是我们能够在MyBatis中直接使用部分别名的原因。

```Java
// TypeAliasRegistry
public TypeAliasRegistry() {
    registerAlias("string", String.class);

    registerAlias("byte", Byte.class);
    registerAlias("char", Character.class);
    registerAlias("character", Character.class);
    registerAlias("long", Long.class);
    registerAlias("short", Short.class);
    // ......
}
```