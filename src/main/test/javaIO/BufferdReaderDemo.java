/**
 * FileName: BufferdReaderDemo
 * Author:   嘉平十七
 * Date:     2020/6/10 9:22
 * Description: 缓冲流
 * History:
 * notes：
 */
package main.test.javaIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferdReaderDemo {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入信息：");
        String msg=input.readLine();    //接收输入信息
        if (msg.matches("\\d{1,3}")){
            int age=Integer.parseInt(msg);
            System.out.println("年龄为："+age);
        }else {
            System.out.println("输入非数字");
        }
        input.close();
    }
}