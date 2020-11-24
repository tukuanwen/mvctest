package com.tu.redisDemo.springbootjms.activemqDemo;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Topic;

@Configuration
public class MyTopic {

    @Value("${myTopicName}")
    private String topicName;
    @Bean
    public Topic getTopic(){

        return new ActiveMQTopic(topicName);
    }
}
