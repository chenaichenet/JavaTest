/**
 * FileName: Thymeleaf
 * Author:   嘉平十七
 * Date:     2020/7/25 15:13
 * Description: Thymeleaf模板的测试实体类
 * notes：
 */
package com.springboot.domain;

import java.io.Serializable;

public class Thymeleaf implements Serializable {
    private String thymeleafName;
    private String thymeleafMsg;

    public Thymeleaf(String thymeleafName, String thymeleafMsg) {
        this.thymeleafName = thymeleafName;
        this.thymeleafMsg = thymeleafMsg;
    }

    public Thymeleaf() {
    }

    public String getThymeleafName() {
        return thymeleafName;
    }

    public void setThymeleafName(String thymeleafName) {
        this.thymeleafName = thymeleafName;
    }

    public String getThymeleafMsg() {
        return thymeleafMsg;
    }

    public void setThymeleafMsg(String thymeleafMsg) {
        this.thymeleafMsg = thymeleafMsg;
    }
}