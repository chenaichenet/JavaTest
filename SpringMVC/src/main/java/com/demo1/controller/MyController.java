/**
 * FileName: MyController
 * Author:   嘉平十七
 * Date:     2020/7/15 11:51
 * Description: 控制器类
 * notes：
 */
package com.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*@Controller创建控制器对象，对象放在springmvc容器中
* 能处理请求的都是控制器（处理器）：MyController能处理请求，叫做后端处理器（back controller）*/
@Controller
public class MyController {
    /*处理用户提交的请求，springmvc中是使用方法来处理的
    * 方法是自定义的，可以有多种返回值，多种参数*/

    /*准备使用doSome方法处理some.do请求
    * @RequestMapping：请求映射，作用是把一个请求地址和一个方法绑定到一起，一个请求一个方法处理
    *   属性：value：字符串，表示请求的url地址的（some.do），唯一值。使用时推荐以“/”开头
    *   位置：方法上面或类的上面
    * 使用@RequestMapping修饰的方法叫做处理器方法或这控制器方法，是可以处理请求的，类似Servlet中的doGet或者doPost
    *
    * 返回值：ModelAndView，本次请求的处理结果，数据和视图两部分，是框架中的类
    *   Model：数据，请求处理完成后要显示给用户的数据
    *   View：视图，比如jsp等*/
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(){   //doGet
        //处理some.do请求
        ModelAndView mv=new ModelAndView();

        //添加数据，框架在请求最后把数据放入到request作用域
        //相当于request.setAttribute("msg","Hello SpringMVC");
        mv.addObject("msg","Hello SpringMVC");
        mv.addObject("fun","指定doSome()方法");

        //指定视图，完整路径
        //框架对视图的使用执行的是forward操作，相当于request.getRequestDispatcher("/demo/show.jsp").forward(request,response);
        mv.setViewName("/demo1/show.jsp");

        //返回mv
        return mv;
    }
}