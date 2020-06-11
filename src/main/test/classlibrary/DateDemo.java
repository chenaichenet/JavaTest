/**
 * FileName: DateDemo
 * Author:   嘉平十七
 * Date:     2020/5/19 7:46
 * Description: 日期操作类
 * History:
 * notes：
 */
package main.test.classlibrary;

import java.text.NumberFormat;

public class DateDemo {
    public static void main(String[] args) throws Exception{
//        System.out.println(new Date());
        /*2*/
//        Date date=new Date();
//        long current=date.getTime();
//        System.out.println(current);
//        current+=864000*1000;   //10天的秒数
//        System.out.println(new Date(current));  //long转为Date
        /*3格式化日期*/
//        Date date=new Date();
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        String str=sdf.format(date);
//        System.out.println(str);
        /*4逆格式化*/
//        String birthday="1999-1-1 11:11:11.111";    //字符串日期
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        Date date=sdf.parse(birthday);
//        System.out.println(date);
        /*5钱的格式化*/
        double money = 23890238923.23 ; // 字符串的金钱
        String str = NumberFormat.getInstance().format(money) ;

    }
}