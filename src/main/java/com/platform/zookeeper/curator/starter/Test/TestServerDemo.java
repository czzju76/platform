package com.platform.zookeeper.curator.starter.Test;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;
import org.apache.curator.utils.CloseableUtils;

public class TestServerDemo {

    public static void main(String[] args) throws Exception {
        TestingServer server = new TestingServer();
        CuratorFramework client = CuratorFrameworkFactory.newClient(server.getConnectString(),
                new ExponentialBackoffRetry(1000, 3));
        client.getConnectionStateListenable().addListener(new ConnectionStateListener()
            {
                public void stateChanged(CuratorFramework client, ConnectionState newState)
                {
                    System.out.println("连接状态:" + newState.name());
                }
            });
        client.start();
        System.out.println(client.getChildren().forPath("/"));
        client.create().forPath("/test");
        System.out.println(client.getChildren().forPath("/"));
        CloseableUtils.closeQuietly(client);
        CloseableUtils.closeQuietly(server);
        System.out.println("OK!");

        CuratorFramework curatorFramework= CuratorFrameworkFactory.builder().connectString(server.getConnectString()).
                retryPolicy(new ExponentialBackoffRetry(1000,3)).build();
    }
}
