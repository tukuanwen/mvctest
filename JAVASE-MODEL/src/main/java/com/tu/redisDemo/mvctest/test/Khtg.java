package com.tu.redisDemo.mvctest.test;

@FunctionalInterface
public interface Khtg {

    public static void hhh(){
        System.out.println("静态方法在任何地方都可以");
    }

    public void sayhello();

    default int dev(int i, int j){
        System.out.println("************");
        return i/j;
    }

    public static void main(String[] args) {
        Khtg.hhh();
        System.out.println("接口可以运行方法了");

        Khtg ktg = new Khtg() {
            @Override
            public void sayhello() {
                System.out.println("slllll");
            }
        };

        ktg.dev(5,6);
    }
}
