package com.framework.test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
@Slf4j
public class BeanServiceImpl implements InitializingBean, DisposableBean {

    @PostConstruct
    public void initConstruct() {
        log.info("BeanServiceImpl PostConstruct");
    }

    public void doService(String arg) {
      log.info("arg : {}", arg);
    }


    public void afterPropertiesSet() throws Exception {
        log.info("BeanServiceImpl InitializingBean afterPropertiesSet");
    }

    public void destroy() throws Exception {
        log.info("BeanServiceImpl DisposableBean destroy");
    }
}
