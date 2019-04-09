JDBC中重要的类：
1. DriverManager
2. Connection
3. PreparedStatement
4. ResultSet
5. Statement
6. CallableStatement

Class.forName(String): 加载类，并执行类初始化；
ClassLoader.loadClass(String): 加载类，不执行类初始化；
Java6中引入了service provider，mysql驱动jar包中已经包含java.sql.Driver配置文件；
无需手动加载：Class.forName(“com.mysql.jdbc.Driver”);

Mybatis：
1. Connection的获取； -> DataSource
2. PreparedStatement的获取；-> sql及参数赋值；拼接sql用(?)代替参数；记录参数的位置及参数类型；
3. ResultSet结果集的映射；-> 结果集映射为返回值类型(反射)
4. Mapper的动态代理；
5. 其他高级特性；

jdbc demo中已最简单的方式实现了前三个：
1. DataSource -> dbcp2中的BasicDataSource；
2. PreparedStatementHandler，解析原始sql获取预编译sql及参数顺序；通过参数顺序来决定preparedStatement的赋值顺序；
3. ResultHandle，反射set方法，实现结果集的映射；



