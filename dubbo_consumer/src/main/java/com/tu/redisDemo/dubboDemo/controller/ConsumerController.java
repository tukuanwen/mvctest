package com.tu.redisDemo.dubboDemo.controller;

import com.tu.redisDemo.dubboDemo.services.DemoService;
import com.tu.redisDemo.dubboDemo.services.impl.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:consumer.xml"});
        context.start();
        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法
        System.out.println( hello ); // 显示调用结果

    }
    @Autowired
    public DemoServiceImpl demoServiceImpl;
    @RequestMapping("/consumer/sayHello")
    public ResponseEntity<String> doSayHello(){

        String contentstr = demoServiceImpl.sayHello("沈冲");
        contentstr = "{contenst:"+contentstr+"}";
        ResponseEntity<String> resStr = new ResponseEntity<String>(contentstr, HttpStatus.OK);

        return resStr;
    }


}
