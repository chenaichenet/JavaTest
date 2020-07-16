/**
 * FileName: ClassmateService
 * Author:   嘉平十七
 * Date:     2020/7/16 7:17
 * Description: 接口
 * notes：
 */
package com.mytest.service;


import com.mytest.domain.Classmate;

import java.util.List;

public interface ClassmateService {
    List<Classmate> squeryAll();
    List<Classmate> squeryWhere(int id);
    int insert(Classmate classmate);
    int update(int id);
    int delete(int id);
}
