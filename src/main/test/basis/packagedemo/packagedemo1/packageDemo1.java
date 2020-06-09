/**
 * FileName: packageDemo1
 * Author:   嘉平十七
 * Date:     2020/6/8 9:56
 * Description: 包的使用
 * History:
 * notes：
 */
package main.test.basis.packagedemo.packagedemo1;

public class packageDemo1 {
    public String info = "protected——信息";
//    protected String info = "protected——信息";
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
    public String getContent(){
        return "12345";
    }
}