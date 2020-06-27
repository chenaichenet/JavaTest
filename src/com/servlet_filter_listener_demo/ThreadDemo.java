/**
 * FileName: ThreadDemo
 * Author:   嘉平十七
 * Date:     2020/3/28 12:08
 * Description: Thread类实现多线程
 * History:
 * notes：
 */
package com.servlet_filter_listener_demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/*继承Thread类实现多线程*/
//class  MyThread extends Thread{ //线程的主体类
//    private String title;
//    public MyThread(String title){
//        this.title=title;
//    }
//
//    @Override
//    public void run() { //线程的主体方法
//        for(int x=0;x<10;x++){
//            System.out.println(this.title+"运行，x="+x);
//        }
//    }
//}
/*Runnable接口实现多线程*/
//class  MyThread implements Runnable{ //线程的主体类
//    private String title;
//    public MyThread(String title){
//        this.title=title;
//    }
//
//    @Override
//    public void run() { //线程的主体方法
//        for(int x=0;x<10;x++){
//            System.out.println(this.title+"运行，x="+x);
//        }
//    }
//}
/*Callable接口实现多线程*/
class MyThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        for(int x=0;x<10;x++){
            System.out.println("线程执行----"+x);
        }
        return "线程执行完毕";
    }
}
public class ThreadDemo {
    public static void main(String[] args) throws Exception{
        /*继承Thread类实现多线程*/
//        new MyThread("线程A").start();
//        new MyThread("线程B").start();
//        new MyThread("线程C").start();

        /*Runnable接口*/
//        for(int x=0;x<3;x++) {
//            String title="线程对象-"+x;
//            Runnable run=()->{
//                for(int y=0;y<10;y++) {
//                    System.out.println(title+"运行，y="+y);
//                }
//            };
//            new Thread(run).start();
//        }
        /*Callable接口*/
        FutureTask<String> task=new FutureTask<>(new MyThread());
        new Thread(task).start();
        System.out.println("线程返回数据："+task.get());
    }
}