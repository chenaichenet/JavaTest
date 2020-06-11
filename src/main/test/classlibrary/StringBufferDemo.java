/**
 * FileName: StringBufferDemo
 * Author:   嘉平十七
 * Date:     2020/5/16 16:23
 * Description: StringBuffer类
 * History:
 * notes：
 */
package main.test.classlibrary;

public class StringBufferDemo {
    public static void main(String[] args) {
        /*比较*/
        String str="Hello ";
        change(str);
        System.out.println(str);

        StringBuffer buf=new StringBuffer("Hello ");
        change(buf);
        System.out.println(buf);

        String strA="123";
        String strB="abc";
        System.out.println(strA==strB);

        StringBuffer strC=new StringBuffer();
        strC.append(".a").insert(0,"b").insert(1,"A").delete(1,2).insert(1,"c");
        System.out.println(strC);
        System.out.println(strC.reverse());

    }
    private static void change(String temp){
        temp+="World";
    }
    private static void change(StringBuffer temp) {
        temp.append("World");  //内容没有改变
    }
    private static <T> void change(T temp){
        temp=(T)(temp+"Wrold");
    }
}