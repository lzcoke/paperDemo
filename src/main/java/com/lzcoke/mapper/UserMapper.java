package com.lzcoke.mapper;

import com.lzcoke.pojo.User;

public interface UserMapper {

    // 登录信息
    User Login(String email, String password);
}
