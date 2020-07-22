/**
 * FileName: JdbcConfig
 * Author:   嘉平十七
 * Date:     2020/7/22 17:12
 * Description: JDBC配置类
 * notes：
 */
package com.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
//@PropertySource("classpath:jdbc.properties")
//@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig {
    /*1、使用配置文件，jdbc.properties*/
//    @Value("${jdbc.driverClassName}")
//    String driverClassName;
//    @Value("${jdbc.url}")
//    String url;
//    @Value("${jdbc.username}")
//    String username;
//    @Value("${jdbc.password}")
//    String password;
//
//    @Bean
//    public DataSource dataSource(){
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
    /*2、使用自动注入*/
//    @Bean
//    public DataSource dataSource(JdbcProperties jdbcProperties){
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(jdbcProperties.getDriverClassName());
//        dataSource.setUrl(jdbcProperties.getUrl());
//        dataSource.setUsername(jdbcProperties.getUsername());
//        dataSource.setPassword(jdbcProperties.getPassword());
//        return dataSource;
//    }
    /*3*/
//    @Bean
//    @ConfigurationProperties("jdbc")
//    public DataSource dataSource(){
//        return new DruidDataSource();
//    }
    /*4，使用连接池，就不需要在手动获取了*/
}