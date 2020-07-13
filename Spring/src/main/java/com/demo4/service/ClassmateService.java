/**
 * FileName: ClassmateService
 * Author:   嘉平十七
 * Date:     2020/7/13 8:35
 * Description:
 * notes：
 */
package com.demo4.service;

import com.demo4.domain.Classmate;

import java.util.List;

public interface ClassmateService {
    List<Classmate> squeryAll();
    List<Classmate> squeryWhere(Classmate classmate);
}
