/**
 * FileName: ClassmateService
 * Author:   嘉平十七
 * Date:     2020/7/22 18:43
 * Description:
 * notes：
 */
package com.springboot.service;

import com.springboot.domain.Classmate;
import org.springframework.stereotype.Service;

@Service
public class ClassmateService {
    //根据id查询
    public Classmate queryById(int id){
        return new Classmate();
    }
}