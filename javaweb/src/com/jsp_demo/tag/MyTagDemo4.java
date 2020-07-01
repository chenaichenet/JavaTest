/**
 * FileName: MyTagDemo4
 * Author:   嘉平十七
 * Date:     2020/7/1 17:03
 * Description: 标签属性
 * History:
 * notes：
 */
package com.jsp_demo.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MyTagDemo4 extends SimpleTagSupport {
    private boolean test;

    /*这个方法由Tomcat来调用，并且在doTag()之前*/
    public void setTest(boolean test){
        this.test=test;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (test){
            /*执行标签体*/
            //如果传递的输出流为null，表示下使用的就是当前页面的out
            this.getJspBody().invoke(null);
        }
    }
}