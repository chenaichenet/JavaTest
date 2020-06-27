package com.servlet_filter_listener_demo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /*1.得到session
        * 2.判断session域中是否存在admin，如果存在放行
        * 3.判断session域中是否存在username，如果存在放行
        * 4.否则打回login.jsp*/
        HttpServletRequest request= (HttpServletRequest) req; //强转，用它才能使用getSession()方法
        String name = (String) request.getSession().getAttribute("admin");
        if (name!=null){
            /*获取admin，如果不为空，就是管理员*/
            chain.doFilter(req, resp);
            return;
        }
        name=(String)request.getSession().getAttribute("username"); //获取用户
        if (name!=null){
            chain.doFilter(req,resp);
        }else {
            request.setAttribute("msg","游客请登录");    //保存错误信息到request域中，再转发
            request.getRequestDispatcher("/UserDemo/login.jsp").forward(req,resp);
            System.out.println("UserFilter拦截");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
