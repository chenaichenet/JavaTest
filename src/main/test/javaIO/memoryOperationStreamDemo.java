/**
 * FileName: memoryOperationStreamDemo
 * Author:   嘉平十七
 * Date:     2020/6/9 10:36
 * Description: 内存操作流
 * History:
 * notes：
 */
package main.test.javaIO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class memoryOperationStreamDemo {
    public static void main(String[] args) throws Exception{
        /*1*/
//        String str="abcdef";
//        InputStream inputStream=new ByteArrayInputStream(str.getBytes());   //将数据保存在内存流中
//        OutputStream outputStream=new ByteArrayOutputStream();     //读取内存中的数据
//        int data=0;
//        while ((data=inputStream.read())!=-1){  //每次读取一个字节
//            outputStream.write(Character.toUpperCase(data));    //保存数据
//        }
//        System.out.println(outputStream);
//        inputStream.close();
//        outputStream.close();
        /*2*/
        String str="qwert";
        InputStream inputStream=new ByteArrayInputStream(str.getBytes());   //将数据保存在内存流中
        //必须使用子类来调用子类自己的扩展方法
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();     //读取内存的数据
        int data=0;
        while ((data=inputStream.read())!=-1){
            outputStream.write(Character.toUpperCase(data));
        }
        byte result[]=outputStream.toByteArray();   //获取全部数据
        System.out.println(new String(result)); //自己处理字节数据
        inputStream.close();
        outputStream.close();
    }
}