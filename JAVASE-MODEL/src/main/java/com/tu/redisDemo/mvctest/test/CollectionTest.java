package com.tu.redisDemo.mvctest.test;



import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReadWriteLock;

public class CollectionTest {

    public static void main(String[] args) {
//        doSynList();
//        doSynSet();

        Map<String,String> map = new ConcurrentHashMap<>();//Collections.synchronizedMap(new HashMap<>());//new HashMap<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{

                for (int i1 = 0; i1 < 10; i1++) {
                    map.put(Thread.currentThread().getName()+"-"+i1,"线程");
                }
                System.out.println(Thread.currentThread().getName()+map);
            }).start();
        }


    }

    public static void doSynSet() {
        Set<String> set = new CopyOnWriteArraySet<>();//Collections.synchronizedSet(new HashSet<String>());//new HashSet<>();

        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 10; i1++) {
                    set.add(Thread.currentThread().getName()+"\t 线程:"+i1);
                }

                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }


    public static void doSynList() {
        //构造一个初始容量为10的空列表
        List<String> list = new CopyOnWriteArrayList<>(); //Collections.synchronizedList(new ArrayList<>());//new Vector<>(); //new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            new Thread(()->{

                list.add(UUID.randomUUID().toString().substring(0,4));
                System.out.println(Thread.currentThread().getName()+"\t list值："+list);

            },String.valueOf(i)).start();
        }
    }

}
