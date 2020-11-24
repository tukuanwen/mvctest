package com.tu.redisDemo.dubboDemo.services;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public interface DemoService {

    public String sayHello(String name);
}
