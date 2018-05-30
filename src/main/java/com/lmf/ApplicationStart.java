package com.lmf;

import com.lmf.controller.ExampleController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * com.lmf
 * <p>
 * root创建于18-5-30
 * TODO:进行描述
 **/

@SpringBootApplication
@MapperScan("com.lmf.Mapper")
@ComponentScan("com")
public class ApplicationStart  {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationStart.class, args);
    }
}
