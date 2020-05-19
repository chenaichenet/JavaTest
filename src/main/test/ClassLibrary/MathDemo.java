/**
 * FileName: MathDemo
 * Author:   嘉平十七
 * Date:     2020/5/18 15:24
 * Description: 数字操作类
 * History:
 * notes：
 */
package main.test.ClassLibrary;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class MathDemo {
    public static void main(String[] args) {
        /*1、基础操作*/
//        System.out.println(Math.abs(-10.1));
//        System.out.println(Math.max(10.2,20));
//        System.out.println(Math.log(9));
//        System.out.println(Math.round(15.2));
//        System.out.println(Math.round(-15.2));
//        System.out.println(Math.round(-15.5));
//        System.out.println(Math.round(-15.51));
//        System.out.println(Math.pow(2,3));
        /*2、调用自定义方法*/
//        System.out.println(MathUtil.round(19.28,2));
        /*3、随机数*/
//        Random rand=new Random();
//        for (int x=0;x<5;x++){
//            System.out.print(rand.nextInt(5)+"、");
//        }
        /*4、随机数不重复不为零的存入数组*/
//        int data[]=new int[7];
//        Random rand=new Random();
//        int foot=0; //操作data脚标
//        while (foot<7){
//            int num=rand.nextInt(35);
//            if (isUse(num,data)){   //可以使用
//                data[foot++]=num;   //保存数据
//            }
//        }
//        java.util.Arrays.sort(data);    //排序，从小到大
//        for (int x=0;x<data.length;x++){
//            if (x==data.length-1){
//                System.out.println(data[x]);
//            }else {
//                System.out.print(data[x]+"、");
//            }
//        }
        /*5、大数类*/
//        BigInteger bigA = new BigInteger("44444444444") ;
//        BigInteger bigB = new BigInteger("22222222222") ;
//        System.out.println("加法操作：" + bigA.add(bigB));
//        System.out.println("减法操作：" + bigA.subtract(bigB));
//        System.out.println("乘法操作：" + bigA.multiply(bigB));
//        System.out.println("除法操作：" + bigA.divide(bigB));
//        BigInteger result[]=bigA.divideAndRemainder(bigB);
//        System.out.println("商："+result[0]+"、余数："+result[1]);
        /*6*/
        BigDecimal A=new BigDecimal("44444444444");
        BigDecimal B=new BigDecimal("22222222222");
        System.out.println("加法："+A.add(B));
        BigDecimal res[]=A.divideAndRemainder(B);
        System.out.println("除法：商="+res[0]+"、余数="+res[1]);
    }
    /*4*/
    /**
     * 判断传入的数字是否为0以及是否在数组之中存在
     * @param num 要判断的数字
     * @param temp 已经存在的数据
     * @return 如果该数字不是0并且可以使用返回true，否则返回false
     */
    public static boolean isUse(int num,int temp[]){
        if (num==0){
            return false;
        }
        for (int x=0;x<temp.length;x++){
            if (num==temp[x])
                return false;
        }
        return true;
    }
}
/*2*/
class MathUtil{
    private MathUtil(){}
    /*实现数据级四舍五入的操作
    * @param num 要进行四舍五入操作的数字
    * @param scale 四舍五入保留的小数位数
    * @return 四舍五入处理后的结果
    */
    public static double round(double num,int scale){
        return Math.round(num*Math.pow(10,scale))/Math.pow(10,scale);
    }
}
