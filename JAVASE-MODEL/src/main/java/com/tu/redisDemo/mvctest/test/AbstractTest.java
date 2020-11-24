package com.tu.redisDemo.mvctest.test;

public abstract class AbstractTest {


    public static void doTest(){

        System.out.println("测试");
    }

    public abstract void doTest2();

    public static void main(String[] args) {
        System.out.println("iiiiiiiiii");

//        AbstractTest test = new AbstractTest() {
//            @Override
//            public void doTest() {
//                super.doTest();
//            }
//
//            @Override
//            public void doTest2() {
//                System.out.println("oooooooooooooooo");
//            }
//        };
//
//        test.doTest();
//        test.doTest2();
        AbstractTest.doTest();
    }
}
