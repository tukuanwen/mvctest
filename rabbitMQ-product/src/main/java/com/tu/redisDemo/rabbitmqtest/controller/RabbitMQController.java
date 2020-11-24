package com.tu.redisDemo.rabbitmqtest.controller;

import com.tu.redisDemo.rabbitmqtest.service.DirectSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

    @Autowired
    public DirectSender directSender;

    @RequestMapping("/doSendInfo")
    public String doSendInfo(){

        directSender.sendInfo();

        return "消息发送成功！";
    }

    @RequestMapping("/doSendInfo1")
    public String doSendInfo1(){

        directSender.notExchangeSendInfo();

        return "交换机队列不存在！";
    }

    @RequestMapping("/doSendInfo2")
    public String doSendInfo2(){

        directSender.notContentSendInfo();

        return "队列key不存在";
    }

    @RequestMapping("/doSendWarn")
    public String doSendWarn(){

        directSender.sendWarn();

        return "警告发送成功！";
    }
    @RequestMapping("/doSendWarnNum/{id}")
    public String doSendWarnNum(@PathVariable("id") int id){

        directSender.sendWarn(id);

        return "带叠加的警告发送成功！";
    }

}
