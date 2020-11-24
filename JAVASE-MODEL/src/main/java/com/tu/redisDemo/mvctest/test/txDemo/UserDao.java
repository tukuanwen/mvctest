package com.tu.redisDemo.mvctest.test.txDemo;

/**
 * 声明两个方法，一个加，一个减。但需要保持他们操作一致成功或一致失败
 */
public interface UserDao {

    public void incr();

    public void decr();

}
