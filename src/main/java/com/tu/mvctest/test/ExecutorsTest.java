package com.tu.mvctest.test;


import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 资源类
 */
class StateSource{

    public void printTest(String threadName){

        System.out.println(Thread.currentThread().getName()+"线程名字：" + threadName);

    }

}


public class ExecutorsTest {

    public static void main(String[] args){


        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        StateSource ss = new StateSource();

//        Arrays.asList(1,2,3,4,5).forEach(System.out::println);
        Future<?> f = null;
        for(int ll=1; ll<=20; ll++){

            int t = ll;

            try{
               f = threadPool.submit(()-> {
            String aa = "";
                   System.out.println(t);
                   ss.printTest("AA");
                   return new Random().nextInt(50);

               });
                System.out.println("线程号："+ f.get());
            }catch (Exception e){
                e.printStackTrace();
            }


        }

        threadPool.shutdown();


    }


}
