/**
 * FileName: ClassmateDao
 * Author:   嘉平十七
 * Date:     2020/7/16 7:10
 * Description: 接口
 * notes：
 */
package com.mytest.dao;

import com.mytest.domain.Classmate;

import java.util.List;

public interface ClassmateDao {
    public List<Classmate> selectAll();
    public List<Classmate> selectWhere(int id);
    public int insertClassmate(Classmate classmate);
    public int updateClassmate(Classmate classmate);
    public int deleteClassmate(int id);

}
