/**
 * FileName: StreamDemo
 * Author:   嘉平十七
 * Date:     2020/6/8 15:58
 * Description: 字节流与字符流
 * History:
 * notes：
 */
package main.test.javaIO;

import java.io.*;

public class StreamDemo {
    public static void main(String[] args) throws Exception{
        /*1、OutputStream*/
        File file=new File("e:"+File.separator+"JavaTest"+File.separator+"StreamDemo"+File.separator+"112.txt");
        if (!file.getParentFile().exists()){    //父目录不存在
            file.getParentFile().mkdirs();  //创建父目录
        }
//        OutputStream outputStream=new FileOutputStream(file);   //通过子类实例化
//        String str="abcdefg";   //要输出的文件内容
//        outputStream.write(str.getBytes());     //将字符串转为字节数组并输出
//        outputStream.close();   //关闭资源
        /*2*/
//        try {
//            OutputStream outputStream=new FileOutputStream(file,true);
//            String str="12345\r\n";
//            outputStream.write(str.getBytes());
//            outputStream.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        /*3、inputStream*/
//        InputStream inputStream=new FileInputStream(file);
//        byte data[]=new byte[1024];   //开辟一个缓冲区读取数据
//        int len=inputStream.read(data1);  //读取数据，将数据全部保存在字节数组中，返回读取个数
//        System.out.println("["+new String(data,0,len)+"]");
//        inputStream.close();
        /*4*/
//        InputStream inputStream=new FileInputStream(file);
//        byte data[]=inputStream.readAllBytes();     //读取全部数据
//        String fd=new String(data);
//        System.out.println("["+new String(data)+"]");
//        System.out.println(fd);
//        inputStream.close();
        /*5、字符流Writer*/
//        if (!file.getParentFile().exists()){
//            file.getParentFile().mkdirs();  //父目录必须存在
//        }
//        Writer writer=new FileWriter(file);
//        String str="09876\r\n";
//        writer.write(str);
//        writer.append("一二三");   //追加
//        writer.close();
        /*6、Reader*/
//        if (file.exists()){
//            Reader reader=new FileReader(file);
//            char data[]= new char[1024];
//            int len=reader.read(data);
//            System.out.println("读取内容："+new String(data,0,len));
//            reader.close();
//        }
        /*7*/
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        Writer writer=new FileWriter(file);
        String str="qwert";
        writer.write(str);
        writer.flush(); //强制性刷新
    }
}