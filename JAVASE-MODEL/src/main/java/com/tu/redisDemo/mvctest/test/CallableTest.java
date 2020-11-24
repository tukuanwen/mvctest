package com.tu.redisDemo.mvctest.test;


import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CallableTest {

    public static void main(String[] args) {
        //统计线程数递减
//        doCountDownLatch();
        //统计线程数递增
//        doCyclicBarrier();
        //线程信号控制
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {

            new Thread(()->{

                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"线程占位");
                    try{
                        TimeUnit.SECONDS.sleep(4);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"线程离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    semaphore.release();
                }

            },String.valueOf(i)).start();
        }

        System.out.println("线程数量："+Thread.currentThread().getThreadGroup().activeCount());

    }

    public static void doCyclicBarrier() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{System.out.println("装进来的线程");});

        for (int i = 0; i < 7; i++) {
            final int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 第"+temp+"线程");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        //还在存在的问题是 为啥调用await方法？？？？
    }


    //CountDownLatch demo
    public static void doCountDownLatch() {
        CountDownLatch count = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(new FutureTask(()->{
                System.out.println(Thread.currentThread().getName()+"调用callablecall方法");
                count.countDown();
                return 200;
            }), String.valueOf(i)).start();
        }


        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程全部完成结束了");

        System.out.println(Thread.currentThread().getName());
    }


}
