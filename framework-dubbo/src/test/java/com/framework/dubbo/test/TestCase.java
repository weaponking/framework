package com.framework.dubbo.test;

import com.framework.dubbo.test.common.ProviderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:dubbo-provider.xml");
        ProviderService providerService = context.getBean(ProviderService.class);
        providerService.test("123");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
