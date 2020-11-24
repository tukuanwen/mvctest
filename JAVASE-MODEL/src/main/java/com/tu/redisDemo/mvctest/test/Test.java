package com.tu.redisDemo.mvctest.test;

import java.util.regex.Pattern;

public class Test {

    private static Pattern hhmm = Pattern.compile("(0\\d{1}|1\\d{1}|2[0-3]):([0-5]\\d{1})");

    public static void main(String[] args) {


        String content = "00:00";

        System.out.println(hhmm.matcher(content).matches());





    }

}
