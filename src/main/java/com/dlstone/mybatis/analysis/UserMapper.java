package com.dlstone.mybatis.analysis;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User selectUser(@Param("id") String id);
}
