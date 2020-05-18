/**
 * FileName: GenericsDemo
 * Author:   嘉平十七
 * Date:     2020/3/18 16:59
 * Description: 泛型演示
 * History:
 * notes：
 */
package com.test;
interface IMiss<T>{//泛型接口
    public String each(T t);
}
class IMisst<S> implements IMiss<S>{//实现接口的类也可以继续使用泛型

    @Override
    public String each(S o) {
        return null;
    }
    public static <A> void action(A[] a){
        System.out.println("泛型方法");
    }
}
class Point <T>{//泛型类
    private T x;
    private T y;
    public void setX(T x){
        this.x=x;
    }
    public void setY(T y){
        this.y=y;
    }
    public T getX(){
        return x;
    }
    public T getY(){
        return y;
    }
}
public class GenericsDemo {
    public static void main(String args[]){
        Point s= new Point();
        Point<Integer> n=new Point<Integer>();
        Point<String> str=new Point<>();
        s.setX("key");
        s.setY(12);
        System.out.println("x是："+s.getX()+"\ny是："+s.getY());
        n.setX(9);
        str.setY("陈兴");
        System.out.println(n.getX()+str.getY());
        /*引用传递问题，采用通配符“？”解决不能重构与不设置泛型所能修改数据的问题*/
        n.setX(10);
        fun(n);
    }
    public static void fun(Point<?> temp){
        System.out.println(temp.getX());
    }
}