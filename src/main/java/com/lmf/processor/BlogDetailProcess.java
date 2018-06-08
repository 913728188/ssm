package com.lmf.processor;

import com.lmf.entity.CsdnBlog;
import com.lmf.service.CsdnBlogService;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

/**
 * com.lmf.processor
 * <p>
 * root创建于18-6-8
 * TODO:博客详情
 **/
public class BlogDetailProcess implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    Long key = 0l;
    String title ;
    String date ;
    private CsdnBlogService csdnBlogService;
    public BlogDetailProcess(Long key,String title ,
            String date ,CsdnBlogService csdnBlogService){
        this.key = key;
        this.title = title;
        this.date = date;
        this.csdnBlogService = csdnBlogService;
    }
    @Override
    public Site getSite() {
        return site;
    }
    @Override
    public synchronized void process(Page page) {

        Html all = page.getHtml();
        String content = all.xpath("//div[@class='markdown_views']").get();
        CsdnBlog csdnBlog = new CsdnBlog();
        csdnBlog.setId(key);
        csdnBlog.setDate(date);
        csdnBlog.setTitle(title);
        csdnBlog.setContent(content);
        if(csdnBlog.getContent() != null) {
            csdnBlogService.save(csdnBlog);
        }
    }
}
