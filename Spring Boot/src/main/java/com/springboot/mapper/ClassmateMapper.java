/**
 * FileName: ClassmateMapper
 * Author:   嘉平十七
 * Date:     2020/7/23 8:09
 * Description: 映射类
 * notes：
 */
package com.springboot.mapper;

import com.springboot.domain.Classmate;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

//继承了通用mapper就不需要注解了，通用mapper会搞定增删查改的方法
//@Mapper
public interface ClassmateMapper extends Mapper<Classmate> {
}
