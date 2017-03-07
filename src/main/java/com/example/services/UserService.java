package com.example.services;

import com.example.entity.User;
import com.example.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zhangkh on 2017/3/7.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User get(String userName) {
        return userMapper.get(userName);
    }
}
