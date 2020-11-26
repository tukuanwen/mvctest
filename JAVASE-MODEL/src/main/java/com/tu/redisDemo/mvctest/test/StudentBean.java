package com.tu.redisDemo.mvctest.test;

//import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * InitializingBean: 初始化，
 * DisposableBean：销毁
 * BeanNameAware：设置beanName
 * BeanFactoryAware：加入到beanFactory工厂中
 */

public class StudentBean {//implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware {

    //bean两个属性
    private String name;
    private int age;

    private String beanName;         //实现了BeanNameAware接口，Spring可以将BeanName注入该属性中
//    private BeanFactory beanFactory; //实现了BeanFactory接口，Spring可将BeanFactory注入该属性中

    public StudentBean(){
        System.out.println("实例化bean对象");
    }

    public String doString(){
        return "studentBean:{name:"+name+", age:"+age+"}";
    }

//    /**
//     * BeanFactoryAware 接口方法
//     * @param beanFactory
//     * @throws BeansException
//     */
//    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        this.beanFactory = beanFactory;
//        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware的setBeanFactory方法得到beanFactory引用");
//    }

    /**
     * BeanNameAware 接口
     * @param name
     */
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("【BeanNameAware接口】调用BeanNameAware的setBeanName方法得到Bean的名称");
    }

    /**
     * DisposableBean接口方法
     * @throws Exception
     */
    public void destroy() throws Exception {
        System.out.println("【DisposableBean接口】调用DisposableBean接口的destroy方法");
    }

    //初始后调用此方法进行参数文件处理

    /**
     * InitializingBean接口方法
     * @throws Exception
     */
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean接口的afterPropertiesSet方法");
    }

    //自定义初始化方法
    public void myInit(){
        System.out.println("【myInit()初始化方法】调用init-method属性配置初始化属性");
    }

    //自定义销毁方法
    public void myDestroy(){
        System.out.println("【myDestroy()销毁方法】调用destroy-method属性配置销毁属性");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("调用了setage()方法，设置参数");
        this.age = age;
    }

    public String getName() {
        System.out.println("调用了setName()方法，设置参数");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
