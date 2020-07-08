/**
 * FileName: MyAsepct
 * Author:   嘉平十七
 * Date:     2020/7/8 15:55
 * Description:
 * History:
 * notes：@Aspect：是aspectj框架中的注解。
 * 作用：表示当前类是切面类。
 * 切面类：用来给业务方法增加方法的类，类中有切面功能的代码。
 * 位置：在类的定义上面
 */
package com.demo3.aspectj.ba01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Date;

@Aspect
public class MyAsepct {
    /*定义方法，方法是实现切面功能的。
    * 方法的定义要求：
    *   1、功能方法
    *   2、没有返回值
    *   3、方法名称自定义
    *   4、方法可以有参数，也可以没有参数
    *       如果有参数，参数不是自定义的，有几个参数类型可以使用*/
    @Before(value = "execution(public void com.demo3.aspectj.ba01.SomeServiceImpl.doSome(String,int))")   //前置通知
    //没有异常，分别是（权限 返回值 包名.类名.方法(类型,类型) 无异常）
    //对象交给spring管理
    public void myBefore(JoinPoint join){
        /*JoinPoint：业务方法，要加入切面功能的业务方法。
        作用是：可以在通知方法 中获取方法执行时的信息，例如方法名称，方法的实参。
		如果切面功能中需要用到方法的信息，就可以加入。该参数的值是由框架赋值的，必须是第一个位置的参数。*/

        //切面要执行的功能代码
        System.out.println("前置通知，切面功能：执行的时间："+new Date());
        //通过JoinPoint类型的参数获取方法的定义，参数等信息
        System.out.println("连接点的方法定义："+join.getSignature());
        System.out.println("连接点的方法名称："+join.getSignature().getName());
        System.out.println("连接点方法的参数个数："+join.getArgs().length);
        Object args[]=join.getArgs();
        for (Object o:args){
            System.out.println("参数："+o);
        }
    }
    @AfterReturning(value = "execution(int com.demo3.aspectj.ba01.SomeServiceImpl.doOther(int))",returning ="obj")
    /*@AfterReturning后置通知，注解有returning属性
    属性：value，切入点表达式；returning，自定义的变量，表示目标方法是返回值的。自定义的变量名和通知方法的形参名一样。
    特点：在目标方法之后执行，能够获取到目标方法的返回值，可以根据返回值做不同的处理功能。可以修改返回值。
    Object obj=doSemo()*/

    public void myAfterReturning1(Object obj){
        System.out.println("后置通知——返回值："+obj);
    }
    @AfterReturning(value = "execution(Person com.demo3.aspectj.ba01.SomeServiceImpl.doPerson(String,int))",returning ="obj")
    /*@AfterReturning后置通知，注解有returning属性
    属性：value，切入点表达式；returning，自定义的变量，表示目标方法是返回值的。自定义的变量名和通知方法的形参名一样。
    特点：在目标方法之后执行，能够获取到目标方法的返回值，可以根据返回值做不同的处理功能。可以修改返回值。
    Object obj=doSemo()*/

    public void myAfterReturning2(Person obj){
        System.out.println("后置通知——返回值："+obj);
        obj.setAge(1000);
        System.out.println("修改后的数据："+obj);
    }


    @After(value = "execution(String com.demo3.aspectj.ba01.SomeServiceImpl.doOther(int))")
    //代理对象调用doOther时执行
    public void myAefore(){
        //切面要执行的功能代码
        System.out.println("最终通知");
    }

    @Before(value = "execution(* do*(..))")
    public void test(){
        System.err.println("====================");
    }
}