/**
 * FileName: MyController2
 * Author:   嘉平十七
 * Date:     2020/7/15 17:56
 * Description:
 * notes：
 */
package com.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*@RequestMapping，注解在类上
* value：所有请求地址的公共部分，叫做模块名称*/

@Controller
@RequestMapping("/test")
public class MyController2 {
    /*@RequestMapping：请求映射
    *   method属性：表示请求的方式，其值是RequestMethod类的枚举值
    *   例如，表示get，RequestMethod.GET；表示post，RequestMethod.POST
    *   不指定请求方式，就没有限制*/

    //指定some.do使用get请求方式
    @RequestMapping(value = {"/some.do","/first.do"},method = RequestMethod.GET)
    public ModelAndView doSome(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        ModelAndView mv=new ModelAndView();

        mv.addObject("msg","@RequestMapping的详细使用");
        mv.addObject("fun","执行doSome()方法，新增功能，获取name参数："+request.getParameter("name"));

        mv.setViewName("show");
        return mv;
    }
    //指定other.do使用post请求方式
    @RequestMapping(value = {"/other.do"},method = RequestMethod.POST)
    public ModelAndView doOther(){
        ModelAndView mv=new ModelAndView();

        mv.addObject("msg","@RequestMapping的详细使用");
        mv.addObject("fun","执行doOther()方法");

        mv.setViewName("show");
        return mv;
    }
}