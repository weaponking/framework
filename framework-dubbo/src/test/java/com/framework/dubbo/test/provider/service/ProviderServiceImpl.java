package com.framework.dubbo.test.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.framework.dubbo.test.common.ProviderService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProviderServiceImpl implements ProviderService {

    public void test(String arg) {
        log.info("provider service : {}", arg);
    }
}
