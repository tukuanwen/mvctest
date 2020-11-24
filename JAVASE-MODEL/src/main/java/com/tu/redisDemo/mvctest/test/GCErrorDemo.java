package com.tu.redisDemo.mvctest.test;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class OOMTest{
}


public class GCErrorDemo {

    public static void main(String[] args) {

        metaspace();

    }
    //元空间溢出
    //OutOfMemoryError: Metaspace
    //Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
    private static void metaspace() {
//        byte[] b = new byte[50*1024*1024];
        int i = 0;
        try{
            System.out.println("打印");
            while (true){
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, objects);
                    }
                });
                enhancer.create();
            }
        }catch(Exception e){
            System.out.println("**************多少次后发生了异常："+i);
            e.printStackTrace();
        }
    }

    //程序存在线程数超过系统限制，解决方法：1、降低线程数量  2、调高系统对线程数限制
    private static void nativeThread() {

        for(int i = 1; ; i++){

            System.out.println("i的值："+i);
            new Thread(()->{
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },""+i).start();
        }

    }


    //JVM堆外内存溢出
    //Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
    private static void directMemory() {

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(50*1024*1024);

    }

    //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    //堆内存溢出,不断增加堆内存的数据量
    private static void oomJAVAHeapSpace() {

        String str = "asdjkfalfafalksdjfaklsdjfalksdjfalsdkjfalkdsfadsa";
        while (true){
            str += str + Math.round(328432843)+Math.round(323423423);
            System.out.println(str);
        }

    }

    //方法栈内存溢出，常见的是方法死循环调用
    //GCErrorDemo.stackOverFlowError
    private static void stackOverFlowError() {

        stackOverFlowError();
    }


    //Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
    //回收效果不明显，每次回收后内存依然存在80%以上的占用
    public static void oomGCOverhead() {
        int i = 0;
        List<String> list = new ArrayList<>();
        try{
            while (true){
                list.add(String.valueOf(++i));
            }
        }catch(Exception e){
            System.out.println("ID的值："+i);
            e.printStackTrace();
        }
    }
}
