/**
 * FileName: UserDaoImpl1
 * Author:   嘉平十七
 * Date:     2020/7/5 12:12
 * Description:
 * History:
 * notes：
 */
package cn.test.spring.dao_impl;

import cn.test.spring.dao.UserDao;

public class UserDaoImpl1 implements UserDao {
    @Override
    public void getUser() {
        System.out.println("1——获取");
    }
}