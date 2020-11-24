package com.tu.redisDemo.mvctest.test;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Mennoey{

    Lock lock = new ReentrantLock();
    public void read(){

        System.out.println(Thread.currentThread().getName()+"读锁之前的打印");
        synchronized (this){
            try{
                TimeUnit.SECONDS.sleep(5);
            }catch(Exception e){
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"读锁之内的打印");
        }
    }

    public void wirte(){

        System.out.println(Thread.currentThread().getName()+"写锁之前的打印");
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+"写锁之内的打印");
        }
    }

    public void readLock(){

        System.out.println(Thread.currentThread().getName()+"读锁之前的打印");

        lock.lock();
        try{
            try{
                TimeUnit.SECONDS.sleep(5);
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"读锁之内的打印");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }


    }

    public void wirteLock(){

        System.out.println(Thread.currentThread().getName()+"写锁之前的打印");

        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"写锁之内的打印");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}



public class SynchronizedTest {

    public static void main(String[] args) {
        Mennoey m = new Mennoey();

        new Thread(()->{
            m.readLock();
        },"A").start();

        new Thread(()->{
            m.wirteLock();
        },"B").start();

    }

}
