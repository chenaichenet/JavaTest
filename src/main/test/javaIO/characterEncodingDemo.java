/**
 * FileName: characterEncodingDemo
 * Author:   嘉平十七
 * Date:     2020/6/9 10:12
 * Description: 字符编码
 * History:
 * notes：
 */
package main.test.javaIO;

import java.io.*;

public class characterEncodingDemo {
    public static void main(String[] args) throws Exception{
//        System.getProperties().list(System.out);
        OutputStream outputStream=new FileOutputStream("e:"+ File.separator+"000.txt");
        outputStream.write("中华人民共和国".getBytes("ISO8859-1"));
        outputStream.close();
    }
}