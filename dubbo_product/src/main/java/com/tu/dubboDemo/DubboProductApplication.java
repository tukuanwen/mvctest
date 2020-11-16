package com.tu.dubboDemo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@EnableDubbo
public class DubboProductApplication {

    public static void main(String[] args) {

        SpringApplication.run(DubboProductApplication.class, args);
    }

}
