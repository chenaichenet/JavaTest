/**
 * FileName: EnumDemo
 * Author:   嘉平十七
 * Date:     2020/3/20 18:07
 * Description: 枚举类
 * History:
 * notes：
 */
package com.test;

interface ColorMessage{
    public String getMessage();
}

enum Color implements ColorMessage{
    RED("红色"),GREEN("绿色"),BLUE("蓝色");
    private String title;
    private Color(String title){
        this.title=title;
    }
    public String toString(){
        return title;
    }

    @Override
    public String getMessage() {
        return title;
    }

    /*枚举可以直接定义抽象方法，但是需要每一个枚举对象都覆写此抽象方法
    * 即：RED("红色"）{public String getInstance(){return this.toString();}，每一个枚举对象都要覆写*/
//    public abstract String getInstance();
}
public class EnumDemo {
    public static void main(String args[]){
        /*可以输入*/
//        Scanner sr=new Scanner(System.in);
//        String s=sr.next();
//        Color c=Color.valueOf(s);

        /*枚举可以直接通过switch判断*/
//        Color c=Color.RED;
//        switch (c){
//            case RED:
//                System.out.println("红色");
//                break;
//            case GREEN:
//                System.out.println("绿色");
//                break;
//            case BLUE:
//                System.out.println("蓝色");
//                break;
//        }

        /*输出*/
//        for (Color e:Color.values()){//通过增强for循环
//            System.out.println(e.ordinal()+"-"+e.name());
//            //e.toString是一样的，这里是因为toString方法是类中默认的输出方法，此处只是重写了toString方法
//            System.out.println(e);
//        }

        /*枚举实现接口，同样通过向上转型实例化对象*/
        ColorMessage msg=Color.RED;
        System.out.println(msg);
        System.out.println(msg.getMessage());
    }
}