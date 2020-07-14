/**
 * FileName: ClassmateServiceImpl
 * Author:   嘉平十七
 * Date:     2020/7/14 8:05
 * Description:
 * notes：
 */
package com.demo4.service.impl;

import com.demo4.dao.ClassmateDao;
import com.demo4.domain.Classmate;
import com.demo4.service.ClassmateService;

import java.util.List;

public class ClassmateServiceImpl implements ClassmateService {
    //引用类型
    private ClassmateDao classmateDao;

    public void setClassmateDao(ClassmateDao classmateDao) {
        this.classmateDao = classmateDao;
    }

    @Override
    public List<Classmate> squeryAll() {
        List<Classmate> classmateList = classmateDao.selectAll();
        return classmateList;
    }

    @Override
    public List<Classmate> squeryWhere(Classmate classmate) {
        List<Classmate> classmateList=classmateDao.selectWhere(classmate);
        return classmateList;
    }

    @Override
    public int insert(Classmate classmate) {
        int num = classmateDao.insertClassmate(classmate);
        return num;
    }
}