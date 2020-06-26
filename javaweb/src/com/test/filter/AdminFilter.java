package com.test.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        String name= (String) request.getSession().getAttribute("admin");
        if (name!=null){
            /*获取admin，如果不为空，就是管理员*/
            chain.doFilter(req, resp);
            return;
        }else {
            request.setAttribute("msg","没有管理员权限");
            request.getRequestDispatcher("/UserDemo/login.jsp").forward(req,resp);
            System.out.println("AdminFilter拦截");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
