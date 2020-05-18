/**
 * FileName: MathDemo
 * Author:   嘉平十七
 * Date:     2020/5/18 15:24
 * Description: 数字操作类
 * History:
 * notes：
 */
package main.test.ClassLibrary;

public class MathDemo {
    public static void main(String[] args) {
        /*1*/
        System.out.println(Math.abs(-10.1));
        System.out.println(Math.max(10.2,20));
        System.out.println(Math.log(9));
        System.out.println(Math.round(15.2));
        System.out.println(Math.round(-15.2));
        System.out.println(Math.round(-15.5));
        System.out.println(Math.round(-15.51));
        System.out.println(Math.pow(2,3));

        /*2*/
        System.out.println(MathUtil.round(19.28,2));
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