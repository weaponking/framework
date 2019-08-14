package com.framework.dubbo.test.consumer.service;

import com.framework.dubbo.test.common.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerXmlService {

    @Autowired
    private ProviderService providerService;

    public void test(String arg) {
        System.out.println("ConsumerService test ");
        providerService.test(arg);
    }
}
