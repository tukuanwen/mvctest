package com.tu.rabbitmqtest.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "warnMsgQueue")
public class DirectReceiver2 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("########### DirectReceiver2 Receive warnMsg:" + message);
    }

}
