/**
 * FileName: ObjectDemo
 * Author:   嘉平十七
 * Date:     2020/3/16 17:57
 * Description: Object类
 * History:
 * notes：Object是一个万能的数据类型，它更加适合于进行程序的标准设计
 */
package com.servlet_filter_listener_demo;

class A{
    private String name;
    private int age;
    public A(String na,int ag){
        name=na;//this.name=name;指得是后面的name为外面接受的参数（局部变量），前面的name是类中的变量（成员变量）
        age=ag;
    }
    public String toString(){
        return "姓名："+ name+"、年龄："+age;
    }
    public boolean equals(Object obj){
        if(!(obj instanceof A)){
            return false;//当输入的不是A类型的时候比较结果为false
        }
        if (obj==null){//不关心null值比较
            return false;//否则报错
        }
        A a=(A)obj;//向下转型，目的是为了获取类中的属性，此时equals方法中有两个对象，当前对象this，传入的object
        return this.name.equals(a.name)&&this.age==a.age;
//        return this.name.equals(((A) obj).name)&&this.age==(((A)obj).age);
        /*这里就很清楚的解释了a.name，此处通过强制转型同样实现了功能，将class A中的name与传入的name比较，
        而为什么能比较是因为上面的构造方法public A（）为class中的私有变量赋值*/
    }
}

public class ObjectDemo {
    public static void main(String args[]){
//        Object sw=new A();//向上转型
//        Object arr=new int[]{1,2,3};//向上转型
//        if(sw instanceof A){
//            A st=(A)sw;
//            System.out.println("A对象向下转型成功");
//        }
//        if(arr instanceof int[]) {//是否为整型数组
//            int arry[] = (int[]) arr;//向下转型
//            System.out.println("数组向下转型成功");
//            for(int ar:arry){//增强for循环，（声明：表达式）//声明一个局部变量与数组元素匹配，表达式为访问的数组名/返回值为数组的方法
//                System.out.print(ar+"、");
//            }
//        }

//        A a=new A("陈兴",21);
//        System.out.println(a);
//        System.out.println(a.toString());//两个返回一样，所以Object中的toString方法是默认调用的，获得对象信息

        A b=new A("十七",20);
        A c=new A("十七",20);
        System.out.println(b.equals(c));
    }
}