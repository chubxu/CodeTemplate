## 1、mapper.xml映射解析

由于我们使用MyBatis时，大部分时间都是使用mapper.xml配置sql映射的，因此本章节我们主要介绍xml的解析过程。

4.7小节已经分析了mappers节点的解析过程，其中在解析mapper子节点时，构造了XMLMapperBuilder解析器然后再解析mapper.xml文件，如下代码所示：

```Java
// XMLConfigBuilder.java
// 先构造
XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, resource,
    configuration.getSqlFragments());
// 再解析
mapperParser.parse();
```

先看看解析器的构造过程：

- 首先会构造XPathParser解析器，该解析器负责将文件输入流解析成Document文档对象。
- 然后会构造MapperBuilderAssistant对象，该对象在mapper解析时起到辅助解析部分对象的作用。