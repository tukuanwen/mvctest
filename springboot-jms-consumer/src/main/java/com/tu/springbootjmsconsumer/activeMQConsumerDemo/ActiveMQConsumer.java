package com.tu.springbootjmsconsumer.activeMQConsumerDemo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Service
public class ActiveMQConsumer {


    //监听消费者
    @JmsListener(destination = "\"myqueue01\"")
    public void doListener(TextMessage textMessage) throws JMSException {

        System.out.println("消费消息"+textMessage.getText());


    }
}
