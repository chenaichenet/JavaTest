/**
 * FileName: SomeServiceImpl
 * Author:   嘉平十七
 * Date:     2020/7/8 15:53
 * Description: 目标类
 * History:
 * notes：
 */
package com.demo3.aspectj.ba01;


public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, int age) {
        //给doSome方法增加功能。在执行之前输入执行时间。
        System.out.println("===目标方法doSome()===");
    }

    @Override
    public int doOther(int age) {
        System.out.println("===目标方法doOther()===");
        return 1000;
    }

    public Person doPerson(String name, int age) {
        System.out.println("===目标方法dotPerson()===");
        Person person=new Person();
        person.setName(name);
        person.setAge(age);
        return person;
    }

    @Override
    public void doException() {
        System.out.println("===目标方法doException()===");
//        int a=10/0; //抛出异常
    }
}