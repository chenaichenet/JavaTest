/*网站访问量统计*/
package com.servlet_filter_listener_demo.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "VisitCountServlet")
public class VisitCountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext visit=this.getServletContext();
        Integer count=(Integer)visit.getAttribute("count");
        if (count==null){
            visit.setAttribute("count",1);
        }else {
            visit.setAttribute("count",count+1);
        }
        System.out.println(count);
        /*向浏览器输出
        * 需要响应对象*/
        PrintWriter pw=response.getWriter();
        pw.print("<h1>"+count+"</h1>");
    }
}
