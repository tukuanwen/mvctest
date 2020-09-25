package com.tu.mvctest.dao.mapper;

import com.tu.mvctest.dao.entity.ClassTab;
import com.tu.mvctest.dao.entity.ClassTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassTabMapper {
    long countByExample(ClassTabExample example);

    int deleteByExample(ClassTabExample example);

    int deleteByPrimaryKey(Integer classId);

    int insert(ClassTab record);

    int insertSelective(ClassTab record);

    List<ClassTab> selectByExample(ClassTabExample example);

    ClassTab selectByPrimaryKey(Integer classId);

    int updateByExampleSelective(@Param("record") ClassTab record, @Param("example") ClassTabExample example);

    int updateByExample(@Param("record") ClassTab record, @Param("example") ClassTabExample example);

    int updateByPrimaryKeySelective(ClassTab record);

    int updateByPrimaryKey(ClassTab record);
}