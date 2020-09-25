package com.tu.mvctest.test;


import java.util.concurrent.TimeUnit;

class LockReplace implements Runnable{

    private String lockA;
    private String lockB;

    public LockReplace(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"此锁A再想获取B锁："+lockB);
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"此锁B再想获取A锁："+lockA);
            }
        }
    }
}


public class DeadLockDemo {

    public static void main(String[] args) {

        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new LockReplace(lockA,lockB),"AAA").start();
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new Thread(new LockReplace(lockB,lockA),"BBB").start();
    }

}
