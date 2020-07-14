/**
 * FileName: ClassmateDao
 * Author:   嘉平十七
 * Date:     2020/7/12 20:16
 * Description: 接口
 * notes：
 */
package com.demo4.dao;

import com.demo4.domain.Classmate;

import java.util.List;

public interface ClassmateDao {
    public List<Classmate> selectAll();
    public List<Classmate> selectWhere(Classmate classmate);
    public int insertClassmate(Classmate classmate);
}