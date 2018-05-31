package com.lmf.controller;

import com.alibaba.fastjson.JSON;
import com.lmf.entity.User;
import com.lmf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static java.lang.System.out;

/**
 * com.lmf.controller
 * <p>
 * root创建于18-5-31
 * TODO:进行描述
 **/
@Controller
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public String register(@RequestBody User user){
        user.setId(new Date().getTime());
        userService.addUser(user);
        String json = JSON.toJSONString(user);
        return json;
    }
}
