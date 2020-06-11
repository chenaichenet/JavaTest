/**
 * FileName: ReflectionDemo5
 * Author:   嘉平十七
 * Date:     2020/5/15 8:05
 * Description: 反射与代理设计模式
 * History:
 * notes：
 */
package main.test.reflection;

public class ReflectionDemo4 {
    public static void main(String[] args) throws Exception{
        INews miss=new Post(new News());
        miss.sends();
        System.out.println();
    }
}
interface INews {   // 传统代理设计必须有接口
    public void sends();    // 业务方法
}
class News implements INews {

    @Override
    public void sends() {
        System.out.println("这里是消息");
    }
}
class Post implements INews {   //代理类
    private INews miss; // 代理对象，一定是业务接口实例
    public Post(INews mess) {
        this.miss=mess;
    }
    @Override
    public void sends() {
        if (this.connect()) {
            this.miss.sends();  // 消息的发送处理
            this.close() ;
        }
    }
    public boolean connect() {
        System.out.println("【消息代理】进行消息发送通道的连接。");
        return true ;
    }
    public void close() {
        System.out.println("【消息代理】关闭消息通道。");
    }
}