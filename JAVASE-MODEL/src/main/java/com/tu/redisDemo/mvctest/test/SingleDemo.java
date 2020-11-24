package com.tu.redisDemo.mvctest.test;

class SingleAA{
    private static volatile SingleAA singleAA;

    private SingleAA(){
        System.out.println("实例化bean");
    }

    public static SingleAA getSingle(){

        if(singleAA == null){

            synchronized (SingleAA.class){

                if(singleAA == null){
                    singleAA = new SingleAA();
                }
            }
        }
        return singleAA;
    }
}

public class SingleDemo {

    public static void main(String[] args) {

//        System.out.println(SingleAA.singleAA);
        SingleAA.getSingle();
        SingleAA.getSingle();
        SingleAA.getSingle();
        SingleAA.getSingle();
//        System.out.println(SingleAA.singleAA);



    }

}
