package com.tu.redisDemo.rabbitmqtest.service;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = "infoMsgQueue")
public class DirectReceiver1 {

    //设置主题模式，例如：type = "fanout"
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "infoMsgQueue", durable = "true"),
            exchange = @Exchange(name = "directExchange", durable = "true", type = "fanout")))
    @RabbitHandler
    public void process(String message) {
        System.out.println("消费者自动获取： DirectReceiver1 Receive InfoMsg:" + message);
    }

}
