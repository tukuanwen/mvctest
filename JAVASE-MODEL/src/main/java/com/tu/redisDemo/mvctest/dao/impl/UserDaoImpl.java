package com.tu.redisDemo.mvctest.dao.impl;

import com.tu.redisDemo.mvctest.dao.UserDao;
import com.tu.redisDemo.mvctest.dao.entity.UserTab;
import com.tu.redisDemo.mvctest.dao.entity.UserTabExample;
import com.tu.redisDemo.mvctest.dao.mapper.UserTabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserTabMapper userTabMapper;

    public UserTab getUserInfo(int userId) {

        return userTabMapper.selectByPrimaryKey(userId);

    }

    public List<UserTab> getUserInfoByList() {

        UserTabExample userTabExample = new UserTabExample();

        return userTabMapper.selectByExample(userTabExample);
    }

    @Override
    public int delUserInfoById(Integer userID) {

        int num = userTabMapper.deleteByPrimaryKey(userID);

        return num;
    }

    @Override
    public int updUserInfoById(UserTab userTab) {

        int num = userTabMapper.updateByPrimaryKey(userTab);

        return num;
    }

    @Override
    public int incrUserInfo(UserTab userTab) {
        return userTabMapper.insert(userTab);
    }
}
