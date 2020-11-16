package com.tu.springbootjms.activemqDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
public class ActiveMQProduct {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;

    public void doSend(){

        jmsMessagingTemplate.convertAndSend(queue,"使用的时消息队列啦啦啦");

    }

    @Scheduled(cron = "0/3 * * * * ?")
//    @Schedules()
    public void doCrontab(){

        doSend();
        System.out.println("每隔3秒发送一次消息");
    }


}
