/**
 * FileName: ServiceTools
 * Author:   嘉平十七
 * Date:     2020/7/8 9:24
 * Description: 为SomeServiceImpl添加语句
 * History:
 * notes：
 */
package com.demo3.javaProxy.utils;

import java.util.Date;

public class ServiceTools {
    public static void doLog(){
        System.out.println("非业务方法，方法执行时间："+new Date().getTime());
    }
    public static void doTrans(){
        System.out.println("非业务方法，事务执行结束");
    }
}