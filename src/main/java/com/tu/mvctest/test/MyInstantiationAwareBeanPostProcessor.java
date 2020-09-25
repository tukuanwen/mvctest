package com.tu.mvctest.test;

import com.sun.javafx.property.adapter.PropertyDescriptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    public MyInstantiationAwareBeanPostProcessor(){
        System.out.println("【InstantiationAwareBeanPostProcessor接口】调用InstantiationAwareBeanPostProcessor构造方法");
    }

    /**
     * 实例化Bean之前调用
     * @return
     */

    public Object postProcessBeforeInstantiation(){
        System.out.println("【InstantiationAwareBeanPostProcessor接口】调用InstantiationAwareBeanPostProcessor接口的postProcessBeforeInstantiation方法");
        return null;
    }

    /**
     * 实例化Bean之后调用
     */

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("【InstantiationAwareBeanPostProcessor接口】调用InstantiationAwareBeanPostProcessor接口的postProcessAfterInitialization方法");
        return bean;
    }

    /**
     * 设置某个属性时调用
     */
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName){
        System.out.println("【InstantiationAwareBeanPostProcessor接口】调用InstantiationAwareBeanPostProcessor接口的postProcessPropertyValues方法");
        return pvs;
    }
}
