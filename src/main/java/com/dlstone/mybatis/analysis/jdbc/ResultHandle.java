package com.dlstone.mybatis.analysis.jdbc;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultHandle<T> {
    private ResultSet resultSet;
    private Class<T> resultType;

    public ResultHandle(ResultSet resultSet, Class<T> resultType) {
        this.resultSet = resultSet;
        this.resultType = resultType;
    }

    public <T> T getResult() throws Exception {
        List<String> columns = getDataBaseColumn();
        resultSet.next();
        Object instance = resultType.newInstance();

        Method[] methods = resultType.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                String property = method.getName().substring(3, method.getName().length());
                if (columns.contains(property.toLowerCase())) {
                    Parameter[] parameters = method.getParameters();
                    for (Parameter parameter : parameters) {
                        String simpleName = parameter.getType().getSimpleName();
                        switch (simpleName) {
                            case "int":
                                int resultSetInt = resultSet.getInt(property.toLowerCase());
                                method.invoke(instance, resultSetInt);
                                break;
                            case "String":
                                String resultSetString = resultSet.getString(property.toLowerCase());
                                method.invoke(instance, resultSetString);
                                break;
                        }
                    }
                }
            }
        }
        return (T) instance;
    }


    private List<String> getDataBaseColumn() throws SQLException {
        List<String> columnNames = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            columnNames.add(metaData.getColumnName(i));
        }
        return columnNames;
    }

}
