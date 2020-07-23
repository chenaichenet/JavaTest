/**
 * FileName: MvcConfig
 * Author:   嘉平十七
 * Date:     2020/7/22 18:17
 * Description: SpringMVC配置类
 * notes：
 */
package com.springboot.config;

import com.springboot.interceptor.TestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    //注册拦截器
    @Bean
    public TestInterceptor testInterceptor(){
        System.out.println("注册拦截器");
        return new TestInterceptor();
    }
    //添加拦截器到springmvc拦截器链
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("拦截所有请求路径");
        //拦截所有请求路径
        registry.addInterceptor(testInterceptor()).addPathPatterns("/*");
    }
}