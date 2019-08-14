package com.framework.hbase.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class TestCase1 {

    @Test
    public void test() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "localhost");
        conf.setInt("hbase.zookeeper.property.clientPort", 2181);
        conf.set("zookeeper.znode.parent", "/hbase");
        Connection connection = ConnectionFactory.createConnection(conf);
        Table table = connection.getTable(TableName.valueOf("test"));
        Scan scan = new Scan();
//        QualifierFilter qualifierFilter = new QualifierFilter(
//                CompareFilter.CompareOp.EQUAL, new RegexStringComparator("t2"));
//        scan.setFilter(qualifierFilter);
//        PageFilter filter = new PageFilter(1);
//        scan.setFilter(filter);
        scan.withStartRow("node41565256461745".getBytes(), true);
        scan.withStopRow("node41565256460745".getBytes(), true);
        scan.setReversed(true);
        ResultScanner results = table.getScanner(scan);
        for (Result rs : results) {
            System.out.println(Bytes.toString(rs.getRow()));
            for(Cell cell : rs.rawCells()) {
                log.info(Bytes.toString(CellUtil.cloneFamily(cell)));
                log.info(Bytes.toString(CellUtil.cloneQualifier(cell)));
                log.info(Bytes.toString(CellUtil.cloneValue(cell)));
            }
        }
    }
    ConcurrentHashMap map;
}
