package com.example.mappers;


import com.example.entity.UserA;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Zhangkh on 2017/3/6.
 */
public class UserSqlProvider {
    public String get(String name) {
        return new SQL()
                .SELECT("employee_number,name,dep")
                .FROM("zts_user")
//                .WHERE("name=#{name}")
                .toString();
        /*
        {
            {
                SELECT("userid,username,deptid,mobile");
                FROM("T_USER");
                WHERE("username=#{userName}");
            }
        }.toString();
        */
    }

    public String getData() {
        return new SQL()
                .SELECT("userid,username,deptid,mobile")
                .FROM("T_USER")
                .WHERE("deptid='11031'").toString();

    }

    public String insert(final UserA user) {
        return new SQL() {{
            INSERT_INTO("t_user_a");
            VALUES("id", "#{id}");
            VALUES("name", "#{name}");
        }}.toString();
    }
}
