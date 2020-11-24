package com.tu.redisDemo.mvctest.dao.impl;

import com.tu.redisDemo.mvctest.dao.ClassDao;
import com.tu.redisDemo.mvctest.dao.entity.ClassTab;
import com.tu.redisDemo.mvctest.dao.mapper.ClassTabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassDaoImpl implements ClassDao {

    @Autowired
    public ClassTabMapper classTabMapper;


    @Override
    public List<ClassTab> getClassInfoByList() {
        return classTabMapper.selectByExample(null);
    }

    @Override
    public ClassTab getClassInfoById(Integer classId) {


        return classTabMapper.selectByPrimaryKey(classId);
    }
}
