/**
 * FileName: SystemDemo
 * Author:   嘉平十七
 * Date:     2020/6/9 17:11
 * Description: System类对IO的支持
 * History:
 * notes：
 */
package main.test.javaIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class SystemDemo {
    public static void main(String[] args) throws Exception{
        /*1*/
//        try {
//            Integer.parseInt("a");
//        } catch (Exception e) {
//            System.out.println(e);
//            System.err.println(e);
//        }
        /*2*/
//        System.setErr(new PrintStream(new FileOutputStream(new File("e:"+File.separator+"1234.txt"))));
//        try {
//            Integer.parseInt("a");
//        } catch (NumberFormatException e) {
//            System.out.println(e);
//            System.err.println(e);//输出到文件里了
//        }
        /*3*/
        InputStream inputStream=System.in;  //此时的输入流为键盘输出
        System.out.println("请输入信息：");
        byte[] data=new byte[1024];
        int len=inputStream.read(data);
        System.out.println("输入内容为："+new String(data,0,len));
    }
}