package com.framework.dubbo.test;

import com.framework.dubbo.test.consumer.service.ConsumerService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {

    @Before
    public void regiesterProvider() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:dubbo-provider.xml");
        context.start();
    }

    @Test
    public void test() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:dubbo-consumer.xml");
//        ConsumerService consumerService = context.getBean(ConsumerService.class);
//        consumerService.test();
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
