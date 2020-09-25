package com.tu.mvctest.test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Student{

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class CollectionDemo {

    Lock lock = new ReentrantLock();

    public void doLock(){

        lock.lock();

        try{

            lock.tryLock(3,TimeUnit.SECONDS);//超过一定时间
            lock.lockInterruptibly();//中断

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }

    }


    public static void main(String[] args) {

        List list = new ArrayList();

        Student s1 = new Student("A1",12);
        Student s2 = new Student("A2",13);
        Student s3 = new Student("A3",14);
        Student s4 = new Student("A4",15);
        Map map = new HashMap();
        Map lmap = new LinkedHashMap();
        lmap.put("a","c");

    }

    public static void doCollection() {
        Collection collection = new ArrayList();
        Student s1 = new Student("A1",12);
        Student s2 = new Student("A2",13);
        Student s3 = new Student("A3",14);
        ((ArrayList) collection).add(s1);
        ((ArrayList) collection).add(s2);
        ((ArrayList) collection).add(s3);
        new Thread(()->{
            Iterator iterator = collection.iterator();
            while(iterator.hasNext()){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+iterator.next());
            }

        },"线程A").start();

        new Thread(()->{
            Iterator iterator = collection.iterator();
            while(iterator.hasNext()){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                ((ArrayList) collection).add(s1);
            }
        },"线程B").start();
    }

}
