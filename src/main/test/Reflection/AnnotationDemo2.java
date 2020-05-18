/**
 * FileName: Demo
 * Author:   嘉平十七
 * Date:     2020/5/15 16:39
 * Description: 自定义Annotation
 * History:
 * notes：
 */
package main.test.Reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class AnnotationDemo2 {
    public static void main(String[] args) throws Exception{
        Method method=Blog.class.getMethod("visit", String.class);// 获取指定方法
        DefaultAnnotation anno=method.getAnnotation(DefaultAnnotation.class); // 获取指定的Annotation
        String ms=anno.title()+"("+anno.url()+")";
        method.invoke(Blog.class.getDeclaredConstructor().newInstance(),ms);
    }
}
@Retention(RetentionPolicy.RUNTIME) // 定义Annotation的运行策略
@interface DefaultAnnotation{   // 自定义的Annotation
    public String title();
    public String url() default "www.shiqiblog.com";
}
class Blog{
    @DefaultAnnotation(title = "十七")
    public void visit(String vi){
        System.out.println("消息："+vi);
    }
}