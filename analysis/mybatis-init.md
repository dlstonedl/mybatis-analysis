1. 读取XML文件属性，解析成Configuration；
2. 通过SqlSessionFactoryBuilder生成SqlSessionFactory，返回的是DefaultSqlSessionFactory的实例；
3. 从DefaultSqlSessionFactory中可以得到DefaultSqlSession；
4. UserMapper.xml中的namespace需要与接口名一致；



  