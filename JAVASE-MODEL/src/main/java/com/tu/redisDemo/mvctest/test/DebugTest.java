package com.tu.redisDemo.mvctest.test;

import java.util.ArrayList;
import java.util.List;

public class DebugTest {


    public List<String> createList(){

        List<String> list = new ArrayList<String>();

        list.add("aa");
        list.add("bb");
        list.add("cc");

        return list;
    }

    public static void main(String[] args){

        DebugTest test = new DebugTest();

        List<String> list = test.createList();

        for (String s : list) {

            System.out.println(s);
        }

        System.out.println("断点终点");


    }


}
