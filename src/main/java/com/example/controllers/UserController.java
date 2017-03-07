package com.example.controllers;

import com.example.entity.User;
import com.example.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Zhangkh on 2017/3/6.
 */
@RestController(value = "userController")
@RequestMapping("/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    @ApiOperation(notes = "getPerSon",httpMethod = "GET",value = "get person")
    public User getPerson(@ApiParam(value = "姓名")@RequestParam(value = "name", required = false) String userName) {
        return userService.get(userName);
    }

}
