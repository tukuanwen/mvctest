package com.tu.redisDemo.api.services.impl;

import com.tu.redisDemo.api.services.DubboServer;

public class DubboServerImpl implements DubboServer {
    @Override
    public String sayHello(String content) {

        return "Hello dubbo : " + content;
    }
}
