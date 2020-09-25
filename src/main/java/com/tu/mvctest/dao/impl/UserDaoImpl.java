package com.tu.mvctest.dao.impl;

import com.tu.mvctest.dao.UserDao;
import com.tu.mvctest.dao.entity.UserTab;
import com.tu.mvctest.dao.entity.UserTabExample;
import com.tu.mvctest.dao.mapper.UserTabMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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
