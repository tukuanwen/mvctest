package com.tu.springbootjms;

import com.tu.springbootjms.activemqDemo.ActiveMQProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private ActiveMQProduct activeMQProduct;

    @Test
    void contextLoads() {
    }

    @Test
    public void doActiveMessage(){


        activeMQProduct.doSend();

    }


}
