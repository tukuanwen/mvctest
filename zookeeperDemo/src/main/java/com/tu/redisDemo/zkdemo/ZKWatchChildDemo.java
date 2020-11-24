package com.tu.redisDemo.zkdemo;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ZKWatchChildDemo {

    public final static String CONNECT_STRING = "192.168.36.128:2181";
    public final static int SESSION_TIME_OUT = 10 * 1000;
    public final static String ZNOTE_PATH = "/childpath03";


    private ZooKeeper zooKeeper;

    public ZKWatchChildDemo() throws IOException {
        //String connectString, int sessionTimeout, Watcher watcher
        zooKeeper = new ZooKeeper(CONNECT_STRING, SESSION_TIME_OUT, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if(event.getType().equals(Event.EventType.NodeChildrenChanged) && ZNOTE_PATH.equals(event.getPath())){
                    tigerChildZnode(ZNOTE_PATH);
                }else{
                    tigerChildZnode(ZNOTE_PATH);
                }
            }
        });
    }

    private void tigerChildZnode(String childPath){

        //final String path, Watcher watcher
        List<String> children = null;
        try {
            if(null != zooKeeper.exists(childPath, false)) {

                children = zooKeeper.getChildren(childPath, true);

                for (String child : children) {

                    System.out.println("监控的目录变化为：" + child);
                }
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        ZKWatchChildDemo zkWatchChildDemo = new ZKWatchChildDemo();

        TimeUnit.SECONDS.sleep(Long.MAX_VALUE);

    }
}
