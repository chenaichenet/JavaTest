/**
 * FileName: GetSetDemo
 * Author:   嘉平十七
 * Date:     2020/3/12 11:33
 * Description:get、set方法演示
 * History:
 */
package com.servlet_filter_listener_demo;

class Action{
    public String name;
    public int id;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

public class GetSetDemo {
    public static void main(String ags[]){
        Action a=new Action();
        a.setName("abcd");
        a.setId(10);
        System.out.println(a.getName());
        System.out.println(a.getId());

    }
}