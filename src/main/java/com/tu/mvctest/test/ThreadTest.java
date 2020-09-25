package com.tu.mvctest.test;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Tietk{
    //初始化30张票
    private int number = 30;

    //需要创建一把锁
    private Lock lock =  new ReentrantLock();

    public void payTietk(){

        //主要操作前加上锁
        lock.lock();
        try {

            if(this.number > 0) {
                //主要操作为，对票进行递减，并且打印出操作线程
                System.out.println(Thread.currentThread().getName() + "\t卖出第几张：" + (number--) + "\t还剩第几张" + number);
            }



        }catch (Exception e) {
        }finally {
            //主要操作结束后释放锁
            lock.unlock();
        }
        try {

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

public class ThreadTest {

    public static void main(String[] args){

        //创建资源类
        final Tietk tietk = new Tietk();
//        //创建线程A
//        new Thread(new Runnable() {
//            public void run() {
//                //判断如果资源类资源不足就不做操作（票数小于0，不再减）
//                for(int i = 1; i <= 40; i++)
//                //建立操作
//                tietk.payTietk();
//            }
//        },"A").start();
//
//
//        //创建线程B
//        new Thread(new Runnable() {
//            public void run() {
//                //建立操作
//                for(int i = 1; i <= 40; i++)
//                tietk.payTietk();
//            }
//        },"B").start();
//
//        //创建线程C
//        new Thread(new Runnable() {
//            public void run() {
//                //建立操作
//                for(int i = 1; i <= 40; i++)
//                tietk.payTietk();
//            }
//        },"C").start();

//        for(int j = 1; j <=4; j++) {
            new Thread(() -> {
                for (int i = 1; i <= 40; i++) {
                    tietk.payTietk();
                }
            }, "").start();
//        }
    }

}
