package com.dlstone.mybatis.analysis.sample;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User selectUser(@Param("id") String id);

    User selectUserByNameAndSex(@Param("username") String username, @Param("sex") String sex);

    void updateUser(@Param("id") String id, @Param("username") String username);
}
