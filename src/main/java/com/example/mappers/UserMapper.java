package com.example.mappers;

import com.example.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * Created by Zhangkh on 2017/3/6.
 */
public interface UserMapper {
    @SelectProvider(type = UserSqlProvider.class,method = "get")
    User get(String userName);
    @SelectProvider(type = UserSqlProvider.class,method = "getData")
    List<Map> getData();
}
