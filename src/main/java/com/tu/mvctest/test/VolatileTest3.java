package com.tu.mvctest.test;

public class VolatileTest3 {

    static class Work {
          static boolean isShutDown = false;

                  void shutdown() {
                         isShutDown = true;
                         System.out.println("shutdown!");
                     }

                 static void doWork() {
                        while (!isShutDown) {
                                System.out.println("doWork");
                           }
                    }
     }
    public static void main(String[] args) {
        Work work = new Work();

        try {

//            new Thread(work::doWork).start();
            new Thread(Work::doWork).start();
//            new Thread(Work::shutdown).start();
//            new Thread(Work::doWork).start();
//            new Thread(Work::doWork).start();
//            new Thread(Work::doWork).start();
        }catch (Exception e){

        }
    }


}
