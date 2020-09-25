package com.tu.mvctest.server;

import com.tu.mvctest.dao.entity.UserTab;

import java.util.List;

public interface UserService {

    /**
     * 添加单个UserInfo
     * @param userTab
     * @return
     */
    public int doIncrUserInfo(UserTab userTab);

    /**
     * 批量添加UserInfo
     * @param luser
     * @return
     */
    public int doIncrUserInfoByList(List<UserTab> luser);

    /**
     * 删除单个UserInfo
     * @param userID
     * @return
     */
    public int doDecrUserInfo(Integer userID);

    /**
     * 批量删除UserInfo
     * @param luserID
     * @return
     */
    public int doDecrUserInfoByList(List<Integer> luserID);

    /**
     * 修改UserInfo信息
     * @param userTab
     * @return
     */
    public int doUpdUserInfo(UserTab userTab);

    /**
     * 批量修改UserInfo信息
     */
    public int doUpdUserInfoByList(List<UserTab> luser);

    /**
     * 查询单个UserInfo信息
     */
    public UserTab doGetUserInfo(Integer userId);

    /**
     * 批量查询UserInfo信息
     */
    public List<UserTab> doGetUserInfoByList(List<UserTab> userTab);

}
