package com.tu.redisDemo.springbootjmstopicconsumer.activeMQTopicDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.jms.Topic;

@Service
public class ActiveMQTopicConsumer {

    @JmsListener(destination = "${myTopicName}")
    public void doConsumerTopic(TextMessage textMessage) throws JMSException {

        System.out.println("topic消息："+textMessage.getText());
        System.out.println("启动了监听");
    }

}
