/**
 * FileName: Student
 * Author:   嘉平十七
 * Date:     2020/7/6 11:27
 * Description:
 * History:
 * notes：
 */
package com.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
//    @Value("基于注解的DI实现")
    @Value("${name}")   //使用EL
    private String name;
    @Value("20")
    private int age;

    @Autowired(required = true)
//    @Qualifier(value = "school")

    private School school;
    public Student() {
        System.out.println("=====Student无参构造=====");
    }

    public Student(String name, int age, School school) {
        System.out.println("=====Student有参构造=====");
        this.name = name;
        this.age = age;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}