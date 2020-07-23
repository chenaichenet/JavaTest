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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    /*采用自动注入引用类型后，可以直接在这里定义service对象*/
    @Autowired
    private ClassmateService service;

    ModelAndView modelAndView=new ModelAndView();
    WebApplicationContext context= ContextLoader.getCurrentWebApplicationContext();
    @RequestMapping(value = "/selectAll.do")
    public ModelAndView doSelectAll(){
//        System.out.println(servletContext);
//        modelAndView.addObject("msg",servletContext);
//        modelAndView.addObject("msg2",context);
//        modelAndView.setViewName("show");

        /*上面采用了自动注入，所以这里就可以不需要在获取service，直接使用即可*/
//        ClassmateService classmateService = (ClassmateService) context.getBean("classmateService");
        List<Classmate> classmateList = service.squeryAll();

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
        List<Classmate> classmateList = service.squeryWhere(sid);
        System.out.println("=====");
        System.out.println(classmateList);
        classmateList.forEach(classmate -> System.out.println(classmate));
        System.out.println(classmateList.get(0));
        System.out.println("=====");
        Classmate classmate=classmateList.get(0);
        System.out.println(classmate.getId());
        System.out.println("=====");

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
        int num = service.insert(classmate);
        doSelectAll();
            modelAndView.addObject("msg","影响"+num+"行数据");
        modelAndView.setViewName("result");
        return modelAndView;
    }
    @RequestMapping(value = "/update.do")
    public ModelAndView doUpdate(Classmate cla){
        Classmate classmate = (Classmate) context.getBean("classmate");
        classmate.setId(cla.getId());
        classmate.setName(cla.getName());
        classmate.setAge(cla.getAge());
        classmate.setAddress(cla.getAddress());
        classmate.setPhone(cla.getPhone());

        int num = service.update(classmate);
        doSelectAll();
        modelAndView.addObject("msg","影响"+num+"行数据");
        modelAndView.setViewName("result");
        return modelAndView;
    }
    @RequestMapping(value = "/delete.do")
    public ModelAndView doDelete(int sid){
        int num = service.delete(sid);
        doSelectAll();
        modelAndView.addObject("msg","影响"+num+"行数据");
        modelAndView.setViewName("result");
        return modelAndView;
    }

    /*使用html*/
    @RequestMapping(value = "/html/login.so")
    public ModelAndView doLogin(int id,int phone){
//        ClassmateService classmateService = (ClassmateService) context.getBean("classmateService");
        List<Classmate> classmateList=service.squeryWhere(id);
        Classmate classmate=null;
        if (classmateList.get(0)==null){
            modelAndView.addObject("msg","id不存在");
        }else {
            classmate=classmateList.get(0);
            if (phone==classmate.getPhone()){
                modelAndView.addObject("msg","成功");
            }
        }
        System.out.println(classmateList);
        modelAndView.setViewName("result");
        return modelAndView;
    }

    /*响应Ajax查询所有数据*/
    @RequestMapping("/queryClassmate.do")
    @ResponseBody
    public List<Classmate> queryClassmate(){
        //参数检查，简单的数据处理
        List<Classmate> classmateList=service.squeryAll();
        return classmateList;   //classmateList就是查询结果，会被框架转成一个json格式的数组
    }
}