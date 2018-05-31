package com.lmf.controller;

import com.lmf.entity.User;
import com.lmf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * com.lmf.controller
 * <p>
 * root创建于18-5-30
 * TODO:进行描述
 **/
@Controller
@EnableAutoConfiguration
public class ExampleController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    User addUser(){
        User u = new User();
        u.setId(new Date().getTime());
        u.setName("zhangsna");
        u.setPassword("123456");
        User user = userService.addUser(u);
        return user;
    }

    @RequestMapping("/index")
    String index(){
        return  "index";
    }

    @RequestMapping("/register")
    String register(){
        return "register";
    }
}
