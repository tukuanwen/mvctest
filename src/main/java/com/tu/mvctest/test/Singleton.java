package com.tu.mvctest.test;

class SingletonDemo{

    private SingletonDemo(){}


    //==================================内部类单例=======================================
    private static class SingleClass{

        private final static SingletonDemo singletonDemo = new SingletonDemo();

    }

    public static SingletonDemo getInstance0(){

        return SingleClass.singletonDemo;
    }

    //===================================枚举型单例=======================================
    private enum SingleType{

        INSTANCE;

        private SingletonDemo singletonDemo;
        SingleType(){
            singletonDemo = new SingletonDemo();
        }

        public SingletonDemo getSingletonDemo(){
            return singletonDemo;
        }
    }

    public static SingletonDemo getInstance1(){
        return SingleType.INSTANCE.getSingletonDemo();
    }

}


public class Singleton {

    public static void main(String[] args) {

        System.out.println(SingletonDemo.getInstance0());
        System.out.println(SingletonDemo.getInstance1());

    }
}
