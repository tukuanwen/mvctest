package com.tu.mvctest.test.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 测试反射实例
 */
public class ReflectClass {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        //方法一
//        firstMethod();
        //方法二
//        twoMethod();

        //反射私有构造方法
//        privateInitMethod();
        //反射私有属性
//        reflectPrivateField();
        //反射私有方法
//        reflectPrivateMethod();

//        String[] arrStr = { "a","b","c","d","e"};
//        List<String> list = Arrays.asList(arrStr);
          List ll = new ArrayList();
//        for (int i = 0; i < 2; i++) {
//            list.set(i, "hu"+i);
//        }
//        System.out.println(list);

//        int max = Math.max(10, 3);

//        System.out.println(max);

//        int sum = 10;
//        System.out.println(sum>>2);
//        System.out.println(sum+(sum>>4));


//        System.out.println(Integer.MAX_VALUE);

        LinkedList<String> list = new LinkedList<String>();
        list.add("语文: 1");
        list.add("数学: 2");
        list.add("英语: 3");
        list.add("体育: 4");
        list.add("生物: 5");
        list.add("政治: 6");

        int length = list.size();
        for (int i = 0; i < length; i++) {

            System.out.println(list.get(i));

        }



    }

    //反射私有构造方法
    public static void reflectPrivateMethod(){

        try {
            Class<?> aClass = Class.forName("com.tu.mvctest.test.Reflect.Booktkw");
            //调用的私有方法
            Method declaredMethod = aClass.getDeclaredMethod("declaredMethod", int.class);
            //设置强制反射
            declaredMethod.setAccessible(true);
            Object o = aClass.newInstance();

            Object invoke = declaredMethod.invoke(o, 0);

            System.out.println(invoke);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //反射私有属性
    public static void reflectPrivateField(){

        try {
            Class<?> aClass = Class.forName("com.tu.mvctest.test.Reflect.Booktkw");
            Object o = aClass.newInstance();
            //通过属性名获取私有属性
            Field tag = aClass.getDeclaredField("TAG");
            //设置强制反射
            tag.setAccessible(true);
//            tag.set("bookName","第一本数");
            Object o1 = tag.get(o);
            System.out.println(o1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    //通过私有的构造方法，创建对象
    public static void privateInitMethod() throws InstantiationException, IllegalAccessException {
        try {
            Class<?> clazz = Class.forName("com.tu.mvctest.test.Reflect.Booktkw");

            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(String.class, String.class);
            //私有构造方法时，必须设置暴力反射
            declaredConstructor.setAccessible(true);

            Object o = declaredConstructor.newInstance("李四", "两本好书");

            Booktkw booktkw = (Booktkw)o;

            System.out.println(booktkw.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //方法二：第二种构造反射方法
    public static void twoMethod() throws InstantiationException, IllegalAccessException {
        Class<?> clazz = Booktkw.class;

        Booktkw booktkw = (Booktkw) clazz.newInstance();

        booktkw.setAuthor("张三");
        booktkw.setBookName("第二本书");

        System.out.println(booktkw.toString());
    }


    //方法一：使用Class.forName()
    public static void firstMethod() throws InstantiationException, IllegalAccessException {

        try {

            Class<?> clazz = Class.forName("com.tu.mvctest.test.Reflect.Booktkw");

            Booktkw obj = (Booktkw)clazz.newInstance();

            obj.setAuthor("shenchong");
            obj.setBookName("一本好书");

            System.out.println(obj.toString());

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
    }
}
