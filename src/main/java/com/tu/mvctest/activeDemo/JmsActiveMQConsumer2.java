package com.tu.mvctest.activeDemo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsActiveMQConsumer2 {

    public static final String MY_BROKER_BIND_URL = "tcp://192.168.36.128:61616";

    public static void main(String[] args) throws JMSException, IOException {

//        doConsumerLinsen("2号");
        System.out.println("---------------------------------");
        doTopicConsumerLinsen("2号");

    }


    //主题消费者
    public static void doTopicConsumerLinsen(String num) throws JMSException, IOException {

        System.out.println("*****************消息主题："+num);
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(MY_BROKER_BIND_URL);

        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic("topicName01");

        MessageConsumer consumer = session.createConsumer(topic);

        consumer.setMessageListener(new MessageListener(){

            @Override
            public void onMessage(Message message) {

                if (null != message && message instanceof TextMessage){

                    TextMessage message1 = (TextMessage)message;
                    try {
                        String text = message1.getText();
                        System.out.println("主题消息为："+text);
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }

                }
            }
        });


    }


    public static void doConsumerLinsen(String num) throws JMSException, IOException {
        System.out.println("********消费者"+num);
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(MY_BROKER_BIND_URL);

        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("queue01");

        MessageConsumer consumer = session.createConsumer(queue);
        //创建监听，读取message信息
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                System.out.println("监听的信息"+message);
                if(null != message && message instanceof TextMessage){
                    TextMessage message1 = (TextMessage) message;

                    try {
                        System.out.println(message1.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }
}
