/**
 * FileName: ThreadDemo6
 * Author:   嘉平十七
 * Date:     2020/5/16 11:39
 * Description: 综合案例
 * History:
 * notes：
 */
package main.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo6 {
    public static void main(String[] args) throws Exception {
        MyThread6 mt=new MyThread6();
        FutureTask<String> taskA=new FutureTask<String>(mt);
        FutureTask<String> taskB=new FutureTask<String>(mt);
        FutureTask<String> taskC=new FutureTask<String>(mt);
        new Thread(taskA,"竞争者A").start();
        new Thread(taskB,"竞争者B").start();
        new Thread(taskC,"竞争者C").start();
        System.out.println(taskA.get());
        System.out.println(taskB.get());
        System.out.println(taskC.get());
    }
}
class MyThread6 implements Callable<String> {
    private boolean flag=false; //抢答处理
    @Override
    public String call() throws Exception {
        synchronized (this){
            if (this.flag==false){
                this.flag=true;
                return Thread.currentThread().getName()+"抢答成功";
            }else {
                return Thread.currentThread().getName()+"抢答失败";
            }
        }
    }
}