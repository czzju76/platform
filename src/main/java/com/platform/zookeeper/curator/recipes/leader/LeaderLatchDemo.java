package com.platform.zookeeper.curator.recipes.leader;

import com.google.common.collect.Lists;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;
import org.apache.curator.utils.CloseableUtils;

import java.util.List;

public class LeaderLatchDemo  {
    protected static String PATH = "/francis/leader";
    private static final int CLIENT_QTY = 10;


    public static void main(String[] args) throws Exception {
        List<CuratorFramework> clients = Lists.newArrayList();
        List<LeaderLatch> examples = Lists.newArrayList();
        TestingServer server=new TestingServer();


        try {
            for (int i = 0; i < CLIENT_QTY; i++) {
                CuratorFramework client
                        = CuratorFrameworkFactory.newClient(server.getConnectString(), new ExponentialBackoffRetry(20000, 3));
                clients.add(client);
                final LeaderLatch latch = new LeaderLatch(client, PATH, "Client #" + i);
                latch.addListener(new LeaderLatchListener() {

                    public void isLeader() {

                        System.out.println("I am Leader，id："+ latch.getId());
                    }

                    public void notLeader() {
                        System.out.println("I am not Leader");
                    }
                });
                examples.add(latch);
                client.start();
                latch.start();
            }
            Thread.sleep(10000);
            LeaderLatch currentLeader = null;
            for (LeaderLatch latch : examples) {
                if (latch.hasLeadership()) {
                    currentLeader = latch;
                }
            }
            System.out.println("current leader is " + currentLeader.getId());
            System.out.println("release the leader " + currentLeader.getId());
            currentLeader.close();

            Thread.sleep(5000);

            for (LeaderLatch latch : examples) {
                if (latch.hasLeadership()) {
                    currentLeader = latch;
                }
            }
            System.out.println("current leader is " + currentLeader.getId());
            System.out.println("release the leader " + currentLeader.getId());
        } finally {
            for (LeaderLatch latch : examples) {
                if (LeaderLatch.State.CLOSED != latch.getState())
                    CloseableUtils.closeQuietly(latch);
            }
            for (CuratorFramework client : clients) {
                CloseableUtils.closeQuietly(client);
            }
        }
    }
}

