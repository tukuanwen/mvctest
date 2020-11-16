package com.tu.dubboDemo.services.impl;

import com.tu.dubboDemo.services.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class DemoServiceImpl {

    @Reference
    public DemoService demoService;

    public String sayHello(String sayStr){
        return demoService.sayHello(sayStr);
    }

}
