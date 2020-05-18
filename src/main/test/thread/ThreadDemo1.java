/**
 * FileName: ThreadDemo1
 * Author:   嘉平十七
 * Date:     2020/5/15 16:51
 * Description: 多线程实现
 * History:
 * notes：
 */
package main.test.thread;
class MyThread1 extends Thread{
    private String title;
    public MyThread1(String title){
        this.title=title;
    }

    @Override
    public void run() {
        for (int x=0;x<3;x++){
            System.out.println(this.title+"运行，x="+x);
        }
    }
}
class MyThread2 implements Runnable{
    private String title;
    public MyThread2(String title){
        this.title=title;
    }
    @Override
    public void run() {
        for (int x=0;x<3;x++){
            System.out.println(this.title+"运行，x="+x);
        }
    }
}
public class ThreadDemo1 {
    public static void main(String[] args) {
        /*继承Thread的MyThread1*/
//        MyThread1 mt=new MyThread1("threadA");
//        mt.start();

        /*实现Runnable接口的MyThread2*/
//        Thread threadA=new Thread(new MyThread2("线程对象A"));
//        Thread threadB=new Thread(new MyThread2("线程对象B"));
//        Thread threadC=new Thread(new MyThread2("线程对象C"));
//        threadA.start();
//        threadB.start();
//        threadC.start();

        /*匿名内部类实现多线程*/
//        for (int x=0;x<3;x++){
//            String title="线程对象-"+x;
//            Runnable run=()->{
//                for (int y=0;y<5;y++)
//                    System.out.println(title+"运行，y="+y);
//            };
//            new Thread(run).start();
//        }

        for (int x=0;x<3;x++){
            String title="线程对象-"+x;
            new Thread(()->{
                for (int y=0;y<5;y++){
                    System.out.println(title+"运行，y="+y);
                }
            }).start();
        }

    }
}