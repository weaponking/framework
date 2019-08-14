package com.framework.dubbo.test.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.framework.dubbo.test.common.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {

    @Reference
    private ProviderService providerService;

    public void test() {
        log.info("ConsumerService test : {}");
        providerService.test("123");
    }
}
