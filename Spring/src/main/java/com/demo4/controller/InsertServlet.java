package com.demo4.controller;

import com.demo4.domain.Classmate;
import com.demo4.service.ClassmateService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
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

        /*此处的容器对象，会在每次访问InsertServlet时都会创建一个
        * 但是这样是不合理的，在web项目中，只需要一个即可。所以要把容器对象放到全局作用域中ServletContext中。*/
//        ApplicationContext context=new ClassPathXmlApplicationContext("spring4.xml");

        /*使用监听器*/
//        WebApplicationContext context=null;
//        //获取ServletContext中的容器对象
//        String key=WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
//        Object attribute = getServletContext().getAttribute(key);
//        if (attribute!=null){
//            context= (WebApplicationContext) attribute;
//        }

        /*使用框架中的方法，获取容器对象*/
        ServletContext servletContext=getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        System.out.println("容器对象的信息："+context);
        ClassmateService classmateService = (ClassmateService) context.getBean("classmateService");
        int num = classmateService.insert(classmate);
        System.out.println(num);

        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
