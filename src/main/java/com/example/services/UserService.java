package com.example.services;

import com.example.entity.User;
import com.example.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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

    public void getData(int grade) {
        List<Map> result = userMapper.getData();
        for (int i = 0; i < result.size(); i++) {
            Map m = result.get(i);
            Set<Object> keys = m.keySet();
            for (Object k : keys) {
                System.out.println("field:" + k.toString() + " value:" + m.get(k).toString());
            }
        }


    }
}


