/**
 * FileName: CallableDemo
 * Author:   嘉平十七
 * Date:     2020/5/16 8:15
 * Description: Callable实现多线程
 * History:
 * notes：
 */
package main.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws Exception{
        FutureTask<String> task=new FutureTask<>(new MyThread3());
        new Thread(task).start();
        System.out.println("线程返回数据："+task.get());
    }
}
class MyThread3 implements Callable<String>{

    @Override
    public String call() throws Exception {
        for (int x=0;x<5;x++){
            System.out.println("执行线程：x="+x);
        }
        return "线程执行完毕";
    }
}