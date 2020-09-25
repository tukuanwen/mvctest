package com.tu.springbootjms.activemqDemo;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@Configuration
@EnableJms
public class MyQueue {

    @Value("${myQueueName}")
    public String queueName = "myqueue01";

    @Bean
    public Queue getQueue(){

        return new ActiveMQQueue(queueName);
    }

}
