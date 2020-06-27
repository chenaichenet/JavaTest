/**
 * FileName: AbnormalDemo
 * Author:   嘉平十七
 * Date:     2020/3/22 9:25
 * Description: 异常
 * History:
 * notes：
 */
package com.servlet_filter_listener_demo;

import java.util.Scanner;
//第二个例子
class Mymath{
    public static int div(int x,int y)throws Exception{
//        int temp;
//        try {
//            temp=x/y;
//        }catch (Exception e){//此处去掉catch，也是交由调用处处理
//            throw e;//向上抛出异常对象，异常交由调用出处理
//        }
//        return temp;
        return x/y;
    }
}
public class AbnormalDemo {
    public static void main(String[] args) {
        System.out.println("程序开始");
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y=0;
        try {
            x = sc.nextInt();
            y = sc.nextInt();
        } catch (Exception e) {
            System.out.println("输入不正确，请输入数字（异常捕获）");
            e.printStackTrace();
        }
        try {
            System.out.println(x / y);
        } catch (Exception e) {
            //System.out.println(e1);//直接打印异常对象是调用默认方法toString打印了异常信息，但是不完整
            System.out.println("被除数为0（异常捕获）");
            e.printStackTrace();//异常类中提供的打印异常信息的方法
        } finally {
            System.out.println("异常捕获结束");//不管是否有异常都执行
        }
        System.out.println("程序结束");

        //第二个例子，方法抛出异常给调用处处理，同下面的throw第四个例子一样，是返回给调用处处理抛出的异常
        try {
            System.out.println(Mymath.div(x,y));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("程序结束");

        //这里通过在main方法后使用throws关键字，就不需要再用try,catch语句处理div方法了，当产生异常时调用默认的处理方式（即中断程序）
//        System.out.println(Mymath.div(x,y));
//        System.out.println("程序结束");

        //throw关键字的使用
        if (x == 0){
            try {
                throw new Exception("手工抛出一个异常");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /*第四个例子，通过catch中的throw向上抛出异常给调用出处理*/
//        try {
//            System.out.println(Mymath.div(x,y));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}