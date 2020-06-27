/*分IP统计访问次数
**/
package com.servlet_filter_listener_demo.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.LinkedHashMap;
import java.util.Map;

@WebListener()
public class IPCountListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /*在服务器启动时创建Map，并保存到ServletContext中*/
        //创建Map
        Map<String,Integer> map=new LinkedHashMap<String, Integer>();
        //得到ServletContext
        ServletContext application = sce.getServletContext();
        //把map保存到
        application.setAttribute("map",map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}