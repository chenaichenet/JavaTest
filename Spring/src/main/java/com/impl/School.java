/**
 * FileName: School
 * Author:   嘉平十七
 * Date:     2020/7/6 11:28
 * Description:
 * History:
 * notes：
 */
package com.impl;

public class School {
    private String name;
    private String address;

    public School() {
        System.out.println("=====School无参构造=====");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}