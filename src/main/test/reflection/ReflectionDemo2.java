/**
 * FileName: ReflectionDemo2
 * Author:   嘉平十七
 * Date:     2020/5/14 15:06
 * Description:
 * History:
 * notes：
 */
package main.test.reflection;
import cn.test.Reflection.ReflectionTest2;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionDemo2 {
    public static void main(String[] args) throws Exception{
        /*打印所有类的构造方法*/
//        Class<?> cls=ReflectionTest2.class;    // 获取指定类的Class对象
//        System.out.println(cls);
//        Constructor<?>[] constructors=cls.getConstructors();    // 获取全部构造
//        for (Constructor<?> cons:constructors){
//            System.out.println(cons);
//        }

        /*指定构造方法，实例化对象*/
//        Class<?> cla=ReflectionTest2.class;
//        Constructor<?> constructor=cla.getConstructor(String.class);
//        Object obj=constructor.newInstance("chen");
//        System.out.println(obj);

        Class<?> cla= ReflectionTest2.class;
        /*打印指定方法*/
//        Method method=cla.getMethod("see");
//        System.out.println(method);

        /*打印本类方法*/
//        Method method[]=cla.getMethods();// 获取全部方法（包括父类中的方法）
//        //Method method[]=cla.getDeclaredMethods();//获取本类方法
//        for (Method mt:method){
//            System.out.println(mt);
//        }

        /*打印去代码模式的的方法*/
        Method method[]=cla.getMethods();
        for (Method mt:method){
            int mod=mt.getModifiers();  //修饰符
            System.out.println(Modifier.toString(mod)+" ");
            System.out.println(mt.getReturnType().getName()+" ");
            System.out.println(mt.getName()+"(");
            Class<?> param[]=mt.getParameterTypes();    //获取参数类型
            for (int x=0;x<param.length;x++){
                System.out.println(param[x].getName()+" "+"arg-"+x);
                if (x<param.length-1){
                    System.out.println(",");
                }
            }
            System.out.println(")");
            Class<?> exp[]=mt.getExceptionTypes();
            if (exp.length>0){
                System.out.println(" throws ");
            }
            for (int x=0;x<exp.length;x++){
                System.out.println(exp[x].getName());
                if (x<exp.length-1){
                    System.out.println(",");
                }
            }
            System.out.println();
        }
    }
}