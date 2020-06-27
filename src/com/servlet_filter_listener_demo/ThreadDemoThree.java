/**
 * FileName: ThreadDemoThree
 * Author:   嘉平十七
 * Date:     2020/4/2 10:53
 * Description: 多线程实战——竞猜
 * History:
 * notes：//实现一个竞拍抢答程序：要求设置三个抢答者，而后同时发出抢答指令，抢答成功给出成功提示，抢答未成功给出失败提示。
 */
package com.servlet_filter_listener_demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThreadThree implements Callable<String> {
    private boolean flag=false;
    public String call() throws Exception{
        synchronized(this){
            if(this.flag==false){
                this.flag=true;
                return Thread.currentThread().getName()+"抢答成功";
            }else{
                return Thread.currentThread().getName()+"抢答失败";
            }
        }
    }
}
public class ThreadDemoThree {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThreadThree mt=new MyThreadThree();
        FutureTask<String> taskA=new FutureTask<String>(mt);
        FutureTask<String> taskB=new FutureTask<String>(mt);
        FutureTask<String> taskC=new FutureTask<String>(mt);
        new Thread(taskA,"竞赛者A").start();
        new Thread(taskB,"竞赛者B").start();
        new Thread(taskC,"竞赛者C").start();
        System.out.println(taskA.get());
        System.out.println(taskB.get());
        System.out.println(taskC.get());
    }
}