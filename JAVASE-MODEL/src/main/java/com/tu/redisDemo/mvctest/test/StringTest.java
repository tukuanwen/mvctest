package com.tu.redisDemo.mvctest.test;

import java.util.ArrayList;
import java.util.List;


final class FinalTest{

    private final int num;

    public FinalTest(int init){
        this.num = init;
    }

    public int getNum(){
        return num;
    }

}

public class StringTest {

    public void update(FinalTest finalTest){

        finalTest = new FinalTest(20);
        System.out.println("方法内修改后的值："+finalTest.getNum());

    }

    public void update2(String str){
        str = new String("土豆");
        System.out.println("方法内值："+str);
    }

    public static void doOther() {
        //        List<String> list = new LinkedList<>();
//
//        list.add("");

//        System.out.println(Integer.MAX_VALUE);

//        FinalTest finalTest = new FinalTest(10);
//        StringTest stest = new StringTest();
//        System.out.println("修改前："+finalTest.getNum());
//        stest.update(finalTest);
//        System.out.println("方法外值："+finalTest.getNum());

        StringBuffer sb = new StringBuffer(5);

        sb.append("dasfasdfasasdfasdfadsfasdfadsfads");

        StringBuilder sbr = new StringBuilder(4);
        sbr.append("iskkssssssssssadsfadsfasdfasdf");

        System.out.println(sb);
        System.out.println(sbr);

//        String str = new String("沈冲");
//        System.out.println("修改前："+str);
//        stest.update2(str);
//        System.out.println("修改后："+str);
    }

    public static void main(String[] args) {

//        String str = "5.0";
//        byte[] b = new byte[1000];
//        b = str.getBytes();
//        String objstr = new String(b);
//        System.out.println(b.toString());
//        System.out.println(objstr);

//        String str = new String("Object");
//
//        Object obj = new Object();


//        CloneSource cs = new CloneSource("AA");
//
//        System.out.println(cs.getcName());
//        CloneSource cs2 = null;
//        try {
//            cs2 = cs.clone();
//            cs2.setcName("BB");
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(cs.getcName());
//        System.out.println(cs2.getcName());

//        double s = 2.3;
//
//        int i = 3;
//
//        i += s;
//
//        System.out.println(i);
//
//        Object obj = new Object();
//
//        boolean t = obj instanceof Short;
//
//        System.out.println(obj.getClass());


        System.out.println(0.3 == 0.3);
        System.out.println(3*0.1 == 0.3);

        Runtime r = Runtime.getRuntime();
        System.out.println(r.freeMemory()/1024/1024);
        System.out.println(r.maxMemory()/1024/1024);
        System.out.println(r.totalMemory()/1024/1024);
//        System.out.println();

        List list = new ArrayList();

    }




}


class CloneSource implements Cloneable{

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    private String cName;

    public CloneSource(String cName){
        this.cName = cName;
    }

    @Override
    protected CloneSource clone() throws CloneNotSupportedException {
        return (CloneSource)super.clone();
    }

}