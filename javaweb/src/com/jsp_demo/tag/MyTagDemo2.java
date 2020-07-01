/**
 * FileName: MyTagDemo2
 * Author:   嘉平十七
 * Date:     2020/7/1 16:31
 * Description:
 * History:
 * notes：
 */
package com.jsp_demo.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MyTagDemo2 extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        this.getJspContext().getOut().print("继承SimpleTagSupport");
    }
}