package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "ClassLoaderServlet")
public class ClassLoaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*1
        *文件在javaweb/src下
        * ClassLoader是相对于/classes目录的*/

//        ClassLoader cl=this.getClass().getClassLoader();
//        InputStream input=cl.getResourceAsStream("a.txt");

        /*2
        *使用Class，文件可以放到javaweb/src/com/text下
        * Class是相对于*.class文件所在的目录。
        * 事实上，javaweb项目发布给客户时，是不包含*.java文件的，都是将*.java文件编译成*.class文件，存储在输出的classes目录下
        * 而作为资源文件的a.txt，也会同时拷贝到classes目录下
        * 所以，打开目录会发现，项目中其实存在两个a.txt文件*/

        Class cl=this.getClass();
//        InputStream input=cl.getResourceAsStream("a.txt");
        //需要注意的是，当a.txt文件放回到src下，上面的代码就不能再使用，500异常，因为Class是相对于.class文件所在的路径

        /*3
        * 在src文件下的a.txt使用Class加载*/
//        InputStream input=cl.getResourceAsStream("/a.txt"); //加“/”相对于classes下，不加相对于当前.class文件所在目录

        /*4*/
        InputStream input=cl.getResourceAsStream("/../../index.jsp");
        //表示从classes目录下，回退两次，到index.jsp所在的目录
        //需要注意的是，必须以/开头，否则就表示从.class文件目录下开始回退

        byte[] data=new byte[1024];
        int len=input.read(data);
        System.out.println("内容为：\n"+new String(data,0,len));
    }
}
