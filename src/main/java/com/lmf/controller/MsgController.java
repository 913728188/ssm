package com.lmf.controller;

import com.alibaba.fastjson.JSON;
import com.lmf.Util.sha;
import com.lmf.entity.Msg;
import com.lmf.entity.User;
import com.lmf.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@EnableAutoConfiguration
public class MsgController {

    @Autowired
    MsgService msgService;
    @RequestMapping(value = "/addMsg",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public String signup(@RequestBody Msg msg){
        long date = new Date().getTime();
        msg.setId(date);
       msg.setCreatedAt(date);
        Msg  m = msgService.add(msg);
        String json = JSON.toJSONString(msg);
        return json;
    }
}
