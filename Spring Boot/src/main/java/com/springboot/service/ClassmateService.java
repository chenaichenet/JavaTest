/**
 * FileName: ClassmateService
 * Author:   嘉平十七
 * Date:     2020/7/23 8:22
 * Description:
 * notes：
 */
package com.springboot.service;

import com.springboot.domain.Classmate;
import com.springboot.mapper.ClassmateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 这个类对应 SpringMVC 中的mytest包中的 serviceImpl，service，dao，dao.xml（映射文件使用通用mapper解决）
 * 使用通用mapper，会会自动创建sql语句，所以该类中可以直接使用mapper类自动赋值，然后使用继承Mapper<Classmate>的自动方法
 * 方法挺简单的，selectByPrimaryKey类似这种都是通过主键，所以在classmate实体类中，需要使用 @Id 来标注主键
 */
@Service
public class ClassmateService {
    @Autowired
    private ClassmateMapper classmateMapper;

    public List<Classmate> queryAll(){
        return classmateMapper.selectAll();
    }
    public Classmate queryWhere(Integer id){
        return classmateMapper.selectByPrimaryKey(id);
    }
    public int insertClassmte(Classmate classmate){
        return classmateMapper.insert(classmate);
    }
    public int updataClassmate(Classmate classmate){
        return classmateMapper.updateByPrimaryKeySelective(classmate);
    }
    public int deleteClassmate(Integer id){
        return classmateMapper.deleteByPrimaryKey(id);
    }
}