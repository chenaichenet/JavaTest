package com.ajax_demo.servelt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResponseXMLServlet")
public class ResponseXMLServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml;charset=utf-8");

        String xml="<students>"+
                "<student number='1001'>"+
                "<name>张三</name>"+
                "<age>20</age>"+
                "</student>"+
                "</students>";
        response.getWriter().print(xml);
    }
}
