package com.tu.mvctest.test;

import java.util.concurrent.TimeUnit;

public class JAVAGCDemo {


    public void doDemo(){

        byte[] b = new byte[50*1024*1024];



    }

    //元空间内存溢出：-XX:MetaspaceSize=1m -XX:MaxMetaspaceSize=1m
//    static byte[] b = new byte[10*1024*1024];
    public static void main(String[] args) {

//        堆内存溢出：-Xms10m -Xmx10m
//        byte[] b = new byte[10*1024*1024];
//        JAVAGCDemo j = new JAVAGCDemo();
//        j.doDemo();
//
//        try {
//            j.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }

        try {
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
