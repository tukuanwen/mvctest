package com.tu.mvctest.test;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class AtomicData{

    AtomicInteger aInt = new AtomicInteger(7);

    AtomicReference<Integer> bInt = new AtomicReference<>(9);



    public void addPlus(int Anum, int Bnum){

        aInt.addAndGet(Anum);
        bInt.compareAndSet(Anum, Bnum);
        
    }

}

public class AtomicTest
{


    public static void main(String[] args) {

        AtomicData aData = new AtomicData();

        new Thread(()->{

            aData.addPlus(6, 5);
            System.out.println(Thread.currentThread().getName()+"A结果值："+aData.aInt.get());

            System.out.println(Thread.currentThread().getName()+"B结果值："+aData.bInt.get());

        },"A").start();

    }


}
