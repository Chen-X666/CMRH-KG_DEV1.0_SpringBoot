package com.canton.service.impl;

import com.canton.dao.entity.User;
import com.canton.dao.mapper.UserMapper;
import com.canton.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther Chen
 * @Date 2020.3.18
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryAllUsers() {

        return userMapper.queryAllUsers();
    }
}
