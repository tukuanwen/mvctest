package com.tu.rabbitmqtest.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "infoMsgQueue")
public class DirectReceiver1 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("########### DirectReceiver1 Receive InfoMsg:" + message);
    }

}
