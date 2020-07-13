package web.controller;

import com.demo4.domain.Classmate;
import com.demo4.service.ClassmateService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class InsertServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //获取数据
        String strId=request.getParameter("id");
        String strName=request.getParameter("name");
        String strAge=request.getParameter("age");
        String strAddress=request.getParameter("address");
        String strGender=request.getParameter("gender");
        String strPhone=request.getParameter("phone");
        //创建spring容器对象
        ApplicationContext app=new ClassPathXmlApplicationContext("spring4.xml");
        System.out.println("容器对象的信息："+app);
        //获取service
        ClassmateService classmateService = (ClassmateService) app.getBean("classmateService");
        //赋值，强制类型转换
        Classmate classmate=new Classmate(Integer.parseInt(strId),strName,Integer.parseInt(strAge),strAddress,strGender,Integer.parseInt(strPhone));
        int num = classmateService.insert(classmate);
        System.out.println(num);

        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
