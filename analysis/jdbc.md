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

Mybatis需要解决的三个问题：
1. Connection的获取；
2. PreparedStatement的获取；
3. ResultSet结果集的映射；