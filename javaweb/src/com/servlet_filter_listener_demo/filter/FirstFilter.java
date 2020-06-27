/*过滤器
* 过滤器如何编写
* 1.写一个类，实现Filter接口
* 2.在web.xml中进行配置
* FirstFilter过滤器，只过滤OutServlet，而且放行了*/
package com.servlet_filter_listener_demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "FirstFilter")
public class FirstFilter implements Filter {
    public void destroy() {
        System.out.println("过滤器销毁成功！");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("拦截");
        chain.doFilter(req, resp);  //放行
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器创建成功！");
    }
}
