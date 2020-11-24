package com.tu.redisDemo.rabbitmqtest.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class SendReturnCallback implements RabbitTemplate.ReturnCallback {
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {

        System.out.println("Fail... message:{"+message+"},从交换机exchange:{"+exchange+"},以路由键routingKey:{"+routingKey+"}," +
                "未找到匹配队列，replyCode:{"+replyCode+"},replyText:{"+replyText+"}");
    }
}
