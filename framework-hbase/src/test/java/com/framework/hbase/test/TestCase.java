package com.framework.hbase.test;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class TestCase {

    @Test
    public void test() throws IOException {

        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "localhost");
        conf.setInt("hbase.zookeeper.property.clientPort", 2181);
        conf.set("zookeeper.znode.parent", "/hbase");
        Connection connection = ConnectionFactory.createConnection(conf);
        Table table = connection.getTable(TableName.valueOf("test"));

        String [] nodeIds = {"node1","node2","node3","node4"};
        Random random = new Random();
        String nodeId = "";
        byte [] cfs = "cf".getBytes();
        byte [] c1 = "t1".getBytes();
        byte [] c2 = "t2".getBytes();

        JSONObject object;
        List<Put> puts = new ArrayList<>();
        Put put;
        for(int i=0;i<10000000;i++) {
            nodeId = nodeIds[random.nextInt(4)].concat(Long.toString(System.currentTimeMillis()));
            put = new Put(Bytes.toBytes(nodeId));
            put.addColumn(cfs, c1, Integer.toString(i).getBytes());
            object = new JSONObject();
            object.put("id",i);
            object.put("name", "key"+i);
            object.put("time", System.currentTimeMillis());
            put.addColumn(cfs, c2, object.toJSONString().getBytes());
            puts.add(put);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(puts.size() % 1000 == 0) {
                table.put(puts);
                puts.clear();
            }
        }

        if(CollectionUtils.isNotEmpty(puts)) {
            table.put(puts);
            puts.clear();
        }

        table.close();
    }
}
/**
 * Spring for Apache Hadoop
 * 2.5.0.RELEASE (不支持3版本)
 * Spring for Apache Hadoop is built and tested with JDK 7, Spring Framework 4.3 and is by default built against Apache Hadoop 2.7.3.
 *
 * Spring for Apache Hadoop supports the following versions and distributions:
 *
 * Apache Hadoop 2.7.x
 * Apache Hadoop 2.6.x
 * Cloudera CDH 5.x
 * Hortonworks Data Platform 2.x
 *
 */