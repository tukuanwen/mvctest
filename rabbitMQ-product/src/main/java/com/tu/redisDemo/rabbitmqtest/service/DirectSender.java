package com.tu.redisDemo.rabbitmqtest.service;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 正常的消息发送
     */
    public void sendInfo(){

        String content = "I am Info msg!";

        // 将消息以info-msg绑定键发送到directExchange交换机
        rabbitTemplate.convertAndSend("directExchange", "info-msg", content);

        System.out.println("生产者发送消息 sendinfomsg:"+content);
    }

    /**
     * 交换机不存在
     */
    public void notExchangeSendInfo(){

        String content = "交换机不存在~~~~";

        rabbitTemplate.convertAndSend("notDirectExchange", "info-msg",content);

    }

    /**
     * 队列key不存在
     */
    public void notContentSendInfo(){

        String content = "队列key不存在";

        rabbitTemplate.convertAndSend("directExchange","notInfo-msg",content);

    }


    public void sendWarn(){

        String content = "I am Warn msg";

        rabbitTemplate.convertAndSend("directExchange", "warn-msg", content);

        System.out.println("####################### sendwarnmsg:"+content);
    }

    public void sendWarn(int i) {

        String content = "I am Warn msg! " + i;

        this.rabbitTemplate.convertAndSend("directExchange", "warn-msg", content);

        System.out.println("########### SendWarnMsg : " + content);
    }

    public void sendError() {

        String content = "I am Error msg!";

        this.rabbitTemplate.convertAndSend("directExchange", "error-msg", content);

        System.out.println("########### SendErrorMsg : " + content);
    }

}
