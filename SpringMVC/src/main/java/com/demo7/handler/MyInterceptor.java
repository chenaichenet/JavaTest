/**
 * FileName: MyInterceptor
 * Author:   嘉平十七
 * Date:     2020/7/18 18:40
 * Description: 拦截器类
 * notes：
 */
package com.demo7.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class MyInterceptor implements HandlerInterceptor {
    private long btime=0;   //开始时间

    /*预处理方法
    * 参数：Object handler，被拦截的控制器对象，此处是MyController7
    * 返回值：boolean，true表示请求通过验证，可以执行处理器方法；false，只执行预处理方法，后面的方法都不执行了。
    * 特点：1、方法在控制器方法（此处是MyController7中的doInterceptor()）之前先执行
    *      2、在该方法中，可以获取请求信息，验证请求是否符和要求
    * 登录验证，权限验证*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        btime=System.currentTimeMillis();
        System.out.println("拦截器MyInterceptor的preHandle()");
        //给浏览器返回一个结果
        if ("test".equals(request.getParameter("name"))){
            request.getRequestDispatcher("/tips.jsp").forward(request,response);
            return false;
        }
        return true;
    }

    /*后处理方法
    * 参数：Object handler, 被拦截的处理器对象；ModelAndView modelAndView，处理器方法的返回值
    * 特点：1、在处理器方法之后执行的
    *      2、能获取到处理器方法的返回值，可以修改返回值中的数据和视图，可以影响到最后的结果
    * 主要是对原来的执行结果进行二次修正*/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器MyInterceptor的postHandle()");
        //对处理器方法返回的结果，调整
        if (modelAndView!=null){
            //修改数据
            modelAndView.addObject("msg",new Date());
            //修改视图
            modelAndView.setViewName("test");
        }
    }

    /*最后执行
    * 参数：Object handler，被拦截的处理器对象；Exception ex，程序中发生的异常
    * 特点：1、在请求处理完成后执行的，框架中规定，当视图处理完成后，对视图执行的forward，就认为请求处理完成了
    * 一般是资源回收工作，程序请求过程中创建的对象，在这里删除，回收内存*/
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器MyInterceptor的afterCompletion()");
        long etime=System.currentTimeMillis();
        System.out.println("计算从preHandle到afterCompletion时间："+(etime-btime));
    }
}