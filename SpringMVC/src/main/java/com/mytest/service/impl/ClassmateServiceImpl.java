/**
 * FileName: ClassmateServiceImpl
 * Author:   嘉平十七
 * Date:     2020/7/16 7:19
 * Description:
 * notes：
 */
package com.mytest.service.impl;


import com.mytest.dao.ClassmateDao;
import com.mytest.domain.Classmate;
import com.mytest.service.ClassmateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassmateServiceImpl implements ClassmateService {
    //引用类型自动注入
    @Autowired
    private ClassmateDao classmateDao;
//    这里采用了自动赋值，加上注解@Service和@Autowired，在spring.xml中去掉
//      <property name="classmateDao" ref="classmateDao"/>这一句即可
//    不需要再手动赋值
//    public void setClassmateDao(ClassmateDao classmateDao) {
//        System.out.println("========================引用类型========================");
//        this.classmateDao = classmateDao;
//    }

    @Override
    public List<Classmate> squeryAll() {
        List<Classmate> classmateList=classmateDao.selectAll();
        return classmateList;
    }

    @Override
    public List<Classmate> squeryWhere(int id) {
        List<Classmate> classmateList = classmateDao.selectWhere(id);
        return classmateList;
    }

    @Override
    public int insert(Classmate classmate) {
        int num = classmateDao.insertClassmate(classmate);
        return num;
    }

    @Override
    public int update(Classmate classmate) {
        int num = classmateDao.updateClassmate(classmate);
        return num;
    }

    @Override
    public int delete(int id) {
        int num = classmateDao.deleteClassmate(id);
        return num;
    }
}