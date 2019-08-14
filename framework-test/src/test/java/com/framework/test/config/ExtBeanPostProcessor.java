package com.framework.test.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExtBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("BeanPostProcessor : {}", beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("BeanPostProcessor : {}", beanName);
        return bean;
    }
}
/**
 * spring init bean 顺序
 * @PostConstruct
 * @InitializingBean
 * BeanPostProcessor
 */