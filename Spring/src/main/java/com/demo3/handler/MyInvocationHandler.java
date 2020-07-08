/**
 * FileName: MyInvocationHandler
 * Author:   嘉平十七
 * Date:     2020/7/8 9:18
 * Description: 代理
 * History:
 * notes：
 */
package com.demo3.handler;

import com.demo3.utils.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    //目标对象
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    //通过代理对象指定方法时，会执行invoke()方法
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("执行了MyInvocationHandler中的invoke()方法");
        System.out.println("method参数的值："+method.getName());
        String methodName=method.getName();
        Object res=null;
        if ("doSome".equals(methodName)){   //JoinPoint，Pointcut
            ServiceTools.doLog();
            //执行目标类的方法，通过Method类实现
            res=method.invoke(target,objects);//objects是调用的doSome的参数
            ServiceTools.doTrans();
        }else {
            res=method.invoke(target,objects);
        }


        return res;
    }
}