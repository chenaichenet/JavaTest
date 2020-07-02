package com.ajax_demo.servelt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AJAXDemoServlet")
public class AJAXDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String username=request.getParameter("username");
        System.out.println("【POST】Hello World、"+username);
        response.getWriter().print("【POST】Hello AJAX、"+username);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("【GET】Hello World");
        response.getWriter().print("【GET】Hello AJAX");
    }
}
