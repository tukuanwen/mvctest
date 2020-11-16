package com.tu.api.services.impl;

import com.tu.api.services.DubboServer;

public class DubboServerImpl implements DubboServer {
    @Override
    public String sayHello(String content) {

        return "Hello dubbo : " + content;
    }
}
