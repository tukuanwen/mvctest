package com.tu.mvctest.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 配置文件类，替代xml配置。在类中添加标签
 */
//配置文件标签
@Configuration
//配置文件扫描注解标签
@ComponentScan(basePackages = "com.tu")
//声明AspectJ标签
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfiguration {
    
    @Bean
    public void getBean(){
        
    }
    
}
