package com.test;

interface InterfaceDemo2 {
    public int i=10;
    public String eat();
}
interface IMessage{
    public String message();
    public default boolean connect(){
        System.out.println("建立消息通道");
        return true;
    }
    public static IMessage getInstance(){// static方法可以在没有实例化对象的时候直接调用
        return new MessageImpl();//获得子类对象
    }
}
interface IFood{
    public void eat();
}