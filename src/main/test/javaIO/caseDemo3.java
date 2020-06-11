/**
 * FileName: caseDemo3
 * Author:   嘉平十七
 * Date:     2020/6/10 16:21
 * Description: JavaIO编程案例
 * History:
 * notes：从键盘传入多个字符串到程序中，并将它们按逆序输出在屏幕上。
 */
package main.test.javaIO;

import java.util.Arrays;

public class caseDemo3 {
    public static void main(String[] args) {
        new Menu3();
    }
}
interface IStringService3{
    public void append(String str);     //追加数据
    public String[] reverse();      //反转处理
}
class StringServiceImpl3 implements IStringService3{
    private StringBuffer data=new StringBuffer();

    @Override
    public void append(String str) {
        this.data.append(str).append("|");
    }

    @Override
    public String[] reverse() {
        String result[]=this.data.toString().split("\\|");
        int center=result.length/2;
        int head=0;
        int tail=result.length-1;
        for (int x=0;x<center;x++){
            String temp=result[head];
            result[head]=result[tail];
            result[tail]=temp;
        }
        return result;
    }
}
class Factory3{
    private Factory3(){}
    public static IStringService3 getInstance(){
        return new StringServiceImpl3();
    }
}
class Menu3{
    private IStringService3 stringService3;
    public Menu3(){
        this.stringService3= Factory3.getInstance();
        this.choose3();
    }
    public void show3(){
        System.out.println("【1】追加字符串数据");
        System.out.println("【2】逆序显示所有字符串数据");
        System.out.println("【0】结束程序");
        System.out.print("\n");
    }
    public void choose3(){
        this.show3();
        String choose3=InputUtil2.getString("请进行选择：");
        switch (choose3){
            case "1":
                String str=InputUtil2.getString("请输入字符串数据：");
                this.stringService3.append(str);
                choose3();
            case "2":
                String result[]=this.stringService3.reverse();
                System.out.println(Arrays.toString(result));
                choose3();
            case "0":
                System.out.print("程序结束");
                System.exit(1);
            default:
                System.out.print("非法输入，请重新选择");
                choose3();
        }
    }
}