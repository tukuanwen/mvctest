package com.tu.springbootjmstopicconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;

@SpringBootApplication
//@EnableJms
public class SpringbootJmsTopicConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJmsTopicConsumerApplication.class, args);
    }

}
