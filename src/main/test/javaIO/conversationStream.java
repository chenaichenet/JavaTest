/**
 * FileName: conversationStream
 * Author:   嘉平十七
 * Date:     2020/6/8 16:30
 * Description: 转换流
 * History:
 * notes：
 */
package main.test.javaIO;

import java.io.*;
import java.util.Date;

public class conversationStream {
    public static void main(String[] args) throws Exception{
        File file=new File("e:"+File.separator+"JavaTest"+File.separator+"StreamDemo"+File.separator+"113.txt");
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        OutputStream outputStream=new FileOutputStream(file);
        Writer writer=new OutputStreamWriter(outputStream);     //字节流转换为字符流
        writer.write("中华");
        writer.close();
        //读
        Reader reader=new FileReader(file);
        char chars[]=new char[1024];
        int len=reader.read(chars);
        System.out.println(new String(chars,0,len));
        reader.close();
    }
}