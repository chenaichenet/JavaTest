/**
 * FileName: caseDemo2
 * Author:   嘉平十七
 * Date:     2020/6/10 15:53
 * Description: JavaIO编程案例
 * History:
 * notes：从键盘输入文件的内容和要保存的文件名称，然后根据输入的名称创建文件，并将内容保存到文件中。
 */
package main.test.javaIO;

import java.io.*;

public class caseDemo2 {
    static {
        File file=new File(IFileService2.SAVE_DIR);
        if (!file.exists()){
            file.mkdirs();
        }
    }
    public static void main(String[] args) {
        IFileService2 fileService2=Factory2.getInstance();
        System.out.print(fileService2.save());
    }
}
class InputUtil2{   //定义输入工具类
    private static final BufferedReader INPUT=new BufferedReader(new InputStreamReader(System.in));
    private InputUtil2(){}
    public static String getString(String propmt){
        String str=null;
        boolean flag=true;
        while (flag){
            System.out.print(propmt);   //打印提示信息
            try {
                str=INPUT.readLine();   //键盘输入
                if (!"".equals(str)){
                    flag=false;
                }else {
                    System.out.println("输入内容不允许为空");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("输入内容不允许为空！");
            }
        }
        return str;
    }
}
interface IFileService2{
    public static final String SAVE_DIR="e:"+ File.separator+"1234"+File.separator;
    public boolean save();
}
class FileServiceImpl2 implements IFileService2{
    private String name;
    private String content;
    public FileServiceImpl2(){
        this.name=InputUtil2.getString("请输入保存文件的名称：");
        this.content=InputUtil2.getString("请输入保存文件的内容：");
    }
    @Override
    public boolean save() {
        File file=new File(IFileService2.SAVE_DIR+this.name);
        PrintWriter out=null;
        try {
            out=new PrintWriter(new FileOutputStream(file));
            out.printf(this.content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }finally {
            if (out!=null)
                out.close();
        }
        return true;
    }
}
class Factory2{
    private Factory2(){}
    public static IFileService2 getInstance(){
        return new FileServiceImpl2();
    }
}