/**
 * FileName: MyTagDemo1
 * Author:   嘉平十七
 * Date:     2020/7/1 15:28
 * Description: 自定义标签
 * History:
 * notes：
 */
package com.jsp_demo.tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

public class MyTagDemo1 implements SimpleTag {
    private PageContext pageContext;
    private JspFragment jspFragment;

    /*所有set方法都会在doTag()方法之前被Tomcat调用
    * 所有在doTag()中就可以使用Tomcat传递过来的对象*/
    @Override
    public void doTag() throws JspException, IOException {
        pageContext.getOut().print("实现SimpleTag");
    }

    @Override
    public void setParent(JspTag jspTag) {

    }

    @Override
    public JspTag getParent() {
        return null;
    }

    @Override
    public void setJspContext(JspContext jspContext) {
        //服务器调用，接收
        this.pageContext= (PageContext) jspContext;
    }

    @Override
    public void setJspBody(JspFragment jspFragment) {
        this.jspFragment=jspFragment;
    }
}