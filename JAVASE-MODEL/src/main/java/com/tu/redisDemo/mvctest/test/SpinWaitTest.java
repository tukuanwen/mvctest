package com.tu.redisDemo.mvctest.test;

import org.apache.commons.lang3.time.StopWatch;

public class SpinWaitTest {

    private static int _count = 1000;
    private static int _timeout_ms = 10;

    public static void Main(String[] args) {
        //NoSleep();
        ThreadSleepInThread();
        SpinWaitInThread();

    }

    private static void NoSleep() {
        Thread thread = new Thread(() -> {
            StopWatch sw = StopWatch.createStarted();

            for (int i = 0; i < _count; i++) {

            }
            System.out.println("No Sleep Consume Time:" + sw.getNanoTime());
        });
        thread.setDaemon(true);
        thread.start();
    }

    private static void ThreadSleepInThread() {
        Thread thread = new Thread(() -> {
            StopWatch sw = StopWatch.createStarted();
            for (int i = 0; i < _count; i++) {
                try {
                    Thread.sleep(_timeout_ms);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread Sleep Consume Time:" + sw.getNanoTime());
        });
        thread.setDaemon(true);
        thread.start();
    }

    private static void SpinWaitInThread() {

        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("");

        Thread thread = new Thread(() -> {
            StopWatch sw = StopWatch.createStarted();
            for (int i = 0; i < _count; i++) {
//                Thread. SpinWait.SpinUntil(() -> true, _timeout_ms);
            }
//        Console.WriteLine("SpinWait Consume Time:{0}", sw.Elapsed.ToString());
//            });
//        thread.IsBackground = true;
//        thread.Start();
        });
    }
}
