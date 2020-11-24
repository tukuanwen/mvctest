package com.tu.redisDemo.mvctest.test;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class InitNumClass{

    private ReentrantReadWriteLock lock= new ReentrantReadWriteLock();

    public Integer initNum = 10;

    public void hhh(){
        lock.readLock().lock();
    }
}

//声明一个减一操作功能
interface DecrObject{

    //减一方法
    public void decr(InitNumClass initNum,Integer num);
}

interface IncrObject{

    //加一方法
    public void incr(InitNumClass initNum, Integer num);
}

/**
 * 实现一个钟摆模拟程序，即对一个数进行加一减一操作，重复10次。
 */
class ShareDate{
    //定义一个初始值，通过循环对次数进行加减
    private Integer initNum = 0;

    // **********************synchronized start*****************************
    //定义一个加的操作方法，因是多线程调用，必须加锁
    public synchronized void incr(){

        //逻辑，需要判断initNum是否回到0了，如果不为0则需要等待init减1后才能执行
        try {
            while (initNum != 0) {
                this.wait();
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        //当initNum 为0时，则进行加1，同时需要唤醒减1线程操作
        ++initNum;
        System.out.println(Thread.currentThread().getName()+"\t 线程的initNum:"+initNum);
        //唤醒其他线程
        this.notifyAll();
    }

    //定义一个减的操作方法，因是多线程调用，必须加锁
    public synchronized void decr(){

        //逻辑，需要确认initNum是否已经回到1了，如果不为1则需要进行等待
        try {
            while (initNum == 0){
                this.wait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        //如果不为0，则需要进行回0操作
        --initNum;
        System.out.println(Thread.currentThread().getName()+"\t 线程initNum:"+initNum);
        //唤醒回摆1的操作
        this.notifyAll();
    }

    //*******************************synchronized end*********************************
    //*******************************lock start**************************************
    //为对象创建一把锁
    private Lock lock = new ReentrantLock();
    //创建lock的condition
    Condition condition = lock.newCondition();

    public void incr2(){
        //为该操作加上一把锁
        lock.lock();
        //判断钟摆是否回到0，如果没有回到0，则等待
        try {
            while (initNum != 0)
                condition.await();
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        //如果钟摆回到0，则进行加1
        ++initNum;
        System.out.println(Thread.currentThread().getName()+"\t 线程initNum："+initNum);
        //唤醒其他的线程
        condition.signalAll();
        //释放锁
        lock.unlock();

    }

    public void decr2(){

        //为该操作加上一把锁
        lock.lock();
        //判断钟摆是否回到1，如果没有回到1，则等待
        try {
            while (initNum == 0)
                condition.await();
        }catch (Exception e){

        }
        //如果回到1了，则进行--
        --initNum;
        System.out.println(Thread.currentThread().getName()+"\t 线程initNum:"+initNum);
        //唤醒其他等待线程
        condition.signalAll();

        //释放锁
        lock.unlock();
    }

}


public class NotifyWaitTest {

//    volatile static Integer number = 9;

    public static void main(String[] args){

        new NotifyWaitTest().a();
//        new NotifyWaitTest().b();
//        new NotifyWaitTest().c();

    }


    //lock
    public void c(){

        ShareDate sh = new ShareDate();

        new Thread(()->{
            for(int i=1;i<=10;i++) {
                try{
                    sh.incr2();
                    Thread.sleep(200);
                }catch (Exception e){

                }
            }
        },"lockAA").start();

        new Thread(()->{
            for(int i=1;i<=10;i++) {
                try{
                    sh.decr2();
                    Thread.sleep(300);
                }catch (Exception e){

                }

            }
        },"lockBB").start();

        new Thread(()->{
            for(int i=1;i<=10;i++) {
                try{
                    sh.incr2();
                    Thread.sleep(400);
                }catch (Exception e){

                }
            }
        },"lockCC").start();

        new Thread(()->{
            for(int i=1;i<=10;i++) {
                try{
                    sh.decr2();
                    Thread.sleep(500);
                }catch (Exception e){

                }

            }
        },"lockDD").start();

    }


    //synchronized
    public void b(){

        //创建资源类
        ShareDate sh = new ShareDate();

        //创建线程
        new Thread(()->{

            for(int i =1 ; i <= 10 ; i++) {
                sh.incr();
                try {
                    Thread.sleep(200);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                sh.decr();
                try {
                    Thread.sleep(300);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"BB").start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                sh.decr();
                try {
                    Thread.sleep(400);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"CC").start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                sh.decr();

            }
        },"DD").start();
    }

    //接口方式实现
    public void a(){

        InitNumClass initNum = new InitNumClass();

        //线程1
        new Thread(()->{
            DecrObject decr = (nclass, n) ->{
                initNum.initNum = nclass.initNum - n;
                Integer m = nclass.initNum;
//                initNum.initNum = m;
//                try{
//                    this.wait();
//                }catch (Exception e){
//
//                }
                System.out.println(Thread.currentThread().getName()+"执行了减5后, 结果："+ m);
            };
            decr.decr(initNum, 5);
            System.out.println(Thread.currentThread().getName()+"结果A:"+initNum.initNum);
        },"A").start();
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e){

        }

        //线程2
        new Thread(()->{
            IncrObject incr = (nclass, n)->{
                initNum.initNum = nclass.initNum + n;
                Integer m = nclass.initNum;

                System.out.println(Thread.currentThread().getName()+"执行了加7后，结果："+ m);
            };
            incr.incr(initNum, 7);
            System.out.println(Thread.currentThread().getName()+"结果B:"+initNum.initNum);
        },"B").start();

        System.out.println(initNum.initNum);



    }

}
