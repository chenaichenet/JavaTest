/**
 * FileName: Demo
 * Author:   嘉平十七
 * Date:     2020/5/15 11:06
 * Description:
 * History:
 * notes：
 */
package main.test.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ReflectionDemo6 {
    public static void main(String[] args) {
        ITip ms=(ITip)new TipProxy().bind(new TipReal());
        ms.send();
    }
}
class TipProxy implements InvocationHandler{
    private Object target;
    public Object bind(Object target){
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    public boolean connect(){
        System.out.println("【提示】消息通道连接成功");
        return true;
    }
    public void close(){
        System.out.println("【提示】消息通道关闭");
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("执行方法："+method);
        Object returnData=null;
        if (this.connect()){
            returnData=method.invoke(this.target,objects);
            this.close();
        }
        return returnData;
    }
}
interface ITip {
    public void send();
}
class TipReal implements ITip {
    @Override
    public void send() {
        System.out.println("消息");
    }
}
