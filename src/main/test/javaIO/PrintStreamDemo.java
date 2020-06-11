/**
 * FileName: printStreamDemo
 * Author:   嘉平十七
 * Date:     2020/6/9 16:06
 * Description: 打印流
 * History:
 * notes：
 */
package main.test.javaIO;

import java.io.*;

public class PrintStreamDemo {
    public static void main(String[] args) throws Exception {
        File file=new File("e:"+File.separator+"1234.txt");
        /*1*/
//        PrintUtil pr=new PrintUtil(new FileOutputStream(file));
//        pr.println("姓名：张三");
//        pr.print("年龄：");
//        pr.println("10");
//        pr.close();
        /*2*/
        PrintWriter pw=new PrintWriter(new FileOutputStream(file));
//        pw.println("姓名：李四");
//        pw.print("年龄：");
//        pw.println("20");
//        pw.close();
        /*3*/
        String name="王五";
        int age=30;
        double salary=789.987;
        pw.printf("姓名：%s、年龄：%d收入：%3f", name, age, salary);
        pw.close();
    }
}
class PrintUtil implements AutoCloseable{   //实现一些常用数据的输出
    private OutputStream output;    //核心使用的就是OutputStream
    public PrintUtil(OutputStream output){  //有外部来决定输出的位置
        this.output=output;
    }
    @Override
    public void close() throws Exception {
        this.output.close();
    }
    public void println(long num){
        this.println(String.valueOf(num));
    }
    public void print(long num) {
        this.print(String.valueOf(num));
    }
    public void print(String str) {	// 输出字符串
        try {
            this.output.write(str.getBytes());	 // 输出
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void println(String str) {
        this.print(str + "\r\n");
    }
}