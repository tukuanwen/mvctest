package com.tu.redisDemo.mvctest.test;

public enum  SingletonEnum {

    HAHA,SINGLETON_ENUM;

    private Singleton SOBJ6 = null;

    private SingletonEnum(){
        SOBJ6 = new Singleton();
    }

    public Singleton getSing6(){
        return SOBJ6;
    }

}
