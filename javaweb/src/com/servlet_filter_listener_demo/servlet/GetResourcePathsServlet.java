package com.servlet_filter_listener_demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

@WebServlet(name = "GetResourcePathsServlet")
public class GetResourcePathsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*获取资源路径*/
        String path=this.getServletContext().getRealPath("/index.jsp");
        System.out.println(path);
        /*获取资源流*/
        InputStream input=this.getServletContext().getResourceAsStream("/index.jsp");
        /*获取指定目录下的资源路径*/
        Set parths=this.getServletContext().getResourcePaths("/WEB-INF");
        System.out.println(parths);
    }
}
