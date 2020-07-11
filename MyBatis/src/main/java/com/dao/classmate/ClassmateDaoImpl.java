/**
 * FileName: ClassmateDaoImpl
 * Author:   嘉平十七
 * Date:     2020/7/11 15:30
 * Description: 接口实现类
 * notes：
 */
package com.dao.classmate;

import com.domain.Classmate;
import com.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ClassmateDaoImpl implements ClassmateDao{
    @Override
    public List<Classmate> selectClassmates() {
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        String sqlId="com.dao.classmate.ClassmateDao.selectClassmates";
        List<Classmate> studentList=sqlSession.selectList(sqlId);
        sqlSession.commit();
        sqlSession.close();
        return studentList;
    }
}