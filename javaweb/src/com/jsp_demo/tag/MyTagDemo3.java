/**
 * FileName: MyTagDemo3
 * Author:   嘉平十七
 * Date:     2020/7/1 16:46
 * Description:
 * History:
 * notes：
 */
package com.jsp_demo.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.Writer;

public class MyTagDemo3 extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        //获取当前JSP页面的输出流
        Writer out=this.getJspContext().getOut();

        out.write("----------<br/>");

        //执行标签体内容，把结果写到指定的流中，即页面
        this.getJspBody().invoke(out);

        out.write("----------<br/>");
        //JSP下面的语句不会在执行
        throw new SkipPageException();
    }
}