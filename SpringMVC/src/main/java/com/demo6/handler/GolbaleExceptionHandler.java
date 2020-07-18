/**
 * FileName: GolbaleExceptionHandler
 * Author:   嘉平十七
 * Date:     2020/7/18 17:47
 * Description: 全局异常处理类
 * notes：
 */
package com.demo6.handler;

import com.demo6.exception.AgeException;
import com.demo6.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*@ControllerAdvice，控制器增强（也就是给控制器类增加功能——异常处理功能）
* 位置：类的上面
* 特点：必须让框架知道整个注解所在的包名，需要在springmvc配置文件中声明组件扫描器*/
@ControllerAdvice
public class GolbaleExceptionHandler {
    //定义方法，处理异常
    /*@ExceptionHandler，异常的class，表示异常的类型，当发生此类型异常时，由当前方法来处理*/

    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception exception){
        //处理NameException异常，形参Exception，表示Controller中抛出的异常对象，通过形参可以获取异常信息
        /*异常处理逻辑：
        * 1、需要把异常记录，记录到数据库，日志文件。记录异常发生的时间，发生的方法，异常的错误内容
        * 2、发生通知，把异常的信息通过通讯app发生给相关人员
        * 3、给用户提示*/
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg","姓名必须是test！");
        modelAndView.addObject("ex",exception);
        modelAndView.setViewName("error");
        return modelAndView;
    }
    @ExceptionHandler(value = {AgeException.class})
    public ModelAndView doAgeException(Exception exception){
        //处理NameException异常，形参Exception，表示Controller中抛出的异常对象，通过形参可以获取异常信息
        /*异常处理逻辑：
         * 1、需要把异常记录，记录到数据库，日志文件。记录异常发生的时间，发生的方法，异常的错误内容
         * 2、发生通知，把异常的信息通过通讯app发生给相关人员
         * 3、给用户提示*/
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg","年龄大于100！");
        modelAndView.addObject("ex",exception);
        modelAndView.setViewName("error");
        return modelAndView;
    }

    //处理其他异常，NameException，AgeException以外的异常，不知类型的异常
    //不加value，
    @ExceptionHandler
    public ModelAndView doOtherException(Exception exception){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg","其他异常");
        modelAndView.addObject("ex",exception);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}