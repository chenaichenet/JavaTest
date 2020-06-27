/*BaseServlet的使用
* 通过定义参数，判断调用的方法*/
package com.servlet_filter_listener_demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BaseDemoServlet")
public class BaseDemoServlet extends BaseServlet {
    /*public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        *//*1.获取参数，用来识别用户请求的方法
        * 2.判断方法*//*

        String methodName=req.getParameter("method");     //定义的参数名
        if (methodName==null || methodName.trim().isEmpty()){
            throw new RuntimeException("没有传递method参数，无法调用方法");
        }

        *//*得到方法名称，通过反射调用，不再判断了
        * 1.得到方法名，通过方法名得到Mehtod类的对象
        *   需要得到class，然后得到Method*//*
        Class cls=this.getClass();  //得到当前类的class对象
        Method method =null;
        try {
            method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("调用方法："+methodName+"，不存在");
        }

        *//*调用方法*//*
        try {
            method.invoke(this,req,resp);   //反射调用，相当于this.addUser(req,resp)
        } catch (Exception e) {
            System.out.println("调用方法："+methodName+"，内部抛出异常");
            throw new RuntimeException(e);
        }

        *//*1*//*
//        if (methodName.equals("addUser")){
//            addUser(req,resp);
//        }else if (methodName.equals("editUser")){
//            editUser(req,resp);
//        }else if (methodName.equals("deleteUser")){
//            deleteUser(req, resp);
//        }

        //访问的是http://localhost:8080/javaweb_war_exploded/E?method=addUser
    }*/

    /*3，BaseServlet的使用，直接将此类，继承BaseServlet即可*/

    public void fun1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("调用了fun1()，内部异常");
        throw new IOException("测试内部异常");
    }

    public String fun2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("调用了fun2()，默认转发");
        return "/Hello.html";   //默认转发
    }

    public String fun3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("调用了fun3()，转发");
        return "f:/Hello.html";    //转发,通过修改BaseServlet确定
    }

    public String fun4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("调用了fun4()，重定向");
        return "r:/index.jsp";
//        request.getRequestDispatcher("/xxx").forward(request,response);//转发
//        response.sendRedirect(request.getContextPath()+"/xxx.jsp"); //重定向
    }
    public String fun5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("调用了fun5()，不支持的d操作");
        return "d:/Hello.html";    //不支持的操作
    }
}
