package com.tu.redisDemo.mvctest.dao;

import com.tu.redisDemo.mvctest.dao.entity.UserTab;

import java.util.List;

public interface UserDao {

    public UserTab getUserInfo(int userId);

    public List<UserTab> getUserInfoByList();

    public int delUserInfoById(Integer userID);

    public int updUserInfoById(UserTab userTab);

    public int incrUserInfo(UserTab userTab);
}
