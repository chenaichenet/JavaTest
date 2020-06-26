package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*1.获取用户名
        * 2.判断用户名中是否包含itcast
        *   3.如果包含，就是管理员
        *   4.如果不包含，就是普通用户
        * 5。包登录的用户名称保存到session中
        * 6。转发到welcome.jsp*/
        String name=request.getParameter("username");
        if (name.contains("chen")){
            request.getSession().setAttribute("admin",name);
        }else {
            request.getSession().setAttribute("username",name);
        }
        request.getRequestDispatcher("/UserDemo/welcom.jsp").forward(request,response);
        System.out.println("已经转发");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}