/**
 * FileName: TestDemo
 * Author:   嘉平十七
 * Date:     2020/7/8 9:26
 * Description: 测试Java中的代理
 * History:
 * notes：
 */
package com.demo3.javaProxy;

import com.demo3.javaProxy.handler.MyInvocationHandler;
import com.demo3.javaProxy.service.SomeService;
import com.demo3.javaProxy.service.impl.SomeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestDemo {
    public static void main(String[] args) {
        //创建目标类
        SomeService target=new SomeServiceImpl();
        target.doSome();
        System.out.println("=======");
        //创建InvocationHandler对象
        InvocationHandler handler=new MyInvocationHandler(target);
        //使用Proxy创建代理
        SomeService proxy= (SomeService) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);
        //通过执行代理方法，会调用handler中的invoke()方法
        proxy.doSome();
    }
}