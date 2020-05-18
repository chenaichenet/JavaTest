/**
 * FileName: ReflectionDemo5
 * Author:   嘉平十七
 * Date:     2020/5/15 9:19
 * Description:
 * History:
 * notes：
 */
package main.test.Reflection;

import cn.test.Reflection.ReflectionTest5;

import java.lang.reflect.Method;

public class ReflectionDemo5 {
    public static void main(String[] args) throws Exception {
        Class<?> cls= ReflectionTest5.class;
        Object obj=cls.getDeclaredConstructor().newInstance();
        Method method=cls.getMethod("see");
        System.out.print(method.invoke(obj));
        Method me=cls.getMethod("Sink");
        System.out.println(me.invoke(obj));
    }
}