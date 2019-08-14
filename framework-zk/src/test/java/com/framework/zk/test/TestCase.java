package com.framework.zk.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import java.util.Arrays;

@Slf4j
public class TestCase {


    public static void main(String[] args) {

        String zkServers = "localhost:2181";
        String nodePath = "/t1";

        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 5);
        CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString(zkServers)  // zk server ip
            .sessionTimeoutMs(10000)
            .retryPolicy(retryPolicy)
            // addauth digest admin:admin
            .authorization("digest","admin:admin".getBytes())
            //zk 根节点 /testspace
            .namespace("testspace")
            .build();
        client.start();

        log.info("zk client state : {}", client.getState().toString());

        Stat statExist = null;
        try {
            statExist = client.checkExists().forPath(nodePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(statExist == null) {
                ACL acl = new ACL(ZooDefs.Perms.ALL, new Id("auth","admin:admin"));
                client.create().creatingParentsIfNeeded()
                    .withMode(CreateMode.PERSISTENT)
                    //.withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE) //acl world
                    .withACL(Arrays.asList(acl))
                    .forPath(nodePath, "tdata".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            client.setData()
                    //.withVersion(0)
                    .forPath("/t1", "tdata1".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            byte [] data = client.getData().forPath("/t1");
            log.info("data:{}", new String(data));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            client.delete()
                .guaranteed()  // 删除失败 继续删除 直到成功
                .deletingChildrenIfNeeded()
                //.withVersion(0)
                .forPath(nodePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        client.close();
    }
}
