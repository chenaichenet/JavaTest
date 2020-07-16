/**
 * FileName: MyController
 * Author:   嘉平十七
 * Date:     2020/7/16 7:31
 * Description:
 * notes：
 */
package com.mytest.controller;


import com.mytest.domain.Classmate;
import com.mytest.service.ClassmateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MyTestController {
    ModelAndView modelAndView=new ModelAndView();
    @RequestMapping(value = "/selectAll.do")
    public ModelAndView doSelectAll(HttpServletRequest request, HttpServletResponse response){

        ServletContext servletContext=request.getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
//        System.out.println(servletContext);
//        modelAndView.addObject("msg",servletContext);
//        modelAndView.addObject("msg2",context);
//        modelAndView.setViewName("show");

        ClassmateService classmateService = (ClassmateService) context.getBean("classmateService");
        List<Classmate> classmateList = classmateService.squeryAll();

        modelAndView.addObject("list",classmateList);
        modelAndView.addObject("msg","查询成功");
        modelAndView.setViewName("result");

        return modelAndView;
    }
    @RequestMapping(value = "/selectWhere.do")
    public ModelAndView doSelectWhere(HttpServletRequest request,HttpServletResponse response){
        ServletContext servletContext=request.getServletContext();
        WebApplicationContext context=WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        int sid= Integer.parseInt(request.getParameter("sid"));

        ClassmateService classmateService=(ClassmateService)context.getBean("classmateService");
        List<Classmate> classmateList = classmateService.squeryWhere(sid);

        modelAndView.addObject("list",classmateList);
        modelAndView.addObject("msg","查询成功");
        modelAndView.setViewName("result");
        return modelAndView;
    }
    @RequestMapping(value = "/insert.do")
    public ModelAndView doInsert(HttpServletRequest request,HttpServletResponse response){
        ServletContext servletContext=request.getServletContext();
        WebApplicationContext context=WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        int strId= Integer.parseInt(request.getParameter("id"));
        String strName=request.getParameter("name");
        int strAge= Integer.parseInt(request.getParameter("age"));
        String strAddress=request.getParameter("address");
        String strGender=request.getParameter("gender");
        int strPhone= Integer.parseInt(request.getParameter("phone"));

        Classmate classmate=new Classmate(strId,strName,strAge,strAddress,strGender,strPhone);
        ClassmateService classmateService = (ClassmateService) context.getBean("classmateService");
        int num = classmateService.insert(classmate);

        modelAndView.addObject("msg","影响"+num+"行数据");
        modelAndView.setViewName("result");
        return modelAndView;
    }
    @RequestMapping(value = "/update.do")
    public ModelAndView doUpdate(HttpServletRequest request,HttpServletResponse response){
        ServletContext servletContext=request.getServletContext();
        WebApplicationContext context=WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        int sid= Integer.parseInt(request.getParameter("sid"));

        ClassmateService classmateService = (ClassmateService) context.getBean("classmateService");
        int num = classmateService.update(sid);

        modelAndView.addObject("msg","影响"+num+"行数据");
        modelAndView.setViewName("result");
        return modelAndView;
    }
    @RequestMapping(value = "/delete.do")
    public ModelAndView doDelete(HttpServletRequest request,HttpServletResponse response){
        ServletContext servletContext=request.getServletContext();
        WebApplicationContext context=WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        int sid= Integer.parseInt(request.getParameter("sid"));

        ClassmateService classmateService = (ClassmateService) context.getBean("classmateService");
        int num = classmateService.delete(sid);

        modelAndView.addObject("msg","影响"+num+"行数据");
        modelAndView.setViewName("result");
        return modelAndView;
    }
}