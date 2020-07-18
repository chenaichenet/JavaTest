/**
 * FileName: MyController6
 * Author:   嘉平十七
 * Date:     2020/7/18 17:25
 * Description: 异常处理
 * notes：
 */
package com.demo6.controller;

import com.demo6.exception.AgeException;
import com.demo6.exception.MyException;
import com.demo6.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController6 {
    @RequestMapping("/doException.do")
    public ModelAndView doException(String name,Integer age) throws MyException {
        ModelAndView mv=new ModelAndView();
        //根据请求参数抛出异常
        //原始方法，要使用try-catch包含两个if，把异常交由自己处理，但是现在，我们要把异常抛出给框架，让框架集中处理
        if (!"test".equals(name)){
            throw new NameException("姓名不正确");
        }
        if (age==null || age>100){
            throw new AgeException("年龄不正确");
        }
        //异常抛出之后，程序的流程就不会再到下面的代码，而是到GolbaleExceptionHandler类中
        mv.addObject("tname",name);
        mv.addObject("tage",age);
        mv.setViewName("show");
        return mv;
    }
}