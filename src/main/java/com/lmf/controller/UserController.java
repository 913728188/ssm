package com.lmf.controller;

import com.alibaba.fastjson.JSON;
import com.lmf.Exception.ExceptionUtil;
import com.lmf.Util.sha;
import com.lmf.VO.Login_check;
import com.lmf.VO.RetData;
import com.lmf.entity.User;
import com.lmf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Date;
import java.util.List;


/**
 * com.lmf.controller
 * <p>
 * root创建于18-5-31
 * TODO:进行描述
 **/
@Controller
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public String signup(@RequestBody User user){
        user.setId(new Date().getTime());
        userService.addUser(user);
        String json = JSON.toJSONString(user);
        return json;
    }

    @RequestMapping(value = "/login",method=RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login",method=RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public String login_check(@RequestBody Login_check user) {
        RetData retData = new RetData();
        if(StringUtil.isNotEmpty(user.getEmail()) && StringUtil.isNotEmpty(user.getPassword())){
            User u = userService.login(user.getEmail(),sha.encry256(user.getPassword()));
            if(u != null){
                retData =  retData.build(200,"登录成功!",u);

            }else{
                retData = retData.build(201,"登录失败!",null);
            }
            return JSON.toJSONString(retData);
        }else{
            return ExceptionUtil.paramException();
        }
    }

    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public String signup(){
        return "signup";
    }

    @RequestMapping("/updatePwd")
    @ResponseBody
    public String updatePwd(@RequestBody String name){

        String json = JSON.toJSONString(null);
        return json;
    }

    /**
     * 修改用户密码为
     * sha256
     */
/*    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(){
        List<User> list = userService.findAll();
        for(User u : list){
            u.setPassword(sha.encry256(u.getPassword()));
            boolean bool = userService.update(u);
            System.out.println(bool);
        }
        return JSON.toJSONString(list);
    }*/

}
