/**
 * FileName: EncodingRequest
 * Author:   嘉平十七
 * Date:     2020/6/25 17:39
 * Description: request装饰类
 * History:
 * notes：
 */
package com.test.java;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

public class EncodingRequest extends HttpServletRequestWrapper {
    private HttpServletRequest req;
    public EncodingRequest(HttpServletRequest request) {
        super(request);
        this.req=request;
    }

/*  这个方法是实现HttpServletRequest类，覆盖的方法中的一个方法。
    而Java中提供了HttpServletRequestWrapper类，该类实现了HttpServletRequest。
    并把其中所有的request完成，我们只需要覆盖其中需要的方法即可。*/
    public String getParameter(String s) {
        String value=req.getParameter(s);

        //处理编码问题
        try {
            value=new String(value.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}