package com.tu.redisDemo.dubboDemo.services.impl;

import com.tu.redisDemo.dubboDemo.services.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component("demoServiceImpl2")
@Service
public class DemoServiceImpl2 implements DemoService {
    @Override
    public String sayHello(String name) {
        return "sayHello2-----------"+name;

    }
}
