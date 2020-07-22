package com.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @SpringBootApplication 来标注一个主程序类，说明这是一个SpringBoot应用
 * @ImportResource(locations = {"classpath:spring.xml"}) 加载spring.xml文件
 * @MapperScan("con.springboot.mapper") 扫描包下的所有mapper接口，mapper文件可以不使用@Mapper注解
 */
//@ImportResource(locations = {"classpath:spring.xml"})
@SpringBootApplication
@MapperScan("con.springboot.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
