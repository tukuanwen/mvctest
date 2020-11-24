package com.tu.redisDemo.rabbitmqtest.config;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendConfirmCallback implements RabbitTemplate.ConfirmCallback {


    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {

        if(ack){
            System.out.println("成功：消息成功发送到了消息队列交换机中，"+correlationData);
        }else{
            System.out.println("失败：消息发送到交换机中失败，"+correlationData);
        }
    }
}
