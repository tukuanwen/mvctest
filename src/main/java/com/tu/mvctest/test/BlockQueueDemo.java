package com.tu.mvctest.test;

import jdk.nashorn.internal.ir.Flags;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//资源类
class MySource{

    //启动暂停标志
    private volatile boolean FLAG = true;
    //具体信息
    private AtomicInteger atomicInteger = new AtomicInteger();
    //创建一个消息队列
    private BlockingQueue<String> blockingQueue = null;

    //为外部调用者提供可自主选择的消息队列,构造参数设置接口类型，具体实现让调用者决定
    public MySource(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
        System.out.println("具体实现的blockingQueue为："+blockingQueue.getClass().getName());
    }

    //生产者方法
    public void myProd(){
        //生产的内容
        String prodValue = "";
        //生产是否成功
        boolean prodFlag = true;
        //如果消息队列服务还没有暂停则继续生产
        while(FLAG){
            //1秒钟生产一个
            try {
                prodValue = atomicInteger.incrementAndGet()+"";
                prodFlag = blockingQueue.offer(prodValue,1, TimeUnit.SECONDS);
                System.out.println("生产者内容为："+prodValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!prodFlag){
            System.out.println("生产者已结束，FLAG=false");
        }
    }

    //消费者方法
    public void myComsu(){

        //消费的消息为
        String comsuValue = "";
        //如果消息队列还没有暂停则继续生产
        while (FLAG){

            //消费队列中的消息
            try {
                comsuValue = blockingQueue.poll(1,TimeUnit.SECONDS);
                System.out.println("消费者消费内容："+comsuValue);
                if (null == comsuValue || "".equals(comsuValue)){
                    System.out.println("队列消息已为空，可以退出消息队列了");
                    FLAG = false;
                }

                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //停止消息队列
    public void stopQueue(){

        this.FLAG = false;
    }
}

/**
 * 需要实现的功能，使用消息队列方式，对消息依次进行生产与消费
 */
public class BlockQueueDemo {

    public static void main(String[] args) {

        MySource mySource = new MySource(new ArrayBlockingQueue<>(3));

        new Thread(()->{

            mySource.myProd();

        },"生产者").start();

        new Thread(()->{

            mySource.myComsu();

        },"消费者").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5秒后停止消息队列进行");
        mySource.stopQueue();
    }

}
