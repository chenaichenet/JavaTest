/*
 * 通过定义参数的方法
 * 实现servlet的转发和重定向*/
package com.servlet_filter_listener_demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DemoServlet")
public class DemoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集格式为utf-8
        request.setCharacterEncoding("UTF-8");
        String name=request.getParameter("name");
        String pwd=request.getParameter("pwd");
        if ((name!=null&&!name.equals(""))&&(pwd!=null&&!pwd.equals(""))) {
            if(name.equals("admin")&&pwd.equals("123456")){
                request.getRequestDispatcher("/VerifyCodeDemo/success.jsp").forward(request, response);//转发，地址栏不变，一次请求
//                request.getRequestDispatcher("Hello.html").forward(request,response);
            }else {
//                request.getRequestDispatcher("error.jsp").forward(request, response);
                response.sendRedirect(request.getContextPath()+"/VerifyCodeDemo/error.jsp");   //重定向，地址栏发生变化
//                response.sendRedirect(request.getContextPath()+"/Hello.html");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}