package com.tu.mvctest.test;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

interface MyFoo{

    public void printstr();
    public void printstr2();
}


public class LambdaTest{

    public static void main(String[] args){

        //直接new一个接口
        MyFoo foo = new MyFoo() {
            @Override
            public void printstr() {
                System.out.println("打印一个匿名内部类");
            }

            public void printstr2() {
                System.out.println("打印一个匿名内部类");
            }
        };



//        foo = ()->{foo::printstr{System.out.println("使用Lambda表达式");}};
//        Arrays.asList(1,2,3,4,5).forEach();

    }


}
