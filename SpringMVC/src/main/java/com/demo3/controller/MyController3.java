/**
 * FileName: MyController3
 * Author:   嘉平十七
 * Date:     2020/7/15 18:49
 * Description:
 * notes：
 */
package com.demo3.controller;

import com.demo3.vo.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MyController3 {
    /*逐个接收请求的参数
    *   要求：处理器方法的形参名和请求中的参数名必须一致，同名的请求参数赋值给同名的形参
    * 框架接收请求参数
    *   1、使用request对象接收请求参数
    *       String strName=request.getParameter("name");
    *       String strAge=request.getParameter("age");
    *   2、springmvc框架通过DispatcherServlet调用MyController3的doSome()方法
    *       调用方法时，按照名称对应把接收的参数赋给形参
    *       doSome(strName,Integer.valueOf(strAge))
    *       框架会提供类型转换的功能，能够把string字符串转换成其他能转的类型
    *
    * 当jsp中的年龄为空时，会出现400状态码
    * 400状态码是客户端错误，表示提交请求参数过程中，发生了问题，这里是因为不能把“”转换成int类型
    * 而这里，把方法参数中的int age换成Integer age，使用包装类型可以解决不输入age的问题，此时的age=null*/

    @RequestMapping(value = {"/receiveproperty.do"},method = RequestMethod.POST)
    public ModelAndView doReceiveproperty(String name,int age){
        ModelAndView mv=new ModelAndView();

        mv.addObject("tname",name);
        mv.addObject("tage",age);

        mv.setViewName("show");
        return mv;
    }

    /*请求中参数名和处理器方法中的形参名不一样
    * @RequestParam：在逐个接收请求参数中，解决这个问题
    *   属性：value，请求中的参数名
    *        required，boolean类型，默认true，表示请求中必须包含此参数
    *   位置：在处理器方法形参名定义之前*/
    @RequestMapping(value = {"/receiveparam.do"},method = RequestMethod.POST)
    public ModelAndView doReceiveparam(@RequestParam(value = "rname",required = true) String name,@RequestParam(value = "rage") int age){
        ModelAndView mv=new ModelAndView();
        mv.addObject("tname",name);
        mv.addObject("tage",age);
        mv.setViewName("show");
        return mv;
    }
    /*处理器方法形参是Java对象，对象属性名和请求参数名一样
    * 框架会创建形参的Java对象，给属性赋值
    * 请求中的参数名是name，框架会调用setName()*/
    @RequestMapping(value = {"/receiveobject.do"},method = RequestMethod.POST)
    public ModelAndView doReceiveobject(Param param){
        ModelAndView mv=new ModelAndView();
        mv.addObject("tname",param.getName());
        mv.addObject("tage",param.getAge());
        mv.addObject("par",param);
        mv.setViewName("show");
        return mv;
    }
}