package com.tu.mvctest.activeDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Service
public class JmsSpringActiveProduct {

    @Autowired
    @Qualifier("jmsTemplate-topic")
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/activeApplicationContext.xml");
        JmsSpringActiveProduct jmsSpringActiveProduct = (JmsSpringActiveProduct) applicationContext.getBean("jmsSpringActiveProduct");

        jmsSpringActiveProduct.jmsTemplate.send((session)->{

            TextMessage textMessage = session.createTextMessage("通过spring集成jms发送见监听消息");

            return textMessage;
        });
        System.out.println("spring-active消息发送完成");
    }

}
