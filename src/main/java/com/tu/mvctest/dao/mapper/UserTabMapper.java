package com.tu.mvctest.dao.mapper;

import com.tu.mvctest.dao.entity.UserTab;
import com.tu.mvctest.dao.entity.UserTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTabMapper {
    long countByExample(UserTabExample example);

    int deleteByExample(UserTabExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserTab record);

    int insertSelective(UserTab record);

    List<UserTab> selectByExample(UserTabExample example);

    UserTab selectByPrimaryKey(Integer userId);

    /**
     * 手动新增查询带class信息的user
     * @param example
     * @return
     */
    List<UserTab> selectByExampleWithClass(UserTabExample example);

    UserTab selectByPrimaryKeyWithClass(Integer userId);

    int updateByExampleSelective(@Param("record") UserTab record, @Param("example") UserTabExample example);

    int updateByExample(@Param("record") UserTab record, @Param("example") UserTabExample example);

    int updateByPrimaryKeySelective(UserTab record);

    int updateByPrimaryKey(UserTab record);
}