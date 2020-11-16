package com.tu.rabbitmqtest.service;

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

    public void sendInfo(){

        String content = "I am Info msg!";


        // 将消息以info-msg绑定键发送到directExchange交换机
        rabbitTemplate.convertAndSend("directExchange", "info-msg", content);

        System.out.println("####################### sendinfomsg:"+content);
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
