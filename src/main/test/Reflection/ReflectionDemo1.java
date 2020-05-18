/**
 * FileName: ReflectionTest2
 * Author:   嘉平十七
 * Date:     2020/5/14 8:26
 * Description: 反射自编测试
 * History:
 * notes：
 */
package main.test.Reflection;

import java.util.Scanner;

public class ReflectionDemo1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int clsname=sc.nextInt();
        Choose choose=Factory.Instance("main.test.Reflection.Choose");
        IMessage msg=Factory.Instance(choose.choose(clsname));
        msg.path();
        msg.send();
    }
}
class Choose{
    public String choose(int s){
        if (s==1){
            return "main.test.Reflection.Message";
        }else if (s==2){
            return "main.test.Reflection.MessageCould";
        }
        return null;
    }
}
interface IMessage{
    public void send();
    public boolean path();
}
class Message implements IMessage{

    @Override
    public void send() {
        System.out.println("【消息】你有一份消息待查收");
    }

    @Override
    public boolean path() {
        System.out.println("消息通道构建成功");
        return true;
    }
}
class MessageCould implements IMessage{

    @Override
    public void send() {
        System.out.println("【消息】你有一份云消息待查收");
    }

    @Override
    public boolean path() {
        System.out.println("云消息通道已连通");
        return true;
    }
}
class Factory{
    public static <T> T Instance(String classname){
        T name=null;
        try{
            name=(T)Class.forName(classname).getDeclaredConstructor().newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return name;
    }
}