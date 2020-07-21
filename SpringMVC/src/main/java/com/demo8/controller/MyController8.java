/**
 * FileName: MyController7
 * Author:   嘉平十七
 * Date:     2020/7/18 18:37
 * Description: 拦截器
 * notes：
 */
package com.demo8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class MyController8 {
    @RequestMapping("/doLogin.do")
    public ModelAndView doInterceptor(String name,int age){
        System.out.println("===执行MyController7中的doInterceptor()===");
        ModelAndView mv=new ModelAndView();
        mv.addObject("tname",name);
        mv.addObject("tage",age);
        mv.setViewName("show");
        return mv;
    }

    /**
     * 文件上传
     * MultipartFile upload，文件上传解析器对象解析request后，文件上传对象
     * 有问题，没解决
     * @param upload
     * @return
     */
    @RequestMapping("/fileupload.do")
    public String doupload(MultipartFile upload, HttpServletRequest request) throws IOException {
        //文件上传的位置
//        String realPath = request.getSession().getServletContext().getRealPath("/uploads");
        String realPath = "e:"+File.separator+"uploads";
        //创建文件夹
        File file=new File(realPath);
        //判断是否存在，创建文件夹
        if (!file.exists()){
            file.mkdirs();
        }

        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        System.out.println("文件名称："+filename);
        //上传文件
        upload.transferTo(new File(file,filename));
        return "suc";
    }
}