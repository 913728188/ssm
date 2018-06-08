package com.lmf.processor;

import com.lmf.Util.DateUtil;
import com.lmf.entity.CsdnBlog;
import com.lmf.service.CsdnBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * com.lmf.processor
 * <p>
 * root创建于18-6-8
 * TODO:进行描述
 **/
public class TestProcess implements PageProcessor {


    private CsdnBlogService csdnBlogService;

    public TestProcess(CsdnBlogService t){
        this.csdnBlogService = t;
    }


    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);
    String contentDetail = "";
    @Override
    public synchronized void process(Page page) {
   /*     page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-])").all());
        page/a.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
      */
        System.out.println("getList");
        List<String> articleList =page.getHtml().css("div.article-item-box").all();
        for(String str : articleList) {
            Long key = System.currentTimeMillis();
           // System.out.println(key);
            Html html = new Html(str);
            String title = html.xpath("//h4[@class='text-truncate']/a/text()").get();
            String href = html.xpath("//h4[@class='text-truncate']/a").links().get();
            String content = html.xpath("//p[@class='content']/a/text()").get();
            String date = html.xpath("//span[@class='date']/text()").get();
           /* CsdnBlog blog = new CsdnBlog();
            blog.setId(key);
            blog.setDate(date);
            blog.setTitle(title);
            boolean result = csdnBlogService.save(blog);*/

            Spider.create(new BlogDetailProcess(key, title ,
                     date ,csdnBlogService)).addUrl(href).thread(1).run();


            /* System.out.println("____________");
           System.out.println(title);
            System.out.println(href);
            System.out.println(content);
            System.out.println(date);*/
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

}
