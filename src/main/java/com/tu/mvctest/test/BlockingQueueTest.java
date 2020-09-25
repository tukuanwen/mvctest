package com.tu.mvctest.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {

    public static void main(String[] args) {

        //初始化队列大小
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);

      /**  blockingQueue.add("a");
        blockingQueue.add("a");
        blockingQueue.add("a");
        blockingQueue.add("d");
        blockingQueue.remove();
        System.out.println(blockingQueue.size());
        blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();*/
      blockingQueue.element();


//        blockingQueue.offer("a");
//        blockingQueue.offer("b");
//        blockingQueue.offer("c");
//        System.out.println(blockingQueue.offer("d"));
//
//        blockingQueue.poll();
//        blockingQueue.poll();
//        blockingQueue.poll();
//        System.out.println(blockingQueue.poll());
        blockingQueue.peek();
        /**
         * 过时不候
         */
        try {
            blockingQueue.offer("a",3, TimeUnit.SECONDS);
            blockingQueue.poll(3,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //**************不见不散，过时不候***************
        /**
         * 不见不散
         */
        try {
            blockingQueue.put("a");
            blockingQueue.put("a");
            blockingQueue.put("a");
            blockingQueue.put("a");

            blockingQueue.take();
            blockingQueue.take();
            blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
