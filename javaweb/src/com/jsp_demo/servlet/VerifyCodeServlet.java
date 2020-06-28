/*登录功能添加验证码
* 这里要挂钩之前com.servlet_filter_listener_demo下的LoginServlet*/
package com.jsp_demo.servlet;

import com.test.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet(name = "VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*1.生成图片
         * 2.保存图片上的文本到session域中
         * 3.把图片响应给客户端*/
        VerifyCode verifyCode=new VerifyCode();
        BufferedImage image=verifyCode.getImage();
        //保存图片上的文本到session域
        request.getSession().setAttribute("session_vcode",verifyCode.getText());

        VerifyCode.output(image,response.getOutputStream());
    }
}
