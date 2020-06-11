/**
 * FileName: Demo
 * Author:   嘉平十七
 * Date:     2020/5/15 16:13
 * Description: 注解
 * History:
 * notes：
 */
package main.test.reflection;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@FunctionalInterface
@Deprecated(since = "1.0")
interface IMq {	// 有两个Annotation
    public void send(String msg) ;
}
@SuppressWarnings("serial")	// 无法在程序执行的时候获取
class MqImpl implements IMq, Serializable {
    @Override		// 无法在程序执行的时候获取
    public void send(String msg) {
        System.out.println("【消息发送】" + msg);
    }
}


public class AnnotationDemo1 {
    public static void main(String[] args)  throws Exception{
        {	// 获取接口上的Annotation信息
            Annotation annotations [] = IMq.class.getAnnotations() ; // 获取接口上的全部Annotation
            for (Annotation temp : annotations) {
                System.out.println(temp);
            }
        }
        System.out.println("----------------------------------");
        {	// 获取MessageImpl子类上的Annotation
            Annotation annotations [] = MqImpl.class.getAnnotations() ; // 获取接口上的全部Annotation
            for (Annotation temp : annotations) {
                System.out.println(temp);
            }
        }
        System.out.println("-----------------------------------");
        {	// 获取MessageImpl.toString()方法上的Annotation
            Method method = MqImpl.class.getDeclaredMethod("send", String.class) ;
            Annotation annotations [] = method.getAnnotations() ; // 获取接口上的全部Annotation
            for (Annotation temp : annotations) {
                System.out.println(temp);
            }
        }
    }
}
