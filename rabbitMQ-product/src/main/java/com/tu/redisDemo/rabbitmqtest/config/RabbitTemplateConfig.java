package com.tu.redisDemo.rabbitmqtest.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class RabbitTemplateConfig {

    /**
     * 生产这发送端确认实例
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        // 消息发送失败返回到队列中, yml需要配置 publisher-returns: true
        rabbitTemplate.setMandatory(true);

        // 消息返回, yml需要配置 publisher-returns: true
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            System.out.println("Fail... message:{"+message+"},从交换机exchange:{"+exchange+"},以路由键routingKey:{"+routingKey+"}," +
                    "未找到匹配队列，replyCode:{"+replyCode+"},replyText:{"+replyText+"}");
        });

        // 消息确认, yml需要配置 publisher-confirms: true
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if(ack){
                System.out.println("成功：消息成功发送到了消息队列交换机中，"+correlationData);
            }else{
                System.out.println("失败：消息发送到交换机中失败，"+correlationData);
            }
        });

        return rabbitTemplate;
    }
}
