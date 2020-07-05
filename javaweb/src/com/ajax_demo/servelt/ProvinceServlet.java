package com.ajax_demo.servelt;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "ProvinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        /*响应所有省份名称，使用逗号分割*/
        /*Document对象
        *   创建解析器对象
        *   调用解析器读方法，传递一个流对象，得到Document*/
        try {
            SAXReader reader=new SAXReader();
            InputStream input=this.getClass().getResourceAsStream("E:/china.xml");
            Document doc=reader.read(input);

            /*查询所有province的name属性
            * 循环遍历所有属性值，连接成一个字符串*/
            List<Attribute> list=doc.selectNodes("/province/@name");//查找所有province下的name属性
            StringBuilder str=new StringBuilder();
            for (int i=0;i<list.size();i++){
                //把每个属性的值存放到str
                str.append(list.get(i).getValue());
                if (i<list.size()-1){
                    //最后一个不加逗号
                    str.append(",");
                }
            }
            response.getWriter().print(str);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
