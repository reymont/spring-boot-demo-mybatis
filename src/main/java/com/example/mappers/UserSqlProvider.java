package com.example.mappers;


import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Zhangkh on 2017/3/6.
 */
public class UserSqlProvider {
    public String get(String userName) {
        return new SQL()
                .SELECT("userid,username,deptid,mobile")
                .FROM("T_USER")
                .WHERE("username=#{userName}").toString();
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
    public String getData(){
        return new SQL()
                .SELECT("userid,username,deptid,mobile")
                .FROM("T_USER")
                .WHERE("deptid='11031'").toString();

    }
}
