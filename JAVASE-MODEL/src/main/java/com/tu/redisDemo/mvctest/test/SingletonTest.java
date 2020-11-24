package com.tu.redisDemo.mvctest.test;


public class SingletonTest {

    //懒汉式
    private static Singleton SOBJ = null;

    public static Singleton getSing(){

        if(null == SOBJ) SOBJ = new Singleton();

        return SOBJ;
    }

    //饿汉式
    private static Singleton SOBJ2 = null;

    public static Singleton getSing2(){

        SOBJ2 = new Singleton();

        return SOBJ2;
    }

    //加锁检查模式
    private static Singleton SOBJ3 = null;

    public static Singleton getSing3(){

        synchronized(Singleton.class){

            if(null == SOBJ3) SOBJ3 = new Singleton();
        }

        return SOBJ3;
    }

    //加锁双检查模式
    private static Singleton SOBJ4 =  null;

    public static Singleton getSing4(){

        if(null == SOBJ4){
            synchronized (Singleton.class){
                if (null == SOBJ4) SOBJ4 = new Singleton();
            }
        }
        return SOBJ4;
    }

    //内部类
    public static class SingletonIn{

        static final Singleton SOBJ5 = new Singleton();
    }



    public static void main(String[] args){

//        Singleton sing1 = SingletonTest.getSing();
//
//        Singleton sing2 = SingletonTest.getSing();
//
//        System.out.println(sing1.equals(sing2));
//
//        System.out.println(sing1);
//
//        System.out.println(sing2);

//        Singleton sing6 = SingletonEnum.HAHA.getSing6();
//        Singleton sing6bak = SingletonEnum.SINGLETON_ENUM.getSing6();
//
//        System.out.println(sing6.equals(sing6bak));
//
//        System.out.println(sing6);
//        System.out.println(sing6bak);
//        sing6.toHaha();
//        sing6bak.toHaha();
        System.out.println(SingletonEnum.HAHA.getSing6());
        System.out.println(SingletonEnum.HAHA.getSing6());


    }

}
