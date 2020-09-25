package com.tu.mvctest.dao;

import com.tu.mvctest.dao.entity.ClassTab;

import java.util.List;

public interface ClassDao {

    public List<ClassTab> getClassInfoByList();

    public ClassTab getClassInfoById(Integer classId);
}
