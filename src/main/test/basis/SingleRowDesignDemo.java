/**
 * FileName: singleRowDesignDemo
 * Author:   嘉平十七
 * Date:     2020/6/8 10:27
 * Description: 单例设计模式
 * History:
 * notes：通过在类中创建static final变量达到单例设计
 */
package main.test.basis;

class Singleton{
    private static Singleton INSTANCE;
    private Singleton(){}   //构造方法私有化
    public static Singleton getInstance(){
        if (INSTANCE==null){
            INSTANCE=new Singleton();
        }
        return INSTANCE;
    }
    public void print(){
        System.out.println("12345");
    }
}
public class SingleRowDesignDemo {
    public static void main(String[] args) {
        Singleton instance=null;
        instance=Singleton.getInstance();
        instance.print();
    }
}