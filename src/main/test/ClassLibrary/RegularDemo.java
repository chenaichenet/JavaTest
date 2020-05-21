/**
 * FileName: RegularDemo
 * Author:   嘉平十七
 * Date:     2020/5/19 8:26
 * Description: 正则表达式
 * History:
 * notes：
 */
package main.test.ClassLibrary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularDemo {
    public static void main(String[] args) {
        /*1、传统方法判断*/
//        String str="123";
//        if (isNumber(str)){
//            int num=Integer.parseInt(str);
//            System.out.println(num);
//        }
        /*2、利用正则表达式*/
//        String str="123";
//        if (str.matches("\\d+")){
//            int num=Integer.parseInt(str);
//            System.out.println(str);
//        }
        /*3*/
//        String str1="a";     //要判断的数据
//        String regex1="a";   //正则表达式
//        String regex2="[bc]";  //正则表达式
//        String regex3="[a-zA-z]";
//        System.out.println(str1.matches(regex1));
//        System.out.println(str1.matches(regex2));
//        System.out.println(str1.matches(regex3));
//
//        String str2="1";
//        String regex4="[0-9]";
//        System.out.println(str2.matches(regex4));
//
//        String str3="#";
//        String regex5=".";
//        System.out.println(str3.matches(regex5));
//
//        String str4="a\t";
//        String regex6="\\D\\s";
//        System.out.println(str4.matches(regex6));
//
//        String str5="";
//        String regex7="\\w*";
//        System.out.println(str5.matches(regex7));
//
//        String str6 = "Hello&*()@#$123&*(#$abcde*()@#$*()@#$" ;	// 要判断的数据
//        String regex8 = "[^a-zA-Z0-9]+" ;	// 正则表达式
//        System.out.println(str6.replaceAll(regex8, ""));
//
//        String str7="a1b22c333d4444e55555f666666";
//        String regex9="\\d+";
//        String result1[]=str7.split(regex9);
//        for (int x=0;x<result1.length;x++)
//            System.out.print(result1[x]+"、");
//
//        String str8="100.12";
//        String regex10="\\d+(\\.\\d+)?";
//        System.out.println(str8.matches(regex10));
//
//        String str9 = "(010)-51283346" ;	// 要判断的数据
//        String regex11 = "((\\d{3,4})|(\\(\\d{3,4}\\)-))?\\d{7,8}" ;	// 正则表达式
//        System.out.println(str9.matches(regex11));
//
//        String str10="chenaichenet@126.com";
//        String regex12="\\w+@\\w+\\.(cn|com|com.cn|net|gov)";
//        System.out.println(str10.matches(regex12));

        /*2、Pattern*/
//        String str="abc()defg@hij#klmn$";
//        String regex="[^a-zA-Z]+";
//        Pattern pat=Pattern.compile(regex); //编译正则表达式
//        System.out.println(pat);
//        String result[]=pat.split(str);
//        for(String s:result){
//            System.out.println(s);
//        }

        /*3、Matcher*/
//        String str="101";
//        String regex="\\d+";
//        Pattern pat=Pattern.compile(regex);
//        Matcher mat=pat.matcher(str);
//        System.out.println(mat.matches());

        /*4、要求取出内容*/
        String str="INSERT INTO dept(deptno,dname,loc) VALUES (#{deptni},#{dname},#{loc})";
        String regex="#\\{\\w+\\}";
        Pattern pat=Pattern.compile(regex); //编译正则表达式
        Matcher mat=pat.matcher(str);
        while (mat.find()){ //是否有匹配成功的内容
            System.out.println(mat.group(0).replaceAll("#|\\{|\\}",""));
        }


        /*自定义例子，测试split*/
//        String a="a.b.c.d.e";
//        String b="afghi";
//        String resuls[]=a.split("\\.");
//        int num[]={1,2,3,4,9};
//        for (String s:resuls){
//            System.out.print(s+"、");
//        }
    }
    /*1*/
//    public static boolean isNumber(String str){
//        char data[]=str.toCharArray();
//        for (int x=0;x<data.length;x++){
//            if (data[x]>'9'||data[x]<'0')
//                return false;
//        }
//        return true;
//    }
}