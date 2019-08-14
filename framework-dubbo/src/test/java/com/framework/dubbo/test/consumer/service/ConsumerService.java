package com.framework.dubbo.test.consumer.service;

import com.framework.dubbo.test.common.ProviderService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService{

    @Reference
    private ProviderService providerService;

    public void test(String arg) {
        System.out.println("ConsumerService test ");
        providerService.test(arg);
    }
}
