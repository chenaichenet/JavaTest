/**
 * FileName: ThreadLocalDemo
 * Author:   嘉平十七
 * Date:     2020/5/19 16:59
 * Description: ThreadLocal类
 * History:
 * notes：ThreadLocal并不是一个Thread，而是Thread的局部变量,引入ThreadLocal是为了解决多线程的并发问题
 */
package main.test.ClassLibrary;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        /*1*/
//        Message msg = new Message() ;	// 实例化消息主体对象
//        msg.setInfo("12345"); // 设置要发送的内容
//        Channel.setMessage(msg); // 设置要发送的消息
//        Channel.send(); // 发送消息
        /*2,3*/
        new Thread(()->{
            Message msg = new Message() ;	// 实例化消息主体对象
            msg.setInfo("第一个线程的消息"); // 设置要发送的内容
            Channel.setMessage(msg); // 设置要发送的消息
            Channel.send(); // 发送消息
        },"发送者A").start();
        new Thread(()->{
            Message msg = new Message() ;	// 实例化消息主体对象
            msg.setInfo("第二个线程的消息"); // 设置要发送的内容
            Channel.setMessage(msg); // 设置要发送的消息
            Channel.send(); // 发送消息
        },"发送者B").start();
        new Thread(()->{
            Message msg = new Message() ;	// 实例化消息主体对象
            msg.setInfo("第三个线程的消息"); // 设置要发送的内容
            Channel.setMessage(msg); // 设置要发送的消息
            Channel.send(); // 发送消息
        },"发送者C").start();


    }
}
/*1,2*/
//class Message{  //消息体
//    private String info;
//    public String getInfo() {
//        return info;
//    }
//    public void setInfo(String info) {
//        this.info = info;
//    }
//}
//class Channel{  //消息通道
//    private static Message message;
//    private Channel(){}
//    public static void setMessage(Message msg){
//        message=msg;
//    }
//    public static void send(){
//        System.out.println(Thread.currentThread().getName()+"、发送消息："+message.getInfo());
//    }
//}
/*3*/
class Message{  //消息体
    private String info;
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
}
class Channel{  //消息通道
    private static final ThreadLocal<Message> THREAD_LOCAL=new ThreadLocal<Message>();
    private Channel(){}
    public static void setMessage(Message msg){
        THREAD_LOCAL.set(msg);  //向ThreadLocal中保存数据
    }
    public static void send(){
        System.out.println(Thread.currentThread().getName()+"、发送消息："+THREAD_LOCAL.get().getInfo());
    }
}