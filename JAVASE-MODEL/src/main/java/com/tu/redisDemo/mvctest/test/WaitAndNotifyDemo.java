package com.tu.redisDemo.mvctest.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DataSourceDemo{

    public static int flag = 1; //1:为生产者  2:为消费者
    volatile List<String> list = new ArrayList<>();
//    Lock lock = new ReentrantLock();
//    Condition condition1 = lock.newCondition();
//    Condition condition2 = lock.newCondition();

    //生产者
    public synchronized void prod(String str){

//        lock.lock();
        try{
            //判断flag是否为生产者
            while (flag != 1){
                try {
//                    condition1.await();
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(str);
            flag = 2;
//            condition2.signal();
            this.notifyAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
//            lock.unlock();
        }
    }

    //消费者
    public synchronized String cusm(){

        String str = "";
//        lock.lock();
        try{
            //判断flag是否为消费者
            while (flag != 2){
                try {
//                    condition2.await();
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            str = list.get(0);
            list.remove(0);
            flag = 1;
//            condition1.signal();
            this.notifyAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
//            lock.unlock();
        }

        return str;
    }
}


public class WaitAndNotifyDemo {

    public static void main(String[] args) {

        DataSourceDemo dsd = new DataSourceDemo();
        List<String> list = Arrays.asList("A","B","C","D");
        new Thread(()->{

            for (String s : list) {
                dsd.prod(s);
                System.out.println(Thread.currentThread().getName()+"生产："+s);
            }


        },"生产者").start();

        new Thread(()->{

            for (int i = 0; i < list.size(); i++) {
                System.out.println(Thread.currentThread().getName()+"消费："+dsd.cusm());
            }

        },"消费者者").start();



    }



}
