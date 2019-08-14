package com.framework.test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class BeanServiceImpl1 {

    @PostConstruct
    public void initConstruct() {
        log.info("BeanServiceImpl11 PostConstruct");
    }

    public void doService(String arg) {
      log.info("arg : {}", arg);
    }

}
