package com.tu.redisDemo.mvctest.server.impl;

import com.tu.redisDemo.mvctest.dao.ClassDao;
import com.tu.redisDemo.mvctest.dao.UserDao;
import com.tu.redisDemo.mvctest.dao.entity.UserTab;
import com.tu.redisDemo.mvctest.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserInfo操作Service,增加User增删改查方法
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;
    @Autowired
    public ClassDao classDao;
    @Autowired
    public RedisToolService redisToolService;
    
    public int doIncrUserInfo(UserTab userTab) {

        return userDao.incrUserInfo(userTab);
    }

    
    public int doIncrUserInfoByList(List<UserTab> luser) {
        return 0;
    }

    
    public int doDecrUserInfo(Integer userID) {

        int num = userDao.delUserInfoById(userID);

        return num;
    }

    
    public int doDecrUserInfoByList(List<Integer> luserID) {
        return 0;
    }

    
    public int doUpdUserInfo(UserTab userTab) {

        int num = userDao.updUserInfoById(userTab);

        return num;
    }

    
    public int doUpdUserInfoByList(List<UserTab> luser) {
        return 0;
    }

    
    public UserTab doGetUserInfo(Integer userId) {

        UserTab userTab = userDao.getUserInfo(userId);
        userTab.setClassTab(classDao.getClassInfoById(userTab.getClassId()));
        userTab.setGender(redisToolService.getValue(String.valueOf(userTab.getUserId())));
        return userTab;
    }

    
    public List<UserTab> doGetUserInfoByList(List<UserTab> userTab) {



        List<UserTab> listUserTab = userDao.getUserInfoByList();

        for (UserTab tab : listUserTab) {
            tab.setClassTab(classDao.getClassInfoById(tab.getClassId()));
            tab.setGender(redisToolService.getValue(String.valueOf(tab.getUserId())));
        }

        return listUserTab;
    }
}
