/**
 * FileName: MyController
 * Author:   嘉平十七
 * Date:     2020/7/23 10:55
 * Description: classmate的controller类
 * notes：
 */
package com.springboot.controller;

import com.springboot.domain.Classmate;
import com.springboot.service.ClassmateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * todo-chenet
 * 这里就很明显了，虽然可以更简化，采用的方式还是模仿的SSM。
 * 后期会更新
 */
@Controller
public class MyController {
    @Autowired
    private ClassmateService service;
    ModelAndView modelAndView=new ModelAndView();

    @RequestMapping("/ClassmateTest")
    public String home(){
        return "classmate";
    }
    //这种方法也可以
//    @RequestMapping("/ClassmateTest")
//    public ModelAndView home(){
//        modelAndView.setViewName("classmate");
//        return modelAndView;
//    }

    @RequestMapping("/selectAll")
    public ModelAndView selectAll(){
        List<Classmate> classmateList = service.queryAll();
        modelAndView.addObject("classmateList",classmateList);
        modelAndView.addObject("msg","查询成功");
        modelAndView.setViewName("results");
        return modelAndView;
    }
    @RequestMapping("selectWhere")
    public ModelAndView selectWhere(Integer id){
        Classmate classmate = service.queryWhere(id);
        System.out.println(classmate);
        modelAndView.addObject("classmateList",classmate);
        modelAndView.addObject("msg","查询成功");
        modelAndView.setViewName("results");
        return modelAndView;
    }
    @RequestMapping("insert")
    public ModelAndView insert(Classmate classmate){
        int num = service.insertClassmte(classmate);
        selectAll();
        modelAndView.addObject("msg","影响"+num+"行数据");
        modelAndView.setViewName("results");
        return modelAndView;
    }
    @RequestMapping("update")
    public ModelAndView update(Classmate classmate){
        int num = service.updataClassmate(classmate);
        selectAll();
        modelAndView.addObject("msg","影响"+num+"行数据");
        modelAndView.setViewName("results");
        return modelAndView;
    }
    @RequestMapping("delete")
    public ModelAndView delete(Integer id){
        int num = service.deleteClassmate(id);
        selectAll();
        modelAndView.addObject("msg","影响"+num+"行数据");
        modelAndView.setViewName("results");
        return modelAndView;
    }
}