package com.framework.dubbo.test;

import com.framework.dubbo.test.consumer.service.ConsumerXmlService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConsumerXmlCase {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:dubbo-consumer.xml");
        ConsumerXmlService consumerService = context.getBean(ConsumerXmlService.class);
        consumerService.test("123");
    }

}
