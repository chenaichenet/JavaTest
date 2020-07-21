/**
 * FileName: IODemo
 * Author:   嘉平十七
 * Date:     2020/4/23 12:33
 * Description: 字节流、字符流
 * History:
 * notes：
 */
package com.test;

import java.io.*;

public class IODemo {
    public static void main(String[] args) throws Exception{
        File file=new File("D:"+File.separator+"Hello"+File.separator+"test.txt");
        if(!file.getParentFile().exists()){ //文件不存在
            file.getParentFile().mkdir();   //创建目录（不是文件）
        }

        OutputStream output=new FileOutputStream(file,true); //通过子类实例化
        String str="Hello World\r\n";   //要输出的文件内容
        output.write(str.getBytes());   //将字符串变为字节数组并输出
        output.close();

        InputStream input=new FileInputStream(file);
        byte data[]=new byte[200];  //开辟一个缓存区读取数据
        int len=input.read(data);   //读取数据，数据全部保存在字节数组中，返回读取个数
        System.out.println("消息1："+new String(data,0,len));
        input.close();

//        Writer out=new FileWriter(file,true);
        Writer out=new FileWriter(file);
        String qwe="World";
        out.write(qwe);
        out.append(",Hello\r\n");   //追加
        out.close();

        Reader red=new FileReader(file);
        char asd[]=new char[200];
        int lens=red.read(asd);
        System.out.println("消息2："+new String(asd,0,len));
        red.close();
    }
}