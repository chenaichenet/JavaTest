/**
 * FileName: CharSequenceDemo
 * Author:   嘉平十七
 * Date:     2020/5/16 17:04
 * Description: CharSequence接口
 * History:
 * notes：
 */
package main.test.classlibrary;

public class CharSequenceDemo {
    public static void main(String[] args) {
        CharSequence str="Hello World";
        CharSequence sub=str.subSequence(0,5);
        System.out.println(str);
        System.out.println(sub);
    }
}