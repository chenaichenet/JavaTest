package com.servlet_filter_listener_demo.filter;

import com.servlet_filter_listener_demo.java.EncodingRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "CodingFilter")
public class CodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //处理post请求编码问题
        req.setCharacterEncoding("UTF-8");

        //处理get请求编码问题
//        String username=req.getParameter("username");
//        username=new String(username.getBytes("ISO-8859-1"),"utf-8");
        //设置编码后，没有方法传递回去。而且直接使用username，不妥当，不能确保用户要的要的就是这个

        /*自定义request
        * 1.写一个request装饰类
        * 2.放行时使用自定义的request*/
        HttpServletRequest request= (HttpServletRequest) req;
        EncodingRequest er=new EncodingRequest(request);

        chain.doFilter(er, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
