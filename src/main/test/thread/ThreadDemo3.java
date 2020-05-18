/**
 * FileName: ThreadDemo3
 * Author:   嘉平十七
 * Date:     2020/5/16 10:04
 * Description: 线程的同步与死锁
 * History:
 * notes：
 */
package main.test.thread;

class MyThread5 implements Runnable{

//    private int ticket=10;  //票数为10
//    /*覆写run()方法执行的模拟窗口售票*/
//    @Override
//    public void run() {
//        while (true){
//            synchronized (this){    //每次只允许一个线程访问
//                if (this.ticket>0){
//                    try {
//                        Thread.sleep(100);    //模拟网络延迟
//                        Thread.yield();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName()+"售票：ticket="+ticket--);
//                }else {
//                    System.out.println(Thread.currentThread().getName()+"：票已售罄");
//                    break;
//                }
//            }
//        }
//    }

    /*添加一个同步方法控制，而不是通过run方法种的同步控制*/
    private int ticket=10;
    public synchronized boolean sale(){
        if (this.ticket>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"售票：tickte="+this.ticket--);
            return true;
        }else {
            System.out.println(Thread.currentThread().getName()+"：票已售罄");
            return false;
        }
    }
    @Override
    public void run() {
        while (this.sale()){}
    }

}
public class ThreadDemo3 {
    public static void main(String[] args) {
        MyThread5 mt=new MyThread5();
        new Thread(mt,"窗口1").start();
        new Thread(mt,"窗口2").start();
        new Thread(mt,"窗口3").start();
    }
}