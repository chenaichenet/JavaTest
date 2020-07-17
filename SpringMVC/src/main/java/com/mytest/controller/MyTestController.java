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
import org.springframework.web.context.ContextLoader;
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
    WebApplicationContext context= ContextLoader.getCurrentWebApplicationContext();
    @RequestMapping(value = "/selectAll.do")
    public ModelAndView doSelectAll(){
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

    /*第一版的格式
    * 这里是通过HttpServletRequest，HttpServletResponse这两个对象来获取WebApplicationContext，这里的思路还是Servlet时的样式
    * 但是此时已经在web.xml中注册了监听器，但是并没有使用，而使用监听器，可以由框架提供的方法获取WebApplicationContext
    *     WebApplicationContext context= ContextLoader.getCurrentWebApplicationContext();
    * 而后，通过springmvc的请求参数，对于demo3包下的例子，可以不用再通过int sid= Integer.parseInt(request.getParameter("sid"));来获取请求参数*/

//    @RequestMapping(value = "/selectWhere.do")
//    public ModelAndView doSelectWhere(HttpServletRequest request,HttpServletResponse response){
//        ServletContext servletContext=request.getServletContext();
//        WebApplicationContext context=WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
//        int sid= Integer.parseInt(request.getParameter("sid"));
//        ClassmateService classmateService=(ClassmateService)context.getBean("classmateService");
//        List<Classmate> classmateList = classmateService.squeryWhere(sid);
//        modelAndView.addObject("list",classmateList);
//        modelAndView.addObject("msg","查询成功");
//        modelAndView.setViewName("result");
//        return modelAndView;
//    }
    @RequestMapping(value = "/selectWhere.do")
    public ModelAndView doSelectWhere(int sid){

        ClassmateService classmateService=(ClassmateService)context.getBean("classmateService");
        List<Classmate> classmateList = classmateService.squeryWhere(sid);

        modelAndView.addObject("list",classmateList);
        modelAndView.addObject("msg","查询成功");
        modelAndView.setViewName("result");
        return modelAndView;
    }

    /*这里也是，对应demo3中的对象传参，需要注意，使用对象传递参数，需要参数与对象属性名一致*/
    @RequestMapping(value = "/insert.do")
    public ModelAndView doInsert(Classmate cla){

        /*使用这种模式就离不开HttpServletRequest，HttpServletResponse两个对象*/
//        int strId= Integer.parseInt(request.getParameter("id"));
//        String strName=request.getParameter("name");
//        int strAge= Integer.parseInt(request.getParameter("age"));
//        String strAddress=request.getParameter("address");
//        String strGender=request.getParameter("gender");
//        int strPhone= Integer.parseInt(request.getParameter("phone"));

        /*直接使用对象传递请求参数
        * tip：这里是否可以使用spring的IoC来创建classmate对象*/
        Classmate classmate=new Classmate(cla.getId(),cla.getName(),cla.getAge(),cla.getAddress(),cla.getGender(),cla.getPhone());
        ClassmateService classmateService = (ClassmateService) context.getBean("classmateService");
        int num = classmateService.insert(classmate);
        doSelectAll();
        modelAndView.addObject("msg","影响"+num+"行数据");
        modelAndView.setViewName("result");
        return modelAndView;
    }
    @RequestMapping(value = "/update.do")
    public ModelAndView doUpdate(int sid){
        ClassmateService classmateService = (ClassmateService) context.getBean("classmateService");
        int num = classmateService.update(sid);
        doSelectAll();
        modelAndView.addObject("msg","影响"+num+"行数据");
        modelAndView.setViewName("result");
        return modelAndView;
    }
    @RequestMapping(value = "/delete.do")
    public ModelAndView doDelete(int sid){
        ClassmateService classmateService = (ClassmateService) context.getBean("classmateService");
        int num = classmateService.delete(sid);
        doSelectAll();
        modelAndView.addObject("msg","影响"+num+"行数据");
        modelAndView.setViewName("result");
        return modelAndView;
    }
}