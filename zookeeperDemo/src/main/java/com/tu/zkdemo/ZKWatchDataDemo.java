package com.tu.zkdemo;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ZKWatchDataDemo {

    public final static String CONNECT_STRING = "192.168.36.128:2181";
    public final static int SESSION_TIME_OUT = 10 * 1000;
    public final static String ZNODE_PATH = "/znodepath";

    private String oldValue = "";

    private ZooKeeper zooKeeper;

    public ZKWatchDataDemo() throws IOException {
//        String connectString, int sessionTimeout, Watcher watcher
        zooKeeper = new ZooKeeper(CONNECT_STRING, SESSION_TIME_OUT,
//                new Watcher() {
//            public void process(WatchedEvent event) {
//
//                try {
//                    updateInfo();
//                } catch (KeeperException | InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
                null
        );

    }

    private void updateInfo() throws KeeperException, InterruptedException {

        if(null != zooKeeper.exists(ZNODE_PATH, false)){
            //final String path, Watcher watcher, Stat stat
            String result = "";
            if(oldValue.isEmpty()) {
                byte[] data = zooKeeper.getData(ZNODE_PATH, false, new Stat());
                result = new String(data);
            }else{
                byte[] data = zooKeeper.getData(ZNODE_PATH, new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {
                        try {
                            updateInfo();
                        } catch (KeeperException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Stat());
                result = new String(data);
            }

            System.out.println("更新后的值："+result);
        }else{
            System.out.println("该节点暂未有ZNODE节点");
        }

    }


    public void createZnode() throws KeeperException, InterruptedException {
//        final String path, byte data[], List<ACL > acl,
//                CreateMode createMode

        byte data_value[] = new String("watchone").getBytes();
        List<ACL > acl = ZooDefs.Ids.OPEN_ACL_UNSAFE;
        CreateMode createMode = CreateMode.EPHEMERAL;
        String s = zooKeeper.create(ZNODE_PATH, data_value, acl, createMode);

    }

    public void getDataValue() throws KeeperException, InterruptedException {
        //final String path, Watcher watcher, Stat stat
        byte[] data = zooKeeper.getData(ZNODE_PATH, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                try {
                    updateInfo();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, new Stat());
        String result = new String(data);
        oldValue = result;
        System.out.println("节点数据为："+result);
    }

    public void setDataValue(){
        //final String path, byte data[], int version
//        byte data_value[] = new String("setvalue").getBytes();
//        zooKeeper.setData(ZNODE_PATH, )

    }


    public void zkClose() throws InterruptedException {

        if(null != zooKeeper) zooKeeper.close();

    }


    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        ZKWatchDataDemo zkWatchDataDemo = new ZKWatchDataDemo();

        zkWatchDataDemo.createZnode();
        zkWatchDataDemo.getDataValue();

        TimeUnit.SECONDS.sleep(Long.MAX_VALUE);

//        zkWatchDataDemo.zkClose();

    }


}
