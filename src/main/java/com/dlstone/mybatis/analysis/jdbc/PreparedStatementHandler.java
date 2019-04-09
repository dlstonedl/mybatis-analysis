package com.dlstone.mybatis.analysis.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PreparedStatementHandler {
    private String sql;
    private List<String> params;
    private Connection connection;

    public PreparedStatementHandler(String originSql, Connection connection) {
        this.sql = getBoundSql(originSql);
        this.connection = connection;
        this.params = getSqlParams(originSql);
    }

    public PreparedStatement getPreparedStatement(Map<String, Object> paraMap) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < params.size(); i++) {
            if (!paraMap.containsKey(params.get(i))) {
                continue;
            }

            Object object = paraMap.get(params.get(i));
            if (object instanceof Integer) {
                preparedStatement.setInt(i + 1, (Integer)object);
            } else if (object instanceof String){
                preparedStatement.setString(i + 1, (String)object);
            }
        }

        return preparedStatement;
    }

    private String getBoundSql(String originSql) {
        return originSql.replaceAll("#\\{[a-z]+\\}", "?");
    }

    private List<String> getSqlParams(String originSql) {
        List<String> params = new ArrayList<>();

        Pattern pattern = Pattern.compile("#\\{([a-z]+)\\}");
        Matcher matcher = pattern.matcher(originSql);
        while (matcher.find()) {
            String param = matcher.group(1);
            params.add(param);
        }

        return params;
    }


}
