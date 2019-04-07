package com.dlstone.mybatis.analysis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo {

    public static void main(String[] args) throws Exception{
        Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/mybatis_analysis",
                        "root",
                        "");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from user where id = ?");
        preparedStatement.setString(1, "1");

        preparedStatement.execute();
        ResultSet result = preparedStatement.getResultSet();
        while(result.next()) {
            System.out.println(result.getInt("id"));
            System.out.println(result.getString("username"));
            System.out.println(result.getString("sex"));
            System.out.println(result.getInt("age"));
        }
    }
}
