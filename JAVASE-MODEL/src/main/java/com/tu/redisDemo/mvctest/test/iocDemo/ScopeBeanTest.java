package com.tu.redisDemo.mvctest.test.iocDemo;


/**
 * 演示spring bean作用域和生命周期
 *
 * 作用域由bean scope属性控制，scope默认singleton
 * scope有四个值：singleton(默认，单例的)、prototype(多实例)、request、session
 * 其中，singleton是在xml加载时就创建实例，prototype实在获取bean时才创建
 *------------------------------------------------------------
 * 生命周期：bean的创建过程
 * 1、通过构造函数创建bean对象（默认是无参构造函数）
 * 2、通过set方法为属性设置值或引用
 * 3、在初始化方法前调用的方法
 * 4、调用初始化方法（初始化方法配置在<bean init-method=""></bean>）
 * 5、在初始化方法后调用的方法
 * 6、bean可以正式使用了
 * 7、当容器关闭时，调用bean的销毁方法<bean destory-method = ""></bean>
 * 第3、5步，个人理解是进行初始化外部属性处理的拦截方法，需要配置文件中存在有实现BeanPostProcessor接口，只要存在一个bean继承此接口，所有bean中都会默认实现
 *
 */
public class ScopeBeanTest {

    private String sName;

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void initMthod(){
        System.out.println("bean初始化方法");
    }

    public void destroyMethod(){
        System.out.println("容器关闭时bean销毁方法");
    }
}
