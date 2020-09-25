package com.tu.mvctest.activeDemo;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {

        if(null != null && message instanceof TextMessage)
        {
            TextMessage textMessage = (TextMessage)message;
            try {
                System.out.println("监听到的消息为："+textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
