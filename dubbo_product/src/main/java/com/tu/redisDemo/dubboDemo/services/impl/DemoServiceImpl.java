package com.tu.redisDemo.dubboDemo.services.impl;

import com.tu.redisDemo.dubboDemo.services.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


@Component("demoServiceImpl")
@Service
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello dubbo" + name;
    }
}
