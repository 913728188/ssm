package com.lmf.controller;

import com.alibaba.fastjson.JSON;
import com.lmf.entity.CsdnBlog;
import com.lmf.processor.TestProcess;
import com.lmf.service.CsdnBlogService;
import com.lmf.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import us.codecraft.webmagic.Spider;

import java.util.ArrayList;
import java.util.List;

/**
 * com.lmf.controller
 * <p>
 * root创建于18-6-4
 * TODO:进行描述
 **/
@Controller
@EnableAutoConfiguration
public class CsdnBlogController{

    private static String username = "puppet_";// 设置csdn用户名
    private static int size = 0;// 共抓取到的文章数量
    @Autowired
    CsdnBlogService csdnBlogService;

    @Autowired
    MsgService msgService;


    /**
     * 爬取CSDN博客
     */
    @RequestMapping(value = "getBlog",method = RequestMethod.GET)
    @ResponseBody
    public void blogSpider(){
        Spider.create(new TestProcess(csdnBlogService)).addUrl("https://blog.csdn.net/"+username).thread(1).run();
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    ModelAndView index(@RequestParam String user_id){
        List list = msgService.findAll();
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        System.out.println(list.size());
        model.addObject("data",list);
        model.addObject("user",user_id);
        return  model;
    }

    @RequestMapping("/news")
    String detail(@RequestParam("id") Long id ,Model model){
        CsdnBlog blog = csdnBlogService.findById(Long.valueOf(id));
        model.addAttribute("data",blog);
        return  "news";
    }
}
