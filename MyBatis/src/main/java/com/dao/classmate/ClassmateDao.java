/**
 * FileName: ClassmateDao
 * Author:   嘉平十七
 * Date:     2020/7/10 17:56
 * Description: 数据库main
 * notes：
 */
package com.dao.classmate;

import com.domain.Classmate;

import java.util.List;

public interface ClassmateDao {
    public List<Classmate> selectClassmates();

    public List<Classmate> selectLike(String name);
    public List<Classmate> selectLike2(String name);

    public List<Classmate> selectIf(Classmate classmate);
    public List<Classmate> selectWhere(Classmate classmate);
    public List<Classmate> selectForeach(List<Integer> idlist);
    public List<Classmate> selectForeach2(List<Classmate> clslist);
    public List<Classmate> selectsql(List<Classmate> clslist);
}