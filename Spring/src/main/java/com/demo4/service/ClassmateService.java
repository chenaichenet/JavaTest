/**
 * FileName: ClassmateService
 * Author:   嘉平十七
 * Date:     2020/7/14 8:04
 * Description:
 * notes：
 */
package com.demo4.service;

import com.demo4.domain.Classmate;

import java.util.List;

public interface ClassmateService {
    List<Classmate> squeryAll();
    List<Classmate> squeryWhere(Classmate classmate);
    public int insert(Classmate classmate);
}