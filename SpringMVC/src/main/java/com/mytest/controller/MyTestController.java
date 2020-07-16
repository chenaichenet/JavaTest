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

    @RequestMapping(value = "/selectAll.do")
    public ModelAndView doSelectAll(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView=new ModelAndView();

        ServletContext servletContext=request.getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
//        System.out.println(servletContext);
//        modelAndView.addObject("msg",servletContext);
//        modelAndView.addObject("msg2",context);
//        modelAndView.setViewName("show");

        ClassmateService classmateService = (ClassmateService) context.getBean("classmateService");
        List<Classmate> classmateList = classmateService.squeryAll();

        modelAndView.addObject("list",classmateList);
        modelAndView.setViewName("result");

        return modelAndView;
    }
}