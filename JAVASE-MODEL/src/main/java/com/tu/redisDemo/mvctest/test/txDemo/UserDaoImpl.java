package com.tu.redisDemo.mvctest.test.txDemo;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void incr() {
        System.out.println("模拟加法");
    }

    @Override
    public void decr() {
        System.out.println("模拟减法");
    }
}
