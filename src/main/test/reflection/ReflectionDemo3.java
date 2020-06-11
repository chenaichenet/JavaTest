/**
 * FileName: ReflectionDemo3
 * Author:   嘉平十七
 * Date:     2020/5/14 15:50
 * Description:
 * History:
 * notes：
 */
package main.test.reflection;

import cn.test.Reflection.ReflectionTest3;

import java.lang.reflect.Method;

public class ReflectionDemo3 {
    public static void main(String[] args) throws Exception{
        Class<?> cls= ReflectionTest3.class;
        String value="十七";
        int age=20;
        Object obj=cls.getDeclaredConstructor().newInstance();  // 调用无参构造实例化
        System.out.println(obj);
        Method setname=cls.getDeclaredMethod("setName", String.class);
        Method setage=cls.getDeclaredMethod("setAge", int.class);
        setname.invoke(obj,value);
        setage.invoke(obj,age);
        System.out.println(obj);
    }
}