package com.example.controllers;


import com.example.entity.User;
import com.example.services.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zhangkh on 2017/3/6.
 */
@RestController(value = "userController")
@RequestMapping("/v1")
public class UserController {
    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    @ApiOperation(notes = "getPerSon",httpMethod = "GET",value = "get person")
    public User getPerson(@ApiParam(value = "姓名")@RequestParam(value = "name", required = false) String userName) {
        logger.debug("request "+userName);
        return userService.get(userName);
    }
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public void getData(@RequestParam(value = "grade") int grade)
    {
        userService.getData(grade);
    }

}
