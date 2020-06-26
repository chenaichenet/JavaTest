/*分IP统计访问次数
*从application中获取Map
* 从request中获取当前客户端IP
* 进行统计工作，结果保存到Map中*/
package com.test.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Map;

@WebFilter(filterName = "IPCountFilter")
public class IPCountFilter implements Filter {
    private FilterConfig config;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /*1.得到application中的map
        * 2.从request中获取当前IP
        * 3.统计结果保存到map
        * 4.当有用户访问时，获取请求的IP，如果IP在Map中存在，说明以前访问过，就在访问次数上加1即可;
        * 如果不存在，就设置次数为1。*/

        //得到application
        //因为通过req得到application需要强制转型，所以不建议。
        //为此，使用init中的config，通过config.getServletContext()，于是可以创建一个全局变量，来存init中得到的
        ServletContext app=config.getServletContext();
        Map<String,Integer> map= (Map<String, Integer>) app.getAttribute("map");
        //获取IP
        String ip=req.getRemoteAddr();
        //进行判断
        if (map.containsKey(ip)){//存在
            int cnt=map.get(ip);
            map.put(ip,cnt+1);
        }else {
            map.put(ip,1);
        }
        app.setAttribute("map",map);    //把map放回到application

        chain.doFilter(req, resp);  //只统计，要放行
    }

    public void init(FilterConfig fconfig) throws ServletException {
        this.config=fconfig;
    }
}