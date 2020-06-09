/**
 * FileName: packageDemo2
 * Author:   嘉平十七
 * Date:     2020/6/8 10:01
 * Description: 包的使用
 * History:
 * notes：
 */
package main.test.basis.packagedemo.packagedemo2;
import main.test.basis.packagedemo.packagedemo1.packageDemo1;
public class packageDemo2 extends packageDemo1{
    public void print(){
        System.out.println(super.info);
    }

    public String getContent(){
        return "www.12345.com";
    }
}