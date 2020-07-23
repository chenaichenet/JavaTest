/**
 * FileName: Classmate
 * Author:   嘉平十七
 * Date:     2020/7/22 17:48
 * Description: 实体类
 * notes：
 */
package com.springboot.domain;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="classmate")
public class Classmate {
    //标识主键
    @Id
    private Integer id;
    private String name;
    private Integer age;
    private String address;
    private String gender;
    private Integer phone;

    @Override
    public String toString() {
        return "Classmate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                '}';
    }

    public Classmate() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}