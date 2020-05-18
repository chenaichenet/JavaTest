/**
 * FileName: DeadLock
 * Author:   嘉平十七
 * Date:     2020/5/16 10:46
 * Description: 死锁
 * History:
 * notes：
 */
package main.test.thread;

public class DeadLock implements Runnable{
    private A a=new A();
    private B b=new B();
    @Override
    public void run() {
        a.say(b);
    }
    private DeadLock(){
        new Thread(this).start();
        b.say(a);
    }
    public static void main(String[] args) {
        new DeadLock();
    }
}
class A{
    public synchronized void say(B str){
        System.out.println("A：A不执行，除非B停止");
        str.get();
    }
    public synchronized void get(){
        System.out.println("B停止了，A可以执行了");
    }
}
class B{
    public synchronized void say(A str){
        System.out.println("B：B不执行，除非A停止");
        str.get();
    }
    public synchronized void get(){
        System.out.println("A停止了，B可以执行了");
    }
}