package com.dlstone.mybatis.analysis.sample;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User selectUser(@Param("id") String id);
}
