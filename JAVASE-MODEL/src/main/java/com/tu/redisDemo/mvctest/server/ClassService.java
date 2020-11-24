package com.tu.redisDemo.mvctest.server;

import com.tu.redisDemo.mvctest.dao.entity.ClassTab;

import java.util.List;

public interface ClassService {

    public List<ClassTab> getClassInfoByList();
}
