package com.tu.redisDemo.mvctest.test;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


class User{



}

public class FunctionStreamTest {

    public static void main(String[] args) {

        //链式编程+流式计算
        //========================函数式接口==========================
        Function<String, String> f = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };

        System.out.println(f.apply("沈冲"));

        Function<String, Integer> f2 = s -> {
            return 200;
        };

        System.out.println(f2.apply("haha"));
        //=======================断定型接口====================
        Predicate<String> p = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };

        System.out.println(p.test("哈哈哈哈"));

        Predicate<String> p2 = s->{

            return s.isEmpty();
        };

        System.out.println(p2.test("哈哈哈哈"));

        //=========================消费型接口=====================
        Consumer<String> c = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        c.accept("消费型接口");

        Consumer<String> c2 = s->{
          System.out.println(s);
        };
        c2.accept("消费型接口-lambda");

        //===========================供给型接口======================
        Supplier<String> s = new Supplier<String>() {
            @Override
            public String get() {
                return "供给型接口";
            }
        };
        System.out.println(s.get());

        Supplier<String> s2 = ()->{

            return "供给型接口-lambda";
        };
        System.out.println(s2.get());

    }
}
