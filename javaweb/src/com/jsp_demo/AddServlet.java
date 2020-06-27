package com.jsp_demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s1=request.getParameter("num1");
        String s2=request.getParameter("num2");
        String s=request.getParameter("operation");

        int num1=Integer.parseInt(s1);
        int num2=Integer.parseInt(s2);
        int sum=0;

        if (s.equals("plus")){
             sum=num1+num2;
        }else if (s.equals("reduce")){
            sum=num1-num2;
        }else if (s.equals("ride")){
            sum=num1*num2;
        }else if (s.equals("except")){
            sum=num1/num2;
        }

        request.setAttribute("result",sum);

        request.getRequestDispatcher("/JSPDemo/result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
