package com.tu.redisDemo.rabbitmqtest.config;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息队列的一些配置
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public DirectExchange directExchange(){
        // 注册一个 Direct 类型的交换机 默认持久化、非自动删除
        return new DirectExchange("directExchange");
    }

    @Bean
    public Queue infoQueue(){
        //注册一个消息队列
        return new Queue("infoMsgQueue");
    }

    @Bean
    public Queue warnQueue(){
        //注册一个警告队列
        return new Queue("warnMsgQueue");
    }

    @Bean
    public Binding infoToExchangeBinging(Queue infoQueue, DirectExchange directExchange){

        // 将队列以 info-msg 为绑定键绑定到交换机
        return BindingBuilder.bind(infoQueue).to(directExchange).with("info-msg");
    }

    @Bean
    public Binding warnToExchangeBinging(Queue warnQueue, DirectExchange directExchange){

        // 将队列以 warn-msg 为绑定键绑定到交换机
        return BindingBuilder.bind(warnQueue).to(directExchange).with("warn-msg");
    }


}
