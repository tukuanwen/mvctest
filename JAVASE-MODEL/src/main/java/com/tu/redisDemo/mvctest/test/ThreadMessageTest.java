package com.tu.redisDemo.mvctest.test;

/**
 * 练习两个线程之间的通讯，案例：两个线程实现交替操作一个资源类数，分别进行加一减一。
 */

class DateSourceNumber{

    private int number = 0;

    public synchronized void incrNumber(){

//        sleep,wait,yeild,notify notifyall,join

        while (number != 0) {
            try{
                this.wait();
            }catch(Exception e){
            }
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"数值："+number);
        this.notifyAll();
    }

    public synchronized void decrNumber(){

        while (number == 0){
            try{
                this.wait();
            }catch(Exception e){
            }
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"数值："+number);
        this.notifyAll();

        if(false){

        }

    }

}

public class ThreadMessageTest {

    public static void main(String[] args) {

        DateSourceNumber ds = new DateSourceNumber();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                ds.incrNumber();
            }

        },"加线程1").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                ds.incrNumber();
            }

        },"加线程2").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                ds.decrNumber();
            }

        },"减线程1").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                ds.decrNumber();
            }

        },"减线程2").start();
    }
}
