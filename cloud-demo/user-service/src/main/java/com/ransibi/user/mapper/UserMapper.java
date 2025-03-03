package com.ransibi.user.mapper;

import com.ransibi.user.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User findById(@Param("id") Long id);
}