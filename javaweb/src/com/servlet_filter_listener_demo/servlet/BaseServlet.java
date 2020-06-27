/**
 * FileName: BaseServlet
 * Author:   嘉平十七
 * Date:     2020/6/23 12:11
 * Description: 用于调用方法，直接新建java文件，不在web.xml中进行配置
 * History:
 * notes：
 */
package com.servlet_filter_listener_demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*1.获取参数，用来识别用户请求的方法
         * 2.判断方法*/

        String methodName=req.getParameter("method");     //定义的参数名
        if (methodName==null || methodName.trim().isEmpty()){
            throw new RuntimeException("没有传递method参数，无法调用方法");
        }

        /*得到方法名称，通过反射调用，不再判断了
         * 1.得到方法名，通过方法名得到Mehtod类的对象
         *   需要得到class，然后得到Method*/
        Class cls=this.getClass();  //得到当前类的class对象
        Method method =null;
        try {
            method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("调用方法："+methodName+"，不存在");
        }

        /*调用方法*/
        try {
//            method.invoke(this,req,resp);   //反射调用，相当于this.addUser(req,resp)

            /*修改，转发或重定向*/
            String result=(String)method.invoke(this,req,resp);
            /*获取请求处理方法执行后返回的字符串，表示转发或重定向的路径
            * 完成转发或重定向
            * 用:隔开，判断是转发还是重定向*/

            //返回的字符串为null，或“”，什么都不做
            //判断返回的字符串中有没有冒号，如果没有默认转发，如果有，使用冒号分割字符串，得到前缀和后缀
            //f表示转发，r表示重定向，后缀是要转发或重定向的路径
            if (result==null || result.trim().isEmpty()){
                return;
            }
            if (result.contains(":")){
                //分割
                int index=result.indexOf(":");  //获取冒号的位置
                String s = result.substring(0, index);//截取f，前缀
                String path=result.substring(index+1);  //后缀
                if (s.equalsIgnoreCase("r")){
                    resp.sendRedirect(req.getContextPath()+path);   //重定向
                }else if (s.equalsIgnoreCase("f")){
                    req.getRequestDispatcher(path).forward(req,resp);   //转发
                }else {
                    throw new RuntimeException("指定的操作："+s+"，当前版本不支持");
                }
            }else {
                req.getRequestDispatcher(result).forward(req,resp); //没有冒号，默认转发，result就是路径
            }
        } catch (Exception e) {
            System.out.println("调用方法："+methodName+"，内部抛出异常");
            throw new RuntimeException(e);
        }
    }
}