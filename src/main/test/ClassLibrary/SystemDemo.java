/**
 * FileName: SystemDemo
 * Author:   嘉平十七
 * Date:     2020/5/18 14:59
 * Description:
 * History:
 * notes：
 */
package main.test.ClassLibrary;

public class SystemDemo {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        Runtime run=Runtime.getRuntime();
        String str="";
        for (int x=0;x<3000;x++){
            str+=x;
        }
        long end=System.currentTimeMillis();
        System.out.println("操作耗时："+(end-start));
        run.gc();
    }
}