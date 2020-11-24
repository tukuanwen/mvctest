package com.tu.redisDemo.mvctest.test.aopAnno;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面增强类
 */
@Component
@Aspect
public class UserInfoProxy {

    /**
     * 把多次出现切入点可以提取为公用的，标签为@Pointcut,后续的通知类型只需要引入该切入点方法名即可
     */
    @Pointcut(value = "execution(* com.tu.redisDemo.mvctest.test.aopAnno.UserInfo.add(..))")
    public void pointDemo(){

    }

    //设置通知类型，并引入被通知的方法
    @Before(value="execution(* com.tu.redisDemo.mvctest.test.aopAnno.UserInfo.add(..))")
    public void before(){
        System.out.println("我是增强类的前置方法");
    }

    @After(value = "pointDemo()")
    public void after(){

        System.out.println("最终执行的发放");
    }
}
