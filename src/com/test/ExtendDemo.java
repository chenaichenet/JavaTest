/**
 * FileName: ExtendDemo2
 * Author:   嘉平十七
 * Date:     2020/3/12 11:37
 * Description:继承问题演示
 * History:
 */
package com.test;

import java.util.Scanner;

class Persion{
    private String name;
    private int age;

    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }

    protected void eat(){
        System.out.println("父类方法");
    }
    private void art(){
        System.out.println("父类私有方法");
    }
}

class Student extends Persion{
    private String sid;

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSid() {
        return sid;
    }

    protected void eat(){
        System.out.println("子类方法");
    }
    protected void eat(int n){
        System.out.println("子类方法2");
    }

    protected void eatT(){
        super.eat();
        this.eat();
    }
}

public class ExtendDemo {
    public static void main(String args[]){
        Scanner sr=new Scanner(System.in);
        String name=sr.next();
        int age=sr.nextInt();
        String sid=sr.next();

        Persion a=new Persion();
        Student per=new Student();

        per.setName(name);
        per.setAge(age);
        per.setSid(sid);
        System.out.println(per.getName()+"\n"+per.getAge()+"\n"+per.getSid());

        a.eat();
        per.eat();
        per.eat(1);
        per.eatT();

    }
}