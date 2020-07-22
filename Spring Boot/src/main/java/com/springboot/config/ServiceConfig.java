/**
 * FileName: ServiceConfig
 * Author:   嘉平十七
 * Date:     2020/7/22 18:10
 * Description: 配置类
 * notes：
 */
package com.springboot.config;

import com.springboot.service.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public TestService testService(){
        return new TestService();
    }
}