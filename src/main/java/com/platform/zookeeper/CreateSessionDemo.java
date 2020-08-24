package com.platform.zookeeper;

import org.apache.curator.test.TestingServer;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Title: CreateSessionDemo
 * @Description:
 * @Auther:Lyon Chen
 * @Version: 1.0
 * @create 2020/8/14 11:26
 */
public class CreateSessionDemo {

   // private final static String CONNECTSTRING="192.168.11.129:2181,192.168.11.134:2181," +
   //         "192.168.11.135:2181,192.168.11.136:2181";
    private static CountDownLatch countDownLatch=new CountDownLatch(1);
    public static void main(String[] args) throws IOException, InterruptedException, Exception {
        TestingServer server = new TestingServer();
        ZooKeeper zooKeeper=new ZooKeeper(server.getConnectString(), 5000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                //如果当前的连接状态是连接成功的，那么通过计数器去控制
                if(watchedEvent.getState()==Event.KeeperState.SyncConnected){
                    countDownLatch.countDown();
                    System.out.println(watchedEvent.getState());
                }
            }
        });
        countDownLatch.await();
        System.out.println(zooKeeper.getState());
    }
}
