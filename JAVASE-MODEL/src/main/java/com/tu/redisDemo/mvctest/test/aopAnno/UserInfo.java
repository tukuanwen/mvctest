package com.tu.redisDemo.mvctest.test.aopAnno;


import org.springframework.stereotype.Component;

/**
 * 需要使用切面增强的类
 */
@Component

public class UserInfo {

    public void add(){
        System.out.println("执行添加user方法");
    }

}
