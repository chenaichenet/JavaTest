/**
 * FileName: JdbcProperties
 * Author:   嘉平十七
 * Date:     2020/7/22 17:20
 * Description:
 * notes：
 */
package com.springboot.config;

import org.springframework.context.annotation.Configuration;

//@Configuration
//@ConfigurationProperties(prefix = "jdbc")
public class JdbcProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}