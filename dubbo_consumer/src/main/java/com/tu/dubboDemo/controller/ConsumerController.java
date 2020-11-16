package com.tu.dubboDemo.controller;

import com.tu.dubboDemo.services.DemoService;
import com.tu.dubboDemo.services.impl.DemoServiceImpl;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
    public String doSayHello(){

//        demoServiceImpl.sayHello("沈冲");

        return demoServiceImpl.sayHello("沈冲");
    }


}
