package com.tu.redisDemo.mvctest.test;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFutureDemo {

    public static void main(String[] args) {

        //没有返回值的异步回调
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("没有返回值的异步回调");
        });

        try {
            voidCompletableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //========================================有返回值==============================================
        //有返回值的异步回调
        CompletableFuture<Integer> uCompletableFuture = CompletableFuture.supplyAsync(() -> {

            System.out.println("有返回结果");
            return 1024;
        });

        uCompletableFuture.whenComplete((s, t)->{
            System.out.println("有返回，正确结果为："+s);
            System.out.println("有返回，异常结果为："+t);
        }).exceptionally(s->{
            return 444;
        });

//        Future
//        try {
//            System.out.println(uCompletableFuture.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }


    }

}
