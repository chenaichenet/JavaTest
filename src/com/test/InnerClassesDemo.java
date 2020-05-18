/**
 * FileName: InnerClassesDemo
 * Author:   嘉平十七
 * Date:     2020/3/22 17:01
 * Description: 内部类
 * History:
 * notes：
 */
package com.test;
class Outer{//外部类
    private String msg="消息";//私有成员属性

    public void fun(){//普通方法
        //思考五：需要讲当前对象传递到Inner类之中
        Inner in = new Inner(this);//实例化内部类对象
        in.print();//调用内部类方法
    }
    /*Inner在Outer类之中的时候*/
//    class Inner{//在Outer类的内部定义了Inner类
//        public void print(){
//            System.out.println(Outer.this.getMsg());//Outer类中的属性
//        }
//    }
    //思考一：msg属性如果要被外部访问需要getter方法
    public String getMsg(){
        return this.msg;
    }
}
class Inner{//在Outer类的内部定义了Inner类
    //思考三：Inner这个类对象实例化的时候需要Outer类的引用
    private Outer out;
    //思考四：应该通过Inner类的构造方法获取Outer类对象
    public Inner(Outer out){
        this.out=out;
    }
    public void print(){
        //思考二：如果需要调用外部类中的getter方法，一定需要Outer类对象
        System.out.println(this.out.getMsg());//Outer类中的属性
    }
}
public class InnerClassesDemo {
    public static void main(String[] args){
        Outer out=new Outer();//实例化外部类对象
        out.fun();//调用外部类中的方法
    }
}