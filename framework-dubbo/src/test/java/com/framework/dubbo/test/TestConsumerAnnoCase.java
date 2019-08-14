package com.framework.dubbo.test;

import com.framework.dubbo.test.consumer.config.ConsumerConfig;
import com.framework.dubbo.test.consumer.service.ConsumerService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConsumerAnnoCase {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfig.class);
        ConsumerService consumerService = context.getBean(ConsumerService.class);
        consumerService.test("123");
    }
}
