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

import java.util.List;

public class ClassmateServiceImpl implements ClassmateService {
    private ClassmateDao classmateDao;

    public void setClassmateDao(ClassmateDao classmateDao) {
        this.classmateDao = classmateDao;
    }

    @Override
    public List<Classmate> squeryAll() {
        List<Classmate> classmateList=classmateDao.selectAll();
        return classmateList;
    }

    @Override
    public List<Classmate> squeryWhere() {
        List<Classmate> classmateList = classmateDao.selectWhere();
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
    public int delete(Classmate classmate) {
        int num = classmateDao.deleteClassmate(classmate);
        return num;
    }
}