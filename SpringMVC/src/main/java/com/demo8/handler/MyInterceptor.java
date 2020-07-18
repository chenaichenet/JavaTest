/**
 * FileName: MyInterceptor
 * Author:   嘉平十七
 * Date:     2020/7/18 18:40
 * Description: 拦截器类
 * notes：
 */
package com.demo8.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class MyInterceptor implements HandlerInterceptor {
    /*验证登录的用户信息*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String loginName="";
        //从session中获取name
        Object name = request.getSession().getAttribute("name");
        if (name!=null){
            loginName= (String) name;
        }
        //判断
        if (!"test".equals(loginName)){
            //不能访问
            request.getRequestDispatcher("/tips.jsp").forward(request,response);
            return false;
        }
        return true;
    }
}