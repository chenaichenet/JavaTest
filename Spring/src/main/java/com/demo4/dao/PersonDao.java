/**
 * FileName: PersonDao
 * Author:   嘉平十七
 * Date:     2020/7/10 8:31
 * Description:
 * notes：
 */
package com.demo4.dao;

import com.demo4.domain.Person;

import java.util.List;

public interface PersonDao {
    int insertPerson(Person person);
    List<Person> selectPerson();
}
