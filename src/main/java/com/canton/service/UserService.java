package com.canton.service;

import com.canton.dao.entity.User;

import java.util.List;

/**
 * @Auther Chen
 * @Date 2020.3.18
 **/
public interface UserService {
    List<User> queryAllUsers();
}
