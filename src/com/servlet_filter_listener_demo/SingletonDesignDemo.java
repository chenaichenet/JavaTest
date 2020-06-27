/**
 * FileName: SingletonDesignDemo
 * Author:   嘉平十七
 * Date:     2020/3/20 10:39
 * Description: 单例设计演示
 * History:
 * notes：
 */
package com.servlet_filter_listener_demo;
class Sing{
    private static final Sing INSTANCE=new Sing();//使用final关键字，让其只能实例化一个对象
    private Sing(){}
    public static Sing getInstance(){
//        instance=new Sing();
        return INSTANCE;
    }
    public void print(){
        System.out.println("单例设计");
    }
}
public class SingletonDesignDemo {
    public static void main(String args[]){
        Sing instance=null;
        /*
        * instance一定要是空，
        * 让其等于空，随后调用getInstance方法，返回一个final值，而final值中定义的就是唯一的实例化
        * 所以，单例设计，就是通过使用static final关键字定义的一个唯一的实例化方法，随后通过类中自定义的方法去调用，便可只产生一个实例化对象。*/
        instance=Sing.getInstance();
        instance.print();
    }
}