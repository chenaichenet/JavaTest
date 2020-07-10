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
}