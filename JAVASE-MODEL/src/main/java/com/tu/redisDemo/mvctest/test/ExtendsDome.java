package com.tu.redisDemo.mvctest.test;

class A{

}

class B extends A{

}

class C extends B{

}


public class ExtendsDome {

    public static void main(String[] args) {
        B b = new B();
        C c = (C)b;

        B b1 = c;

        Cloneable clone = new Cloneable() {
            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }
        };

        Object o = new Object();

    }

}
