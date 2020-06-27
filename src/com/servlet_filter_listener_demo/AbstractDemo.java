/**
 * FileName: ExtendDemo
 * Author:   嘉平十七
 * Date:     2020/3/12 11:30
 * Description:抽象问题
 * History:
 */
package com.servlet_filter_listener_demo;

abstract class Animal{
    public int n;
    abstract void eat();
    public void max(int a, int b){
        System.out.println((a>b)?a:b);
        System.out.println("抽象类中的方法");
    }
    public static Animal awer(){
        return new Max();
    }
}

class Cat extends Animal{
    public void eat(){
        System.out.println("猫吃鱼");
    }
    public void work(){
        System.out.println("猫抓老鼠");
    }
}
class Dog extends Animal{
    public void eat(){
        System.out.println("狗吃骨头");
    }
    public void work(){
        System.out.println("狗看家");
    }
}

class Max extends Animal{
    public void eat(){

    }
    @Override
    public void max(int a, int b) {
        super.max(a, b);
        System.out.println("子类中的方法");
    }
}

public class AbstractDemo {
    public static void main(String args[]){
//        Animal a=new Cat();
//        a.eat();
//        Cat c=(Cat)a;
//        c.work();
//
//        Animal b=new Dog();
//        b.eat();
//        Dog d=(Dog)b;
//        d.work();
//
//        Animal e=new Max();//向上转型
//        e.max(80,2);
        System.out.println();
    }
}