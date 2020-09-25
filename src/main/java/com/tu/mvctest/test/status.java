package com.tu.mvctest.test;

public class status {

    public static final int i = 9;
    private String ss;



    public static void main(String[] args) {

        status a = new status();
        a.doChangeName("", "");

    }

    public void doChangeName(String name, String text){
        System.out.println(name);
    }
}
