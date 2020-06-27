/**
 * FileName: Dong
 * Author:   嘉平十七
 * Date:     2020/3/11 17:29
 * 描述:     包括了接口（interfance)、Vertor(动态数组）、枚举（enumeration）
 * 历史:
 */
package com.servlet_filter_listener_demo;

import java.util.Scanner;

class MessageImpl implements IMessage{

    @Override
    public String message() {
        if(this.connect()) {
            return "发送消息";
        }
        return "没有消息";
    }
}
class Bread implements IFood{

    @Override
    public void eat() {
        System.out.println("吃面包");
    }
}
class Milk implements IFood{

    @Override
    public void eat() {
        System.out.println("喝牛奶");
    }
}
class Factory{
    public static IFood getFood(String className){
        if("bread".equals(className)){
            return new Bread();
        }
        else if("milk".equals(className)){
            return new Milk();
        }
        else return null;
    }
}
public  class InterfaceDemo implements InterfaceDemo2 {

    @Override
    public String eat() {
        System.out.println("重写接口中的eat方法");
        return null;
    }

    public static void main(String args[]) {
//        InterfaceDemo2 qe=new InterfaceDemo();//向上转型实例化
//        System.out.println(InterfaceDemo2.i);
//        System.out.println(qe.eat());

        /*工厂模式设计*/
        try {
            Scanner sr=new Scanner(System.in);
            String a=sr.next();
            IFood food=Factory.getFood(a);
            food.eat();
        }catch (Exception e){}


        /**/
        IMessage se=IMessage.getInstance();
        System.out.println(se.message());

        /*Vertor数组*/
//        InterfaceDemo qw = new InterfaceDemo();
//        qw.eat();
//        Vector a=new Vector();
//        for(int i=0;i<3;i++){
//            Scanner sr=new Scanner(System.in);
//            int n=sr.nextInt();
//            a.addElement(n);
//        }
//        Enumeration e=a.elements();
//        while (e.hasMoreElements()){
//            System.out.println(e.nextElement());
//        }
    }
}