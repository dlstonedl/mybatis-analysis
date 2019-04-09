1. 读取XML文件属性，解析成Configuration；
2. 通过SqlSessionFactoryBuilder生成SqlSessionFactory，返回DefaultSqlSessionFactory的实例；
3. 从DefaultSqlSessionFactory中得到DefaultSqlSession；
4. UserMapper.xml中的namespace需要与接口名一致；

工厂模式：MapperProxyFactory
动态代理模式：MapperProxy
装饰器模式：Executor

查询：MapperProxy -> MapperMethod -> DefaultSqlSession ->
CachingExecutor -> BaseExecutor -> SimpleExecutor-> 
RoutingStatementHandler -> PreparedStatementHandler

结果集处理：DefaultResultSetHandler


  