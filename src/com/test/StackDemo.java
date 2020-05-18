/**
 * FileName: StackDemo
 * Author:   嘉平十七
 * Date:     2020/3/12 15:31
 * Description: 栈(stack)、List
 * History:
 */
package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StackDemo {
    public static void main(String args[]){
        Stack st=new Stack();
        for(int i=0;i<4;i++){
            Scanner sr=new Scanner(System.in);
            int a = sr.nextInt();
            st.push(a);
        }
//        System.out.println(st.empty());//判断栈是否为空。空为true，非空为false
//        st.pop();//删除栈顶元素
//        System.out.println(st.peek());//输出栈顶元素
        System.out.println(st);//栈是Vector的一个子类，也是数组
        List se=new ArrayList();
        for(int i=0;i<4;i++){
            Scanner sr=new Scanner(System.in);
            int a=sr.nextInt();
            se.add(a);
        }
        System.out.println(se);
    }
}