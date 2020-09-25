package com.tu.mvctest.activeDemo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsActiveProduct {

    public static final String MY_BROKER_BIND_URL = "nio://192.168.36.128:61616";

    public static void main(String[] args) throws JMSException, IOException {
        doQueueMsg();
//        doQueueMsg();
    }
    //消息主题
    public static void doTopicMsg() throws JMSException, IOException {

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(MY_BROKER_BIND_URL);

        Connection connection = activeMQConnectionFactory.createConnection();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //目的地-主题 //tkwtopic
        Topic topicName01 = session.createTopic("tkwtopic");

        MessageProducer producer = session.createProducer(topicName01);
        //持久化
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        connection.start();
        for (int i = 0; i < 10; i++) {

            //String消息类型
            TextMessage textMessage = session.createTextMessage("生产消息：" + i);

            producer.send(textMessage);
            //==============================================================================================

        }
        System.in.read();
        producer.close();
        session.close();
        connection.close();
        System.out.println("topic消息广播结束");

    }
    //消息队列
    public static void doQueueMsg() throws JMSException {
        //创建active连接工厂
        ActiveMQConnectionFactory amf = new ActiveMQConnectionFactory(MY_BROKER_BIND_URL);
        //新增连接
        Connection connection = amf.createConnection();

        //创建session 两个参数：1、是否设置事务  2、消息签收模式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地
        Queue queue01 = session.createQueue("queue01");

        //创建消息生成者
        MessageProducer producer = session.createProducer(queue01);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        //启动连接
        connection.start();

        for (int i = 0; i < 10; i++) {
            //消息模板
            TextMessage textMessage = session.createTextMessage("active的消息为："+i);
            //消息目的地
            textMessage.setJMSDestination(new Topic() {
//                @Override
                public String getTopicName() throws JMSException {
                    return "topic01";
                }
            });
            //消息的持久性
            textMessage.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
            //过期时间,0为永不过期
            textMessage.setJMSExpiration(2);
            //消息优先级，共10级，0~4普通级别，5~9高级级别，默认为4.优先级别不一定级数越大越优先，但高级别的会比低级别的优先
            textMessage.setJMSPriority(4);

            producer.send(textMessage);
            //==============================================================================
            //Map消息类型
            MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("k1","map消息类型："+i);
            producer.send(mapMessage);
        }
        //关闭所有连接通道
        producer.close();
        session.close();
        connection.close();
        System.out.println("消息发送成功222222222222");
    }


}
