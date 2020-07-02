package com.ajax_demo.servelt;

import org.dom4j.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "CityServlet")
public class CityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml;charset=utf-8");

        /*获取省份名称，加载该省对应的<province>元素
        * 把元素转换成字符串发送给客户端*/
        try {
            /*得到Document*/
            SAXReader reader=new SAXReader();
            InputStream input=this.getClass().getResourceAsStream("china.xml");
            Document doc=reader.read(input);
            /*获取参数*/
            String pname=request.getParameter("pname");//获取省份名称
            Element proELe = (Element) doc.selectSingleNode("//province[@name='" + pname + "']");//查元素，方括号中是条件
            String xmlStr=proELe.asXML();   //把元素转换成字符串
            response.getWriter().print(xmlStr);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
