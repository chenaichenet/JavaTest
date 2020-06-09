/**
 * FileName: packageDemo3
 * Author:   嘉平十七
 * Date:     2020/6/8 10:04
 * Description: 包的使用
 * History:
 * notes：
 */
package main.test.basis.packagedemo.packagedemo3;

import main.test.basis.packagedemo.packagedemo1.*;
import main.test.basis.packagedemo.packagedemo2.*;

public class packageDemo3 {
    public static void main(String[] args) {
        /*导包packagedemo1，实现输出*/
        packageDemo2 packageDemo2=new packageDemo2();
        System.out.println(packageDemo2.getContent());
        /*不使用关键词import*/
        main.test.basis.packagedemo.packagedemo1.packageDemo1 packageDemo1=new packageDemo1();
        System.out.println(packageDemo1.getContent());
        /*访问控制权限*/
        new packageDemo2().print();
        System.out.println(new packageDemo2().getContent());
        System.out.println(new packageDemo1().info);
    }
}