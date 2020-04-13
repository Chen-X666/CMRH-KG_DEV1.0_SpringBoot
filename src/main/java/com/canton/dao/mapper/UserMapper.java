package com.canton.dao.mapper;


import com.canton.dao.entity.User;

import java.util.List;

/**
 * @Auther ChenX
 * @Date 2020.3.18
 **/
public interface UserMapper {
    List<User> queryAllUsers();
}

