/**
 * FileName: MyController7
 * Author:   嘉平十七
 * Date:     2020/7/18 18:37
 * Description: 拦截器
 * notes：
 */
package com.demo8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController8 {
    @RequestMapping("/doLogin.do")
    public ModelAndView doInterceptor(String name,int age){
        System.out.println("===执行MyController7中的doInterceptor()===");
        ModelAndView mv=new ModelAndView();
        mv.addObject("tname",name);
        mv.addObject("tage",age);
        mv.setViewName("show");
        return mv;
    }
}