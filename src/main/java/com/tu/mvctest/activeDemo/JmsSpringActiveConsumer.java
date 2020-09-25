package com.tu.mvctest.activeDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Service
public class JmsSpringActiveConsumer {

    @Autowired
    @Qualifier("jmsTemplate-topic")
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) throws JMSException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/activeApplicationContext.xml");

        JmsSpringActiveConsumer jmsSpringActiveConsumer = (JmsSpringActiveConsumer) ctx.getBean("jmsSpringActiveConsumer");

        String receive = (String) jmsSpringActiveConsumer.jmsTemplate.receiveAndConvert();

        System.out.println("消费者消息："+receive);
    }

}
