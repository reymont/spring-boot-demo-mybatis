package com.example.mappers;

import com.example.entity.User;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

/**
 * Created by Zhangkh on 2017/3/6.
 */
public interface UserMapper {
    @SelectProvider(type = UserSqlProvider.class,method = "get")
    User get(String userName);
}
