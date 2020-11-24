package com.tu.redisDemo.zkdemo;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

public class zkMain {

    public static String CONNECTION_STRING = "192.168.36.128:2181";
    public static int SESSION_OUT_TIME = 10*1000;



    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

        ZooKeeper zooKeeper = new ZooKeeper(CONNECTION_STRING, SESSION_OUT_TIME, null);

        String path = "/javaznote";
        byte data[] = new String("tkw").getBytes();
        List<ACL> acl = ZooDefs.Ids.OPEN_ACL_UNSAFE;
        CreateMode createMode = CreateMode.PERSISTENT;


        String s = zooKeeper.create(path, data, acl, createMode);
        System.out.println("创建zookeeper的成功，返回的数据为："+s);

        byte[] data1 = zooKeeper.getData(path, false, new Stat());
        String result = new String(data1);

        System.out.println("从zookeeper中取出的值："+result);

        zooKeeper.close();

    }

}
