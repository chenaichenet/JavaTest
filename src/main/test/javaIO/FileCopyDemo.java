/**
 * FileName: FileCopyDemo
 * Author:   嘉平十七
 * Date:     2020/6/8 16:48
 * Description: 综合实例——文件拷贝
 * History:
 * notes：设置运行配置
 */
package main.test.javaIO;
import java.io.*;
public class FileCopyDemo {
    public static void main(String[] args) throws Exception{
        if (args.length!=2){    //程序执行错误
            System.err.println("程序执行错误");
            System.exit(1);
        }
        long start=System.currentTimeMillis();
        FileUtil fileUtil=new FileUtil(args[0],args[1]);
        if (new File(args[0]).isFile()){    //文件的拷贝
            System.out.println(fileUtil.copy()?"文件拷贝成功":"文件拷贝失败");
        }else {
            System.out.println(fileUtil.copyDir()?"文件目录拷贝成功":"文件目录拷贝失败");
        }
        long end=System.currentTimeMillis();
        System.out.println("拷贝完成时间："+(end-start));
    }
}
class FileUtil{     //定义一个文件操作的工具类
    private File srcFile;   //源文件路径
    private File desFile;   //目标文件路径
    public FileUtil(String src,String des){
        this(new File(src),new File(des));
    }
    public FileUtil(File srcFile,File desFile){
        this.srcFile=srcFile;
        this.desFile=desFile;
    }
    public boolean copy() throws Exception{     //文件的拷贝处理
        if (!this.srcFile.exists()){
            System.err.println("警告：源文件不存在");
            return false;
        }
        return this.copyFileImpl(this.srcFile,this.desFile);
    }

    /*文件目录的拷贝*/
    public boolean copyDir() throws Exception{      //目录的拷贝
        try {
            this.copyImpl(this.srcFile);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public void copyImpl(File file) throws Exception{    //拷贝的内部实现
        if (file.isDirectory()){
            File results[]=file.listFiles();    //列出全部目录
            if (results!=null){
                for (File x:results){
                    copyImpl(x);
                }
            }
        }else { //是文件
            String newFilePath=file.getPath().replace(this.srcFile.getPath()+File.separator,"");
//            System.out.println(file.getPath().replace(this.srcFile.getPath()+File.separator,""));
//            通过getPath获取文件路径，进而使用replace方法替换掉共同路径，即将e:111\222\333.txt替换为222\333.txt。去除公共路径
            File newFile=new File(this.desFile,newFilePath);    //拷贝的目标路径
            this.copyFileImpl(file,newFile);
        }
    }
    public boolean copyFileImpl(File srcFile,File desFile) throws Exception{    //从copy中提出了，作为一个公共的拷贝方法
        if (!desFile.getParentFile().exists()){
            desFile.getParentFile().mkdirs();  //创建目标文件路径
        }
        InputStream input=null;
        OutputStream output=null;
        try {
            input=new FileInputStream(srcFile);
            output=new FileOutputStream(desFile);
            input.transferTo(output);
            return true;
        }catch (Exception e){
            throw e;
        }finally {
            if (input!=null){
                input.close();
            }
            if (output!=null){
                output.close();
            }
        }
    }
}