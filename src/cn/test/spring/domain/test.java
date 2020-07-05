/**
 * FileName: test
 * Author:   嘉平十七
 * Date:     2020/7/5 12:17
 * Description:
 * History:
 * notes：
 */
package cn.test.spring.domain;

import cn.test.spring.dao_impl.UserDaoImpl1;
import cn.test.spring.dao_impl.UserDaoImpl2;
import cn.test.spring.service_impl.UserServiceImpl1;

public class test {
    public static void main(String[] args) {
        UserServiceImpl1 userServiceImpl1=new UserServiceImpl1();
        userServiceImpl1.setUserDao(new UserDaoImpl1());
        userServiceImpl1.getUser();
        userServiceImpl1.setUserDao(new UserDaoImpl2());
        userServiceImpl1.getUser();
    }
}