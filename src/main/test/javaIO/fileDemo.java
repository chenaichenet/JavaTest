/**
 * FileName: fileDemo
 * Author:   嘉平十七
 * Date:     2020/6/8 11:06
 * Description: File文件操作类
 * History:
 * notes：
 */
package main.test.javaIO;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/*2、提供一个计算文件大小的类*/
class MathUitl{
    private MathUitl(){}
    public static double round(double num,int scale){
        return Math.round(Math.pow(10,scale)*num)/Math.pow(10,scale);
    }
}
public class fileDemo {
    public static void main(String[] args) throws Exception{
        /*1、判断，创建文件及父目录*/
//        File file=new File("e:"+File.separator+"JavaTest"+File.separator+"FileDemo"+File.separator+"test.txt");
//        if (!file.getParentFile().exists()){    //父路径不存在
//            file.getParentFile().mkdirs();   //创建父路径
//        }
//        if (file.exists()){
//            file.delete();  //删除文件
//        }else { //文件不存在
//            System.out.println(file.createNewFile());   //创建文件
//        }
        /*2、判断文件部分属性*/
//        File file=new File("e:"+File.separator+"JavaTest"+File.separator+"FileDemo"+File.separator+"123.jpg");
//        System.out.println("文件是否可读："+file.canRead());
//        System.out.println("文件是否可写："+file.canWrite());
//        System.out.println("文件大小："+MathUitl.round(file.length()/(double)1024/1024,2));
//        System.out.println("最后修改时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified())));
//        System.out.println("是否是目录："+file.isDirectory());
//        System.out.println("是否是文件："+file.isFile());
        /*3、列出目录文件*/
//        File file=new File("e:"+File.separator);
//        if (file.isDirectory()){    //当前是目录
//            File result[]=file.listFiles(); //列出目录中的全部内容
//            for (File x:result){
//                System.out.println(x);
//            }
//        }
        /*4、列出全部文件路径*/
//        File file=new File("e:"+File.separator+"JavaTest");
//        listDir(file);
        /*5*/
        File file=new File("e:"+File.separator+"JavaTest");
        long start=System.currentTimeMillis();
        renameDir(file);
        long end=System.currentTimeMillis();
        System.out.println("所花时间："+(end-start));
    }
    /*4、调用方法*/
    public static void listDir(File file){
        if (file.isDirectory()){
            File results[]=file.listFiles();
            if (results!=null){
                for (File x:results){
                    listDir(x);
                }
            }
        }
        System.out.println(file);
    }
    /*5*/
    public static void renameDir(File file){
        if (file.isDirectory()){    //是一个目录
            File results[]=file.listFiles();    //列出子目录中的内容
            if (results!=null){
                for (File x:results){
                    renameDir(x);
                }
            }
            System.out.println(file);
        }else {
            if (file.isFile()){     //如果是文件则重命名
                String fileName=null;
                if (file.getName().contains(".")){
                    fileName=file.getName().substring(0,file.getName().lastIndexOf("."))+".txt";
                }else {
                    fileName=file.getName()+".txt";
                }
                File newFile=new File(file.getParentFile(),fileName);   //新的文件名
                file.renameTo(newFile);     //重命名
            }
        }
    }
}