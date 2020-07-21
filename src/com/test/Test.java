package com.test;

import java.util.Scanner;

public class Test {
     int dogage;
     String dogname;
     public Test(String name){
         dogname=name;
//         System.out.println("姓名："+dogname);
     }
     public void setAge(int age){
         dogage=age;
     }
     public int getAge(){
         return dogage;
     }
     public static void main(String args[]){
         Scanner sr=new Scanner(System.in);
         String name=sr.next();
         int age=sr.nextInt();
         Test a=new Test(name);
         a.setAge(age);
         a.getAge();
         System.out.println("\n姓名："+a.dogname+"\n"+"年龄："+a.getAge());
    }
}

