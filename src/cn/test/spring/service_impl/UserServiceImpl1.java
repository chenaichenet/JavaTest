/**
 * FileName: UserServiceImpl1
 * Author:   嘉平十七
 * Date:     2020/7/5 12:16
 * Description:
 * History:
 * notes：
 */
package cn.test.spring.service_impl;

import cn.test.spring.dao.UserDao;
import cn.test.spring.dao_impl.UserDaoImpl1;
import cn.test.spring.service.UserService;

public class UserServiceImpl1 implements UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }
    @Override
    public void getUser() {
        userDao.getUser();
    }
}