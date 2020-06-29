/**
 * FileName: Address
 * Author:   嘉平十七
 * Date:     2020/6/29 13:50
 * Description: 地址类
 * History:
 * notes：配合雇员类Employee使用
 */
package com.jsp_demo.java;

public class Address {
    private String city;
    private String street;
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}