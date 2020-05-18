/**
 * FileName: PackingUnboxingDemo
 * Author:   嘉平十七
 * Date:     2020/3/17 12:36
 * Description: 装箱与拆箱问题
 * History:
 * notes：
 */
package com.test;
class Int{
    private int data;
    public Int(int data){
        this.data=data;
    }
    public int intValue(){
        return this.data;
    }
}
public class PackingUnboxingDemo {
    public static void main(String args[]){
        Int temp=new Int(10);//装箱：将基本数据类型保存在包装类之中
        int i=temp.intValue();//拆箱：从包装类对象中获取基本数据类型
        System.out.println(i);
        System.out.println(temp);
    }
}