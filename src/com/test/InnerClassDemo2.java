/**
 * FileName: Temporary
 * Author:   嘉平十七
 * Date:     2020/3/13 10:58
 * Description: 接口中的内部类
 * History:
 */
package com.test;

import java.util.Scanner;

interface IMessageArt{
    static interface IMessages{
        public String getContent();
    }
    static interface IChannel{
        public boolean connect();
    }
    public static void sends(IMessages msg,IChannel channel){
        if(channel.connect()){
            System.out.println(msg.getContent());
        }else{
            System.out.println("消息通道建立失败");
        }
    }
    public static void ssed(){
        System.out.println("看看看");
    }
}
class QWE implements IMessageArt.IMessages{

    @Override
    public String getContent() {
        return "这里是消息";
    }
}
class QAZ implements IMessageArt.IChannel{
    Scanner scan=new Scanner(System.in);
    int a=scan.nextInt();
    @Override
    public boolean connect() {
        if (a%2==0){
            return true;
        }else {
            return false;
        }
    }

}
public class InnerClassDemo2 {
    public static void main(String args[]) {
        IMessageArt.sends(new QWE(),new QAZ());
        IMessageArt.ssed();

    }
}