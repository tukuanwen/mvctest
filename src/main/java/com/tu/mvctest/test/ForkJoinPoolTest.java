package com.tu.mvctest.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 使用ForkJoinPool方式（分支合并计算框架）实现0~100的求和计算
 */
class MyTask extends RecursiveTask<Integer> {

    private final static Integer ADJUST = 10;
    private int begin;
    private int end;
    //必须保证为int类型
    private int result;

    public MyTask(Integer begin, Integer end){
        this.begin = begin;
        this.end = end;
    }

    //计算
    @Override
    public Integer compute() {

        if((end - begin) <= ADJUST){

            for (Integer i = begin; i <= end; i++) {
                result = result + i;
            }
        }else{
            Integer midden = (begin + end) / 2;

            MyTask myTask1 = new MyTask(begin, midden);
            MyTask myTask2 = new MyTask(midden+1, end);
            myTask1.fork();
            myTask2.fork();
            result = myTask1.join()+myTask2.join();
        }

        return result;
    }
}

public class ForkJoinPoolTest {

    public static void main(String[] args) {

        //ForkJoinPool
        //ForkJoinTask
//        RecursiveTask

        MyTask myTask = new MyTask(0,100);

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinTask<Integer> result = forkJoinPool.submit(myTask);

        System.out.println(result.getClass().toString());
        try {
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        forkJoinPool.shutdown();




    }
}
