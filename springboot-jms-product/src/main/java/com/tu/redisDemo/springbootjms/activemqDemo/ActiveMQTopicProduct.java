package com.tu.redisDemo.springbootjms.activemqDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.jms.Topic;

@Service
public class ActiveMQTopicProduct {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Topic topic;

    //发送topic消息。启用定时任务发送
    @Scheduled(fixedDelay = 3000L)
    public void doSendTopicMessage(){

        jmsMessagingTemplate.convertAndSend(topic,"topic消息啦啦啦啦");

    }


}
