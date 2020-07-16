/**
 * FileName: MyController4
 * Author:   嘉平十七
 * Date:     2020/7/16 18:58
 * Description:
 * notes：
 */
package com.demo4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController4 {
    /*处理器方法返回String——表示逻辑视图名称，需要配置视图解析器*/
    @RequestMapping(value = {"/retrunString-view.do"})
    public String doRetrunView(HttpServletRequest request, String name, int age){
        //可以手动添加数据到request域
        request.setAttribute("tname",name);
        request.setAttribute("tage",age);
        //show：逻辑视图名称
        return "show3";
    }
    /*处理器方法返回String——表示完整视图名称，此时不能配置视图解析器
    * 此时如果配置的视图解析器，会出现404错误，转发地址重复了——WEB-INF/jsp/WEB-INF/jsp/show2.jsp.jsp*/
    @RequestMapping(value = {"/returnString-view2.do"})
    public String doRetrunView2(HttpServletRequest request, String name, int age){
        //可以手动添加数据到request域
        request.setAttribute("tname",name);
        request.setAttribute("tage",age);
        //show：逻辑视图名称
        return "/WEB-INF/jsp/show3";
    }
}