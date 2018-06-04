package com.lmf.entity;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;

/**
 * com.lmf.entity
 * <p>
 * root创建于18-6-4
 * TODO:进行描述
 **/
public class BaiduNews {


        @ExtractBy("//h3[@class='c-title']/a/text()")
        private String name;

        @ExtractBy("//div[@class='c-summary']/text()")
        private String description;

        @Override
        public String toString() {
            return "BaiduNews{" +
                    "name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }

        public static void main(String[] args) {
            OOSpider ooSpider = OOSpider.create(Site.me().setSleepTime(0), BaiduNews.class);
            //single download
            BaiduNews baike = ooSpider.<BaiduNews>get("http://news.baidu.com/ns?tn=news&cl=2&rn=20&ct=1&fr=bks0000&ie=utf-8&word=httpclient");
            System.out.println(baike);

            ooSpider.close();
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

}
