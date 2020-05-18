/**
 * FileName: ThreadDemo5
 * Author:   嘉平十七
 * Date:     2020/5/16 11:31
 * Description: 停止线程与守护线程
 * History:
 * notes：
 */
package main.test.thread;

public class ThreadDemo5 {
    public static boolean flag=true;

    public static void main(String[] args) throws Exception{
        /*设置全局静态变量，通过线程sleep控制停止*/
//        new Thread(()->{
//            long num=0;
//            while(flag){
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName()+"正在运行：num="+num);
//            }
//        },"执行线程").start();
//        Thread.sleep(200);
//        flag=false;

        /*线程守护*/
        Thread userThread=new Thread(()->{
            for (int x=0;x<10;x++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"正在运行：x="+x);
            }
        },"用户线程");
        Thread daemonThread=new Thread(()->{
            for (int x=0;x<5;x++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println(Thread.currentThread().getName()+"正在运行：x="+x);
            }
        },"守护线程");
        daemonThread.setDaemon(true);   //设置为守护线程
        userThread.start();
        daemonThread.start();
    }
}