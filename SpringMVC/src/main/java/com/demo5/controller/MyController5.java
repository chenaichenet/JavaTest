/**
 * FileName: MyController5
 * Author:   嘉平十七
 * Date:     2020/7/18 16:15
 * Description: 转发和重定向
 * notes：
 */
package com.demo5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController5 {
    /*处理器返回ModelAndView实现forward
    * 语法：setViewName("forward:视图文件完整路径");
    * 特点：不和视图解析器一同使用，就好比没有使用视图解析器
    * 功能：显而易见，可以在配置了视图解析器的时候，也能跳转到指定的页面*/
    @RequestMapping("/doforward.do")
    public ModelAndView doForward(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","第五个SpringMVC项目");
        mv.addObject("fun","处理器返回ModelAndView实现forward");
        mv.setViewName("forward:/WEB-INF/jsp/show.jsp");
        return mv;
    }
    /*处理器返回ModelAndView实现redirect
     * 语法：setViewName("redirect:视图文件完整路径");
     * 特点：不和视图解析器一同使用，就好比没有使用视图解析器
     *
     * 框架对重定向的操作：
     * 1、框架会把Model中的简单类型的数据，转为字符串使用，作为重定向页面的get请求参数使用，可以在请求和重定向的请求之间传递数据
     * 2、而在转发的页面中，使用el表达式，却不能取出值，这是因为，重定向是两个请求，所以是不同的request
     *    但是，此时会发现，传递过去的参数，在url中会显示，所以，在原来的el表达式中，使用param.xxx就可以取出参数了*/
    @RequestMapping("/doredirect.do")
    public ModelAndView doRedirect(int age){
        ModelAndView mv=new ModelAndView();
        //数据是放到request作用域
        mv.addObject("msg","第五个SpringMVC项目");
        mv.addObject("fun",age);
//        mv.setViewName("redirect:/WEB-INF/jsp/show.jsp");//这个地址是访问不到的，重定向是两次请求，无法获取WEB-INF中的资源
        mv.setViewName("redirect:/res.jsp");
        /*对于jsp
        *   <h2>当处理器方法返回ModelAndView实现redirect</h2>
            <h3>msg数据：${param.msg}</h3>
            <h3>fun数据：${param.fun}</h3>*/
        return mv;
    }
}