package com.tu.mvctest.test;

import java.util.ArrayList;
import java.util.List;

class User1{

    private int id ;
    private String name;
    private List<User2> user2 = null;

    public User1(){
        this.id = Integer.MAX_VALUE;
        this.name = String.valueOf(Integer.MAX_VALUE);
        this.user2 = new ArrayList<>();
        User1 user1 = new User1();
    }

    public void doPrint(){
        System.out.println(user2);
    }
}

class User2{

    private int id ;
    private String name;
    private List<User1> user1 = null;

    public User2(){
        this.id = Integer.MAX_VALUE;
        this.name = String.valueOf(Integer.MAX_VALUE);
        this.user1 = new ArrayList<>();
    }

    public void doPrint(){
        System.out.println(user1);
    }
}

public class StackOverFlowErrorDemo {



    public static void main(String[] args) {

        User1 user1 = new User1();

        try {
            Class clazz = Class.forName("com.tu.mvctest.test.User1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
