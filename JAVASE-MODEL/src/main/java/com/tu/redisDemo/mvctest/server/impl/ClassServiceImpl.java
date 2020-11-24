package com.tu.redisDemo.mvctest.server.impl;

import com.tu.redisDemo.mvctest.dao.ClassDao;
import com.tu.redisDemo.mvctest.dao.entity.ClassTab;
import com.tu.redisDemo.mvctest.server.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    public ClassDao classDao;

    @Override
    public List<ClassTab> getClassInfoByList() {

      List<ClassTab> classTabList = classDao.getClassInfoByList();
      return classTabList;
    }
}
