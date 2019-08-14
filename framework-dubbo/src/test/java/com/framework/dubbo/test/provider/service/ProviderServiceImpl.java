package com.framework.dubbo.test.provider.service;

import com.framework.dubbo.test.common.ProviderService;

public class ProviderServiceImpl implements ProviderService {

    public void test(String arg) {
        System.out.println("provider service : " +arg);
    }
}
