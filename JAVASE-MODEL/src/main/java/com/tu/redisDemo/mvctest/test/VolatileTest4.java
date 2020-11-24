package com.tu.redisDemo.mvctest.test;


import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 资源类
 */

class DataSource{

    volatile int number = 0;

    volatile double dNumber = 0;

    volatile String[] str = new String[]{"a","b","c"};
    volatile List list = Arrays.asList("a","b","c");


    public void upddNumber(){

        this.dNumber = 5;
    }

    public void adddPlus(){

        this.dNumber=this.dNumber+3.0;
    }

    public void updNumber(){
        this.number = 20;
    }

    public void addPlus(){

        number=number+5;

    }
}



public class VolatileTest4 {


    public static void main(String[] args){

        DataSource ds = new DataSource();
        for (int i = 0; i < 10; i++) {

            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ds.adddPlus();
                System.out.println(Thread.currentThread().getName()+":"+ds.dNumber);
            },"A").start();

        }

//        while (ds.dNumber == 0){}
        while (Thread.currentThread().getThreadGroup().activeCount() > 2){}

        System.out.println(Thread.currentThread().getName()+":"+ds.dNumber);




    }





    public static void doArray() {
        DataSource ds = new DataSource();

        for (int i = 0; i < 10; i++) {
            final int tmp = i;
            new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            ds.str[0] = "a1";
                ds.list.set(0,"a1");
                System.out.println(Thread.currentThread().getName()+"A数组："+ds.list.get(0));
            },"A"+i).start();
        }
        for (int i = 0; i < 10; i++) {
            final int tmp=i;
            new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            ds.str[1] = "b1";
                ds.list.set(0,"b1");
                System.out.println(Thread.currentThread().getName()+"B数组："+ds.list.get(1));
            },"B").start();
        }


//        while (ds.list.get(0)=="a" || ds.list.get(1) == "b"){}
        while (ds.list.get(0) != "a1" && ds.list.get(0) != "b1"){}

        System.out.println(Thread.currentThread().getName()+"M数组---------------------："+ds.list.get(0)+":"+ds.list.get(1));
    }

    //原子性案例
    public static void doAtomic() {
        DataSource ds = new DataSource();

        for (int i = 1; i <= 100; i++) {
            new Thread(()->{
                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch(Exception e){
                }

                ds.addPlus();

            }).start();
        }
        while (Thread.currentThread().getThreadGroup().activeCount() > 2){}
        System.out.println("结果为："+ds.number);
    }
    //可见性案例
    public static void doDateSource() {
        DataSource date = new DataSource();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"线程的副本值："+date.number);
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
            date.updNumber();

            System.out.println(Thread.currentThread().getName()+"线程修改后值："+date.number);
        },"A").start();
        ;
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        while (date.number == 0){}

        System.out.println(Thread.currentThread().getName()+"线程的值："+date.number);
    }

}
