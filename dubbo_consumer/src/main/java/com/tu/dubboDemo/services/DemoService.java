package com.tu.dubboDemo.services;


import org.springframework.stereotype.Component;

//@Service
@Component
public interface DemoService {

    public String sayHello(String name);
}
