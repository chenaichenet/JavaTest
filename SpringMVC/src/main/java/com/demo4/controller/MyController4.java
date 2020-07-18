/**
 * FileName: MyController4
 * Author:   嘉平十七
 * Date:     2020/7/16 18:58
 * Description:
 * notes：
 */
package com.demo4.controller;

import com.demo3.vo.Param;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController4 {
    /*处理器方法返回String——表示逻辑视图名称，需要配置视图解析器*/
    @RequestMapping(value = {"/returnString-view"})
    public String doRetrunView(HttpServletRequest request, String name, int age){
        //可以手动添加数据到request域
        request.setAttribute("tname",name);
        request.setAttribute("tage",age);
        //show：逻辑视图名称
        return "show";
    }
    /*处理器方法返回String——表示完整视图名称，此时不能配置视图解析器
    * 此时如果配置的视图解析器，会出现404错误，转发地址重复了——WEB-INF/jsp/WEB-INF/jsp/show2.jsp.jsp*/
    @RequestMapping(value = {"/returnString-view2"})
    public String doRetrunView2(HttpServletRequest request, String name, int age){
        //可以手动添加数据到request域
        request.setAttribute("tname",name);
        request.setAttribute("tage",age);
        //show：逻辑视图名称
        return "/WEB-INF/jsp/show";
    }
    /*返回void，响应Ajax请求
    * 手工实现Ajax，json数据：代码有重复的：1、Java对象转为json；2、通过HttpServletResponse输出json数据*/
    @RequestMapping(value = {"/returnVoid-ajax"})
    public void doRetrunVoid(HttpServletResponse response, String name, int age) throws IOException {
        //处理Ajax，使用json做数据的格式
        //service调用完成了，使用Param表示处理结果
        Param param=new Param();
        param.setName(name);
        param.setAge(age);
        String json="";
        //把结果的对象转为json格式的数据
        if (param!=null) {
            ObjectMapper objectMapper=new ObjectMapper();
            json=objectMapper.writeValueAsString(param);
            System.out.println("param转换的json："+json);
        }
        //输出数据，响应Ajax的请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();
    }
    /*处理器方法返回Objcet（Param），通过框架转为json，响应Ajax请求
    * @ResponseBody：把处理器方法返回的对象，转为json后通过HttpServletResponse输出到浏览器
    *   位置：在方法的定义上面，和其他注解没有顺序的先后
    * 返回对象框架的处理流程：
    *   1、框架会把返回Param类型，调用框架中的ArralList<HttpMessageConverter>中的每个类的canWriter()方法来检查哪个实现类能处理Param类型的数据。
    *       最后是MappingJackson2HttpMessageConverter这个返回ture。
    *   2、框架会调用实现类的write()，把param对象转为json，调用的是jackson中的ObjectMapper实现。
    *   3、框架会调用@ResponseBody的功能，把步骤2的结果输出到浏览器。*/
    @RequestMapping(value = {"/returnParamJson"})
    @ResponseBody
    public Param doParamJsonObject(String name, int age){
        //调用service，获取请求的数据，Param对象表示结果数据
        Param param=new Param();
        param.setName("李四");
        param.setAge(40);
        return param;   //对象会被框架转为json
    }
    /*处理器方法返回List<Param>*/
    @RequestMapping(value = {"/returnParamJsonArray"})
    @ResponseBody
    public List<Param> doParamJsonObjectArray(String name, int age){
        List<Param> list=new ArrayList<>();
        //调用service，获取请求的数据，Param对象表示结果数据
        Param param=new Param();
        param.setName("李四");
        param.setAge(40);
        list.add(param);

        param=new Param();
        param.setName("王五");
        param.setAge(50);
        list.add(param);

        return list;
    }
    /*处理器方法返回Stirng，表示数据的，不是视图
    * 区分返回值String是数据还是视图，在于@ResponseBody注解
    *
    * 响应头（text/plain;charaset=ISO-8859-1）编码默认使用的是ISO-8859-1编码，所以中文会出现乱码
    * 在@RequestMapping中使用produces属性，可以指定编码*/
    @RequestMapping(value = "/returnStringData",produces = "text/plain;charaset=utf-8")
    @ResponseBody
    public String doStringData(String name,int age){
        return "Hello SpringMVC 返回对象，表示数据";
    }
}