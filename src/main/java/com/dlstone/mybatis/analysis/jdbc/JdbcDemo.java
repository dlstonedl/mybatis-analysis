package com.dlstone.mybatis.analysis.jdbc;

import com.dlstone.mybatis.analysis.sample.User;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JdbcDemo {

    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.setProperty("driverClassName", "com.mysql.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://localhost:3306/mybatis_analysis");
        properties.setProperty("username", "root");
        properties.setProperty("password", "");
        DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from user where id = ?");
        preparedStatement.setString(1, "1");

        preparedStatement.execute();
        ResultSet result = preparedStatement.getResultSet();
        ResultHandle<User> resultHandle = new ResultHandle<>(result, User.class);
        User user = resultHandle.getResult();
        System.out.println(user.toString());
    }
}
