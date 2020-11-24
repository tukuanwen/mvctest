package com.tu.redisDemo.rabbitmqtest.service;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = "warnMsgQueue")
public class DirectReceiver2 {

    //设置主题模式，例如：type = "fanout"
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = "infoMsgQueue", durable = "true"),
//            exchange = @Exchange(name = "directExchange", durable = "true", type = "fanout")))
    @RabbitHandler
    public void process(String message) {
        System.out.println("消费者2 DirectReceiver2 Receive warnMsg:" + message);
    }

}
