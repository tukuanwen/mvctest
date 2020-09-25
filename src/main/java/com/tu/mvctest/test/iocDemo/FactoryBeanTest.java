package com.tu.mvctest.test.iocDemo;

import org.springframework.beans.factory.FactoryBean;

/**
 * 工厂beandemo,需要实现FactoryBean接口,并实现getObject(返回真实的实例对象)、getObjectType(返回实例对象类型)、isSingleton三个方法
 */
public class FactoryBeanTest implements FactoryBean<TestBean> {
    @Override
    public TestBean getObject() throws Exception {

        TestBean tb = new TestBean();

        return tb;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
