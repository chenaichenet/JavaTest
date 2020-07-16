/**
 * FileName: Param
 * Author:   嘉平十七
 * Date:     2020/7/16 18:10
 * Description: 使用Java对象传递参数
 * notes：
 */
package com.demo3.vo;

public class Param {
    //属性名和请求中参数名一样
    private String name;
    private int age;

    public Param() {
        System.out.println("===Param无参构造===");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName："+name);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("setAge："+age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Param{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}