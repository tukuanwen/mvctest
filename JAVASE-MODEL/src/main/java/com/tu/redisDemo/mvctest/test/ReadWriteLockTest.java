package com.tu.redisDemo.mvctest.test;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MapSource{

    private volatile Map<String, Object> map = new HashMap<>();
    private Lock lock = new ReentrantLock();

    public void doPut(String key, Object value){

        lock.lock();

        try{
            System.out.println(Thread.currentThread().getName()+"\t 写入数据："+key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成："+key);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }

    }

    public void doGet(String key){

        System.out.println(Thread.currentThread().getName()+"\t 读取数据");

        System.out.println(Thread.currentThread().getName()+"\t 数据值："+map.get(key));

    }

}

public class ReadWriteLockTest {

    public static void main(String[] args) {
        MapSource mapSource = new MapSource();
        for (int i = 0; i < 3; i++) {
            final int temp = i;
            new Thread(()->{

                mapSource.doPut(temp+"-线程", temp+"-线程");

            },"A"+String.valueOf(i)).start();
        }

        for (int i = 0; i < 3; i++) {
            final int temp = i;
            new Thread(()->{
                mapSource.doGet(temp+"-线程");
            },"B"+String.valueOf(i)).start();
        }
    }
}
