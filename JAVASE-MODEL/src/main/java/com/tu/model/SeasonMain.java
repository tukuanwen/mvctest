package com.tu.model;

/**
 * 定义枚举类，例如：四季的春夏秋冬
 */

public class SeasonMain{

    public static void main(String[] args) {

//        Season a = Season.chun;
//
//        String cname = Season.chun.getName();
//
//        System.out.println(a);
//        System.out.println("春天名字："+cname);

        SeasonEnum chun = SeasonEnum.chun;
        System.out.println(chun.toString());


    }
}

//枚举类的方式实现
class Season {

    private final String name;

    private final String desc;

    private Season(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public static final Season chun = new Season("春天", "春暖花开");
    public static final Season xia = new Season("夏天", "酷热难耐");
    public static final Season qiu = new Season("秋天", "秋高气爽");
    public static final Season dong = new Season("冬天", "冰天雪地");

    //====================================以下均是get\set\toString类的方法===================================

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "SeasonMain{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

/**
 * 使用enum关键字方式
 * 常用方法：values,valueof，toString
 * enum 实现接口
 */

enum SeasonEnum implements info{

    chun("春天", "春暖花开"){
        public void show() {
        }},
    xia("夏天", "酷热难耐"){
        public void show() {
        }},
    qiu("秋天", "秋高气爽"){
        public void show() {
        }},
    dong("冬天", "冰天雪地"){
        public void show() {
        }};

    private String name;
    private String desc;
    private SeasonEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }


//
//    public String getName() {
//        return name;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    @Override
//    public String toString() {
//        return "SeasonEnum{" +
//                "name='" + name + '\'' +
//                ", desc='" + desc + '\'' +
//                '}';
//    }
}


interface info{

    void show();

}