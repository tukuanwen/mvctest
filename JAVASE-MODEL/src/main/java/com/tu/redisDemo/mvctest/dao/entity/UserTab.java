package com.tu.redisDemo.mvctest.dao.entity;

public class UserTab {
    private Integer userId;

    private String userName;

    private String userMail;

    private Integer classId;

    private ClassTab classTab;

    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail == null ? null : userMail.trim();
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public ClassTab getClassTab() {
        return classTab;
    }

    public void setClassTab(ClassTab classTab) {
        this.classTab = classTab;
    }
}