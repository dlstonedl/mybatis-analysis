package com.dlstone.mybatis.analysis.sample;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisAnalysis {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User user = mapper.selectUser("1");
            System.out.println(user);

            User user1 = mapper.selectUserByNameAndSex("bbb", "female");
            System.out.println(user1);

            mapper.updateUser("1", "ccc");
            User user2 = mapper.selectUser("1");
            System.out.println(user2);
        } finally {
            sqlSession.close();
        }

    }
}
