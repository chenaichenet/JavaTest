/**
 * FileName: Polymorphism
 * Author:   嘉平十七
 * Date:     2020/3/16 16:08
 * Description: 多态的向上、向下转型
 * History:
 */
package com.servlet_filter_listener_demo;
class Parent{
    public void show(){
        System.out.println("父类方法");
    }
}
class Child extends Parent{
    public void show(){
        System.out.println("子类方法");
    }
    public void showmessign(){
        System.out.println("子类方法2");
    }
}

public class PolymorphismDemo {
    public static void main(String args[]){
        does(new Parent());//Parent sd=new Parent();
        does(new Child());//Parent sd=new Child();

        Parent sr=new Child();//向上转型
        Parent sq=new Parent();//没有转型
        Child st=(Child) sr;//向下转型
        ((Child) sr).showmessign();
        st.showmessign();

//        if(sr instanceof Child){
////            Child st=(Child)sr;//判断，如果sr是Child类型，就可以向下转型
//        }
//        System.out.println(sr instanceof Parent);
//        System.out.println(sr instanceof Child);
//        System.out.println(st instanceof Parent);
//        System.out.println(sq instanceof Parent);//true
//        System.out.println(sq instanceof Child);//false，因为sq没有转型，所以判断为false，所以，sq不能向下转型！！
    }
    public static void does(Parent sd){
        sd.show();
    }
    /*上面调用了does()方法，而does()方法中的参数的sd，sd的类型是Parent类型，即Parent sd=new Parent();
    这里就相当于一个方法的参数是int i，此时调用方法，传入参数10，即int i=10；
     */
}