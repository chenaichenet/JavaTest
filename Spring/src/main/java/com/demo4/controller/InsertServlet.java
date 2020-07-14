package com.demo4.controller;

import com.demo4.domain.Classmate;
import com.demo4.service.ClassmateService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int strId= Integer.parseInt(request.getParameter("id"));
        String strName=request.getParameter("name");
        int strAge= Integer.parseInt(request.getParameter("age"));
        String strAddress=request.getParameter("address");
        String strGender=request.getParameter("gender");
        int strPhone= Integer.parseInt(request.getParameter("phone"));

        Classmate classmate=new Classmate(strId,strName,strAge,strAddress,strGender,strPhone);

        ApplicationContext app=new ClassPathXmlApplicationContext("spring4.xml");
        System.out.println("容器对象的信息："+app);

        ClassmateService classmateService = (ClassmateService) app.getBean("classmateService");
        int num = classmateService.insert(classmate);
        System.out.println(num);

        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
