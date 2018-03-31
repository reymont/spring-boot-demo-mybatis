package com.example.util;

import com.example.entity.User;
import com.example.services.UserService;
import com.example.spring.SpringContextUtil;

import java.util.List;

/**
 * Created by Zhangkh on 2017/12/25.
 */
public class BootTest {

    public static void test() {
        UserService userService = SpringContextUtil.getBean("userService");

        List<User> userList = userService.get("");
        System.out.println(JsonUtil.toJsonString(userList));
        String a = "a";
        int i = 0;
        while (true) {
            System.out.println(a);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i++);
        }
    }
}
