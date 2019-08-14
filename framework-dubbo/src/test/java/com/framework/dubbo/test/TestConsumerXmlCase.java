package com.framework.dubbo.test;

import com.framework.dubbo.test.consumer.service.ConsumerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConsumerXmlCase {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:dubbo-consumer.xml");
        ConsumerService consumerService = context.getBean(ConsumerService.class);
        consumerService.test("123");
    }

}
