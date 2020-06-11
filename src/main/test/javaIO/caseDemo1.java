/**
 * FileName: caseDemo1
 * Author:   嘉平十七
 * Date:     2020/6/10 11:11
 * Description: JavaIO编程案例
 * History:
 * notes：编写Java程序，输入3个整数，并求出3个整数的最大值和最小值。
 */
package main.test.javaIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class caseDemo1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入比较的个数：");
        int n=sc.nextInt();
        INumberService1 numberService= Factory1.getInstance();
        int result[]=numberService.stat(n);
        System.out.println("最大值："+result[0]+"   最小值："+result[1]);
    }
}
class InputUtil1 {    //输入工具类
    public static int getInt(String propmt){
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        int num=0;
        boolean flag=true;
        while (flag){
            System.out.print(propmt);     //打印提示信息
            String str=null;
            try {
                str=buf.readLine();
                if (str.matches("\\d+")){
                    num=Integer.parseInt(str);
                    flag=false;
                }else {
                    System.out.println("输入内容非数字");
                }
            }catch (Exception e){
                System.out.println("输入内容非数字！");
            }
        }
        return num;
    }
}
interface INumberService1 {
    /*
    * 输入数据并返回输入数据的最大值与最小值
    * count表示输入数据的个数
    * return返回两个值，最大与最小*/
    public int[] stat(int count);
}
class NumberServiceImpl1 implements INumberService1 {

    @Override
    public int[] stat(int count) {
        int result[]=new int[2];    //定义返回的结果
        int data[]=new int[count];  //开辟一个数组
        for (int x=0;x<data.length;x++){    //数字的循环输入
            data[x]= InputUtil1.getInt("请输入第-"+(x+1)+"-个数字：");
        }
        result[0]=data[0];  //最大值
        result[1]=data[0];  //最小值
        for (int x=0;x<data.length;x++){
            if (data[x]>result[0])
                result[0]=data[x];
            if (data[x]<result[1]){
                result[1]=data[x];
            }
        }
        return result;
    }
}
class Factory1 {
    private Factory1(){}
    public static INumberService1 getInstance(){
        return new NumberServiceImpl1();
    }
}

