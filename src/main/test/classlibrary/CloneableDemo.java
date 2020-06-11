/**
 * FileName: CloneableDemo
 * Author:   嘉平十七
 * Date:     2020/5/18 15:16
 * Description: 对象克隆
 * History:
 * notes：
 */
package main.test.classlibrary;

public class CloneableDemo {
    public static void main(String[] args) throws Exception{
        Men menA=new Men("张三",30);
        Men menB=(Men)menA.clone();
        System.out.println(menA);
        System.out.println(menB);
    }
}
class Men implements Cloneable{
    private String name;
    private int age;
    public Men(String name,int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "【"+super.toString()+"】姓名："+this.name+"、年龄："+this.age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();   // 调用父类中提供的clone()方法
    }
}