/**
 * FileName: ThreadDemo2
 * Author:   嘉平十七
 * Date:     2020/5/16 8:23
 * Description: 多线程常用方法
 * History:
 * notes：
 */
package main.test.thread;

public class ThreadDemo2 {
    public static void main(String[] args) {
        /*设置线程名字*/
//        MyThread4 mt=new MyThread4();
//        new Thread(mt,"线程A").start();
//        new Thread(mt).start();
//        new Thread(mt).start();
//        new Thread(mt,"线程B").start();
//        mt.run();   //获取的是main，主线程名字

        /*睡眠*/
//        for (int num=0;num<5;num++){
//            new Thread(()->{
//                for (int x = 0 ; x < 10 ; x ++) {
//                    System.out.println(Thread.currentThread().getName() + "、x = " + x);
//                    try {
//                        Thread.sleep(1000);	// 暂缓执行
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            },"线程对象-"+num).start();
//        }

//        Runnable run=()->{
//            for (int x=0;x<10;x++){
//                System.out.println(Thread.currentThread().getName()+"、x="+x);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        for (int num=0;num<5;num++){
//            new Thread(run,"线程对象-"+num).start();
//        }

        /*模拟睡觉和吵醒*/
//        Thread thread=new Thread(()->{
//            System.out.println("开始睡觉");
//            try {
//                Thread.sleep(10000);    //预计休眠10秒
//                System.out.println("睡足了");
//            } catch (InterruptedException e) {
//                System.out.println("吵醒了");
//            }
//        });
//        thread.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        if (!thread.isInterrupted()){
//            System.out.println("外面很吵");
//            thread.interrupt();
//        }

        /*内部类的线程优先级低于外部类的线程*/
//        Thread thread=new Thread(()->{
//            for (int x=0;x<10;x++)
//                System.out.println(Thread.currentThread().getName()+"执行、x="+x);
//        },"次线程");
//        thread.start();
//        for (int x=0;x<10;x++)
//            System.out.println("主线程、"+x);

        /*join()方法插入线程*/
//        Thread mainThread=Thread.currentThread();   //获得主线程
//        new Thread(()->{
//            for (int x=0;x<10;x++){
//                if (x==3){  //插入主线程
//                    try {
//                        mainThread.join();//主线程执行
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName()+"执行、x="+x);
//            }
//        },"次线程").start();
//        for (int x=0;x<10;x++){
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("主线程、"+x);
//        }

        /*yield(),线程礼让*/
//        new Thread(()->{
//            for (int x=0;x<10;x++){
//                if (x%3==0){
//                    Thread.yield();     //线程礼让
//                    System.out.println("次线程礼让");
//                }
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName()+"执行、x="+x);
//            }
//        },"次线程").start();
//        for (int x=0;x<10;x++){
//            try {
//                Thread.sleep(100);
//                System.out.println("主线程、"+x);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        /*线程优先级*/
//        Runnable run=()->{
//            for (int x=0;x<10;x++){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName()+"执行");
//            }
//        };
//        Thread threadA=new Thread(run,"线程对象A");
//        Thread threadB=new Thread(run,"线程对象B");
//        Thread threadC=new Thread(run,"线程对象C");
//        threadA.setPriority(Thread.MAX_PRIORITY);
//        threadB.setPriority(Thread.MIN_PRIORITY);
//        threadC.setPriority(Thread.NORM_PRIORITY);
//        threadA.start();
//        threadB.start();
//        threadC.start();

        /*默认线程优先级为5，主线程优先级也为5*/
        System.out.println(new Thread().getPriority());
        System.out.println(Thread.currentThread().getPriority());
    }
}
class MyThread4 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());   //获取线程名字
    }
}