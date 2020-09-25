package com.tu.mvctest.test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;


class ReferenceObj{

    private String key;
    private String value;

    public ReferenceObj(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

public class ReferenceDome {
    
    
    public static void softRef_Enough(){

        Object obj1 = new Object();

        SoftReference<Object> obj2 = new SoftReference<>(obj1);
        obj1 = null;

        System.gc();
        System.out.println(obj1);
        System.out.println(obj2.get());


    }


    public static void main(String[] args) {

//        ReferenceObj referenceObj = new ReferenceObj("key","value");
//
//        HashMap<String, ReferenceObj> map = new HashMap<>();
//
//        map.put(referenceObj.getKey(), referenceObj);
//
//        System.out.println(map.get(referenceObj.getKey()).getValue());
//        referenceObj.setKey(null);
//        System.out.println("=======================改变值");
//        referenceObj.setValue("改变值了");
//        System.out.println(map.get(referenceObj.getKey()).getValue());

//        Object obj = new Object();
//        WeakHashMap<String, Object> weakHashMap = new WeakHashMap<>();
//        String key = new String("key");
//        weakHashMap.put(key, obj);
//
//        System.out.println(weakHashMap);
//
//        System.out.println("==============================");
//        key = null;
//        System.gc();
//        System.out.println(weakHashMap);

        System.out.println("====================weak start====================");
        Object obj = new Object();
        WeakReference<Object> weakObj = new WeakReference<>(obj);

        System.out.println(weakObj.get());
        System.out.println("===========================");
        obj = null;
        System.gc();
        System.out.println(weakObj.get());
        System.out.println("==================== weak end =====================");
        System.out.println("=====================soft start====================");
        Object obj2 = new Object();
        SoftReference<Object> softObj = new SoftReference<>(obj2);
        System.out.println(softObj.get());
        System.out.println("===================================================");
        obj2 = null;
        System.gc();
        System.out.println(softObj.get());
        System.out.println("=====================soft end======================");


    }


}
