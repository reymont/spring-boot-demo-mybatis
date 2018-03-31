package com.example.mappers;

import com.example.entity.User;
import com.example.entity.UserA;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * Created by Zhangkh on 2017/3/6.
 */
public interface UserMapper {
    @SelectProvider(type = UserSqlProvider.class, method = "get")
    List<User> get(String userName);

    @SelectProvider(type = UserSqlProvider.class, method = "getData")
    List<Map> getData();

    @InsertProvider(type = UserSqlProvider.class, method = "insert")
        //@SelectKey(statement = "SELECT CURRVAL('t_user_id_seq')", keyProperty = "id", before = false, resultType = Long.class)
    int insert(UserA user);
}
