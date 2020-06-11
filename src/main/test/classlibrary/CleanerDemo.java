/**
 * FileName: CleanerDemo
 * Author:   嘉平十七
 * Date:     2020/5/18 15:02
 * Description:
 * History:
 * notes：
 */
package main.test.classlibrary;

import java.lang.ref.Cleaner;

public class CleanerDemo {
    public static void main(String[] args) throws Exception {
        /*1*/
//        Member men=new Member();
//        men=null;   //成为垃圾
//        System.gc();
//        System.out.println("主线");

        /*2*/
        try(MemberCleaning mc=new MemberCleaning()){
            //可执行相关代码
        }catch (Exception e){}

        /*3*/
        System.out.println(get());
    }
    public static int get(){
        try{
            return 100;
        }finally {
            System.out.println("***********");
        }
    }
}
/*1*/
//class Member{
//    public Member(){
//        System.out.println("构造方法");
//    }
//
//    @Override
//    protected void finalize() throws Throwable {
//        System.out.println("回收方法");
//        throw new Exception("抛出错误");
//    }
//}
class Member implements Runnable{
    public Member(){
        System.out.println("构造方法");
    }
    @Override
    public void run() { //执行清除的时候执行的是此操作
        System.out.println("回收");
    }
}
class MemberCleaning implements AutoCloseable{  //实现清除处理
    private static final Cleaner cleaner=Cleaner.create(); //创建一个清除处理
    private Member member;
    private Cleaner.Cleanable cleanable;
    public MemberCleaning(){
        this.member=new Member();   //创建新对象
        this.cleanable=this.cleaner.register(this,this.member); //注册使用的对象
    }
    @Override
    public void close() throws Exception {
        this.cleanable.clean(); //启动多线程
    }
}