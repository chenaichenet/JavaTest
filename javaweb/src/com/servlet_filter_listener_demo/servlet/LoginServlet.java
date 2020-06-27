package com.servlet_filter_listener_demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");  //处理中文问题

        /*1.获取用户名，获取密码
        * 2.判断用户名中和密码是否为“”,
        *   3.如果不为空，且包含特定字符，就是管理员
        *   4.如果不包含，就是普通用户
        *   5.否则就是游客
        * 6.把登录的用户名称保存到session中
        * 7.转发到welcome.jsp*/
        String name=request.getParameter("username");
        String password=request.getParameter("password");

        if (name!="" && password!=""){
            if (name.contains("chen") && password.equals("123456")){
                request.getSession().setAttribute("admin",name);
                //name是login.jsp中提交的值，一个键值对：username：chen
                //setAttribute，创建一个新的session域对象，名称为andmin，值为name的值
            }else {
                request.getSession().setAttribute("username",name);
            }
        }else {
            request.getSession().setAttribute("tourist",name);
        }

        request.getRequestDispatcher("/UserDemo/welcom.jsp").forward(request,response);
        System.out.println("已经转发");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}