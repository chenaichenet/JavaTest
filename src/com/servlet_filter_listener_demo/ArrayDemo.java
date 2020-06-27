/**
 * FileName: ArrayDemo
 * Author:   嘉平十七
 * Date:     2020/3/12 12:25
 * Description: 数组
 * History:
 */
package com.servlet_filter_listener_demo;

import java.util.Scanner;

public class ArrayDemo {
    public static void main(String args[]){
        Scanner qw=new Scanner(System.in);
        int n = qw.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=qw.nextInt();
        }
//        for (int s=0;s<a.length;s++) {
//            System.out.println(a[s]);
//        }
        for(int k=a.length-1;k>=0;k--){//重点是数组的长度，一定是  n-1（也是*.length-1)
            System.out.println(a[k]);
        }
    }
}