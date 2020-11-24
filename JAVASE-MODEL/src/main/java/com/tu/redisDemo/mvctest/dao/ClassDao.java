package com.tu.redisDemo.mvctest.dao;

import com.tu.redisDemo.mvctest.dao.entity.ClassTab;

import java.util.List;

public interface ClassDao {

    public List<ClassTab> getClassInfoByList();

    public ClassTab getClassInfoById(Integer classId);
}
