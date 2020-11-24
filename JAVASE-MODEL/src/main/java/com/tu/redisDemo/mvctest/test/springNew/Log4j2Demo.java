package com.tu.redisDemo.mvctest.test.springNew;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2Demo {

    //日志打印
    public static final Logger logger = LoggerFactory.getLogger(Log4j2Demo.class);

    public static void main(String[] args) {

        System.out.println("验证打印日志");

        logger.info("日志打印了");

    }


    public String doNullable(){


        return null;
    }

}
