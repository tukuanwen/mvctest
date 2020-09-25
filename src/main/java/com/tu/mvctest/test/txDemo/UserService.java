package com.tu.mvctest.test.txDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Transactional 如果添加在类上，则表示该类所有方法都有事务了;如果添加在方法上，则只对该方法起事务作用
 */

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    //进行操作
    public void doBankTest(){

        //先加
        userDao.incr();

        //后减
        userDao.decr();

    }

}
