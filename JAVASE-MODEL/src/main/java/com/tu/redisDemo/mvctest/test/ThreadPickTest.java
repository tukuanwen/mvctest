package com.tu.redisDemo.mvctest.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 训练线程锁 及 线程状态控制
 *
 * 口诀：
 * 1、线程运作：线程 操作 资源类
 * 2、多线程交互：判断、干活、通知
 */

/**
 * demo实现：声明三个线程A、B、C，A线程完成5次打印、B线程完成10次打印、C线程完成15次打印。执行顺序为A>B>C。10轮
 *
 */

//声明资源类
class PickSource{

    //声明线程标识
    private int tflag = 1; //1:线程1  2:线程2  3:线程3
    //声明一把锁
    private Lock lock = new ReentrantLock();
    //声明控制线程状态的condition，每个线程声明1个
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    //打印5次方法
    public void doPrint5(){

        lock.lock();

        try{

            //判断
            while(tflag != 1){
                //当线程标示不为1时，线程1进入等待状态
                condition1.await();
            }

            //干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }

            //通知
            tflag = 2;
            condition2.signal();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }


    }

    //打印10次方法
    public void doPrint10(){

        lock.lock();

        try{
            //判断
            while (tflag != 2){
                condition2.await();
            }

            //干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }

            //通知
            tflag = 3;
            condition3.signal();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    //打印15次方法
    public void doPrint15(){
        lock.lock();

        try{
            while (tflag != 3){
                condition3.await();
            }

            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }

            tflag = 1;
            condition1.signal();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    //打印三合一,分别实现5、10、15次功能
    public void doPrint(int thNo){

        lock.lock();
        //声明当前线程状态操作类
        Condition conditionAwait = null;
        //声明当前线程打印的次数
        int printNum = 0;
        //声明唤醒下一个线程
        Condition conditionSignal = null;
        //声明下一个线程标示
        int nextFlag = 0;

        //判断当前是那个线程，获取到线程操作类
        if(thNo == 1){
            conditionAwait = condition1;
            printNum = 5;
        }else if(thNo == 2){
            conditionAwait = condition2;
            printNum = 10;
        }else if(thNo == 3){
            conditionAwait = condition3;
            printNum = 15;
        }

        try{
            //判断
            while (tflag != thNo){
                conditionAwait.await();
            }
            //干活
            for (int i = 0; i < printNum; i++) {
                System.out.println(Thread.currentThread().getName()+"\t打印第几次："+i);
            }

            if(thNo == 1){
                nextFlag = 2;
                conditionSignal = condition2;
            }else if(thNo == 2){
                nextFlag = 3;
                conditionSignal = condition3;
            }else if(thNo == 3){
                nextFlag = 1;
                conditionSignal = condition1;
            }

            //通知
            tflag = nextFlag;
            conditionSignal.signal();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }


    }

}

public class ThreadPickTest{


    public static void main(String[] args) {

        PickSource test = new PickSource();

//        new Thread(()->{
//            for (int i = 0; i < 3; i++) {
//                test.doPrint5();
//            }
//        },"A").start();
//
//        new Thread(()->{
//            for (int i = 0; i < 3; i++) {
//                test.doPrint10();
//            }
//        },"B").start();
//
//        new Thread(()->{
//            for (int i = 0; i < 3; i++) {
//                test.doPrint15();
//            }
//        },"C").start();

        for (int i = 1; i <= 3; i++) {
            final int tempi = i;
            new Thread(()->{
                for (int i1 = 0; i1 < 3; i1++) {
                    test.doPrint(tempi);
                }
            },String.valueOf(i)).start();
        }
    }
}