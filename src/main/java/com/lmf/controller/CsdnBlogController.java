package com.lmf.controller;

import com.alibaba.fastjson.JSON;
import com.lmf.processor.TestProcess;
import com.lmf.service.CsdnBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import us.codecraft.webmagic.Spider;

/**
 * com.lmf.controller
 * <p>
 * root创建于18-6-4
 * TODO:进行描述
 **/
@Controller
public class CsdnBlogController{

    private static String username = "puppet_";// 设置csdn用户名
    private static int size = 0;// 共抓取到的文章数量
    @Autowired
    CsdnBlogService csdnBlogService;



    /**
     * 爬取CSDN博客
     */
    @RequestMapping(value = "getBlog",method = RequestMethod.GET)
    @ResponseBody
    public void blogSpider(){
        Spider.create(new TestProcess(csdnBlogService)).addUrl("https://blog.csdn.net/"+username).thread(1).run();
    }
}
