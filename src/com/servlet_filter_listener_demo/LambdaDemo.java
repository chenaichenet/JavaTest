/**
 * FileName: LambdaDemo
 * Author:   嘉平十七
 * Date:     2020/3/20 20:31
 * Description: Java8的lambda表达式
 * History:
 * notes：
 */
package com.servlet_filter_listener_demo;
interface Print{
    void print(String val);
}
//第三个例子
interface IPrint{
    void print();
}
public class LambdaDemo {
    public static void main(String args[]){
        LambdaDemo L=new LambdaDemo();
        String some="打印输出";

        /*不用lamda表达式的常规方法*/
//        Print print=new Print() {
//            @Override
//            public void print(String val) {
//                System.out.println(val);
//            }
//        };
        /*标准的lamda表达式*/
//        Print print=(String val)->{
//            System.out.println(val);
//        };

        /*这里是因为只有一个参数*/
        Print print=val -> System.out.println(val);

        L.PrintSomething(some,print);
        /*还可以直接放在语句中*/
        L.PrintSomething(some,val -> System.out.println(val));

        /*第二个例子*/
        LambdaDemo t=new LambdaDemo();
        LambdaDemo.IAdd s=((x, y) -> x+y);
        System.out.println(t.add(1,2,s));

        /*第三个例子*/
        //        IPrint t =new IPrint(){
//            @Override
//            public void print() {
//                System.out.println("匿名函数实现");
//            }
//        };
//        t.print();
        //这是使用匿名函数调用接口中的方法
        
        IPrint w=()->{System.out.println("匿名函数的lambda实现");};
        w.print();
        /*lambda表达式最重要的就是省去了匿名对象的繁杂，使代码更加简洁*/
    }
    public void PrintSomething(String something,Print print){
        print.print(something);
    }
    /*第二个例子*/
    public int add(int x, int y, LambdaDemo.IAdd iAdd){
        return iAdd.sum(x, y);
    }
    interface IAdd {
        int sum(int x, int y);
    }
}