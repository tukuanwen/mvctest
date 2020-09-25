package com.tu.mvctest.test;

import java.util.concurrent.*;

public class ExecutorTest {


    public static void main(String[] args) {

        ExecutorService exe = Executors.newFixedThreadPool(5);
        ExecutorService e1 = Executors.newSingleThreadExecutor();
        ExecutorService e2 = Executors.newCachedThreadPool();

        ExecutorService e3 = new ThreadPoolExecutor(
                2,
                5,
                1,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingQueue(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            exe.execute(()->{
                System.out.println(Thread.currentThread().getName()+"：占领线程");
            });

//            exe.submit()

            try{

            }catch(Exception e){
                e.printStackTrace();
            }finally{
//
            }
        }
        exe.shutdown();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getThreadGroup().activeCount());


    }


}
