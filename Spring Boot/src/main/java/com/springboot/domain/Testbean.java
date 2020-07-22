/**
 * FileName: Testbean
 * Author:   嘉平十七
 * Date:     2020/7/22 18:01
 * Description: 赋值
 * notes：
 */
package com.springboot.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties("testbean")
public class Testbean {
    private String name;
    private Integer age;
    private Date birth;

    private Map<String,Object> maps;
    private List<Object> lists;

    private Testbean1 testbean1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Testbean1 getTestbean1() {
        return testbean1;
    }

    public void setTestbean1(Testbean1 testbean1) {
        this.testbean1 = testbean1;
    }
}