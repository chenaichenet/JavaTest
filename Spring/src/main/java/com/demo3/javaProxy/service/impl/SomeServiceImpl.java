/**
 * FileName: SomeServiceImpl
 * Author:   嘉平十七
 * Date:     2020/7/8 9:13
 * Description: 动态代理实现
 * History:
 * notes：
 */
package com.demo3.javaProxy.service.impl;

import com.demo3.javaProxy.service.SomeService;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("执行业务方法doSome()");
    }

    @Override
    public void doOther() {
        System.out.println("执行业务方法doOther()");
    }
}