/**
 * FileName: MultithreadingDemo
 * Author:   嘉平十七
 * Date:     2020/3/30 12:31
 * Description: 多线程实战——生产者消费者问题
 * History:
 * notes：
 */
package com.servlet_filter_listener_demo;
class Message{
    private String title;
    private String content;
    //表示生产与消费的形式,flag=true，允许生产，不允许消费；flag=false，不允许生产，允许消费
    private boolean flag;
    //利用synchronized解决同步问题，保证了数据的一致
    public synchronized void set(String title,String content){
        if(this.flag==true){ //无法生产，等待被消费
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title=title;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content=content;
        this.flag=true;    //已经生产过了
        super.notify();     //唤醒等待的线程
    }
    public synchronized String get(){
        if(this.flag==false){ //还未生产，需要等待
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            return this.title+"="+this.content;
        }finally {
            this.flag=false; //继续生产
            super.notify(); //唤醒等待线程
        }
    }
}
class Producer implements Runnable{
    private Message msg;
    public Producer(Message msg){
        this.msg=msg;
    }
    @Override
    public void run() {
        for(int x=0;x<5;x++){
            if(x%2==0){
                this.msg.set("0","0");
            }else {
                this.msg.set("1","1");
            }
        }
    }
}
class Consumer implements Runnable{
    private Message msg;
    public Consumer(Message msg){
        this.msg=msg;
    }
    @Override
    public void run() {
        for(int x=0;x<5;x++){
            System.out.println(this.msg.get());
        }
    }
}
public class ThreadDemoTwo {
    public static void main(String[] args) throws Exception{
        Message msg=new Message();
        new Thread(new Producer(msg)).start();//启动生产者线程
        new Thread(new Consumer(msg)).start();//启动消费者线程
    }
}