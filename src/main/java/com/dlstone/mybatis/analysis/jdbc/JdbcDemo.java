package com.dlstone.mybatis.analysis.jdbc;

import com.dlstone.mybatis.analysis.sample.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JdbcDemo {

    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.setProperty("driverClassName", "com.mysql.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://localhost:3306/mybatis_analysis");
        properties.setProperty("username", "root");
        properties.setProperty("password", "");

        String sql = "select * from user where id = #{id} and username = #{username}";

        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("username", "aaa");
        paraMap.put("id", 1);

        DataSource dataSource = null;
        PreparedStatement preparedStatement = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(properties);
            Connection connection = dataSource.getConnection();
            PreparedStatementHandler handler = new PreparedStatementHandler(sql, connection);
            preparedStatement = handler.getPreparedStatement(paraMap);
            preparedStatement.execute();

            ResultSet result = preparedStatement.getResultSet();
            ResultHandle<User> resultHandle = new ResultHandle<>(result, User.class);
            User user = resultHandle.getResult();
            System.out.println(user.toString());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            ((BasicDataSource) dataSource).close();
        }
    }
}
