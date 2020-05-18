/**
 * FileName: ReflectionTest5
 * Author:   嘉平十七
 * Date:     2020/5/15 9:19
 * Description:
 * History:
 * notes：
 */
package cn.test.Reflection;

import java.util.Scanner;

public class ReflectionTest5 {
    public String see(){
        return "look";
    }
    public static String Sink(){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        return "你输入了："+n;
    }
}