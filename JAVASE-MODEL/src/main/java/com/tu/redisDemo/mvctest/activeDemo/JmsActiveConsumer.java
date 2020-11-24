package com.tu.redisDemo.mvctest.activeDemo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;
import java.util.Map;

public class JmsActiveConsumer {

    public static final String MY_BROKER_BIND_URL = "tcp://192.168.36.128:61616";

    public static void main(String[] args) throws JMSException, IOException {
//        doConsumerLinsen("1号");
        System.out.println("---------------------------------");
//        doTopicConsumerLinsen("1号");
        doSubscribersConsumerLinsen("1号");
    }

    //主题订阅者
    public static void doSubscribersConsumerLinsen(String num) throws JMSException, IOException {

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(MY_BROKER_BIND_URL);

        Connection connection = activeMQConnectionFactory.createConnection();
        //设置订阅者
        connection.setClientID("tkw");

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic tkwtopic = session.createTopic("tkwtopic");
        //创建订阅者
        TopicSubscriber durableSubscriber = session.createDurableSubscriber(tkwtopic, "reamk....");
        connection.start();
        durableSubscriber.setMessageListener((message)->{

            if(null != message && message instanceof TextMessage){
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("订阅者获取的消息："+textMessage.getText());
                    //签收
                    textMessage.acknowledge();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();
        durableSubscriber.close();
        session.close();
        connection.close();
    }
    //主题消费者
    public static void doTopicConsumerLinsen(String num) throws JMSException, IOException {

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
    //队列消费者
    public static void doConsumerLinsen(String num) throws JMSException, IOException {
        System.out.println("********消费者"+num);
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(MY_BROKER_BIND_URL);

        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("queue01");

        MessageConsumer consumer = session.createConsumer(queue);
        //创建监听，读取message信息
        consumer.setMessageListener((message)->{
            System.out.println("监听的信息"+message);
            if(null != message && message instanceof TextMessage){
                TextMessage message1 = (TextMessage) message;
                try {
                    System.out.println(message1.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }else if(null != message && message instanceof MapMessage){
                MapMessage mapMessage = (MapMessage) message;
                try {
                    String k1 = mapMessage.getString("k1");
                    System.out.println("Map消息内容为："+k1);
                } catch (JMSException e) {
                    e.printStackTrace();
                }

            }
        });

        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }

    //普通的消费者方法
    public static void doConsumer01() throws JMSException {
        //创建Active连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(MY_BROKER_BIND_URL);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //启动连接
        connection.start();
        //创建session  两个参数：1、是否支持事务  2、消息签收模式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //消息目的地
        Queue queue01 = session.createQueue("queue01");

        //消息接受者
        MessageConsumer consumer = session.createConsumer(queue01);

        while (true){
            //获取消息
            TextMessage textMessage = (TextMessage)consumer.receive(40L);//可以设置消费超时时间
            if(null != textMessage){
                System.out.println(textMessage.getText());
            }else{
                break;
            }
        }
        consumer.close();
        session.close();
        connection.close();
        System.out.println("消费结束");
    }

}
