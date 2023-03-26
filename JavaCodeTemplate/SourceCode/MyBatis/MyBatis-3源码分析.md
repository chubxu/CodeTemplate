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

- SqlSessionFactoryBuilder根据（`Reader | InputStream | Configuration`）构建SqlSessionFactory
    - 如果是（`Reader | InputStream`），则会将传入的资源解析成Configuration对象后构建，如果传入的是Configuration对象，则直接构建SqlSessionFactory
    - MyBatis会创建XMLConfigBuilder解析器构建Configuration对象，该解析器会将xxx-Config.xml文件解析成Configuration对象。(ps：注意，MyBatis中存在多种类似的解析器，都在`builder.xml`包中，例如XMLConfigBuilder用于解析config.xml；XMLMapperBuilder用于解析mapper.xml；XMLStatementBuilder用于解析每个SQL语句。）
    - MyBatis会依次解析config.xml文件中的所有节点（`properties | settings | typeAliases | plugins | objectFactory | objectWrapperFactory | reflectorFactory | environments | databaseIdProvider | typeHandlers | mappers`），并将其转换成相对应的内存对象，保存在Configuration对象中。
    - config.xml的节点解析过程都非常简单，首先解析节点名称、然后解析节点属性、然后解析子节点、最后将解析完的数据存放在Configuration对象中。大部分节点的解析过程都是如此，其中mapper稍有不同。因为mapper节点主要配置mapper.xml文件，因此解析完该节点后，MyBatis还要再解析mapper.xml文件。