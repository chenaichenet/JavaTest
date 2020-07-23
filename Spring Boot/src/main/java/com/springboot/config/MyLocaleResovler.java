/**
 * FileName: MyLocaleResovler
 * Author:   嘉平十七
 * Date:     2020/7/23 18:43
 * Description: 国际化——区域信息解析器
 * notes：
 */
package com.springboot.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResovler implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();    //默认的
        if (!StringUtils.isEmpty(l)){
            String[] split = l.split("_");//分割zh和CN
            locale=new Locale(split[0],split[1]);  //一个语言，一个国家
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}