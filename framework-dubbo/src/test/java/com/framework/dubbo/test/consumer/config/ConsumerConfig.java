package com.framework.dubbo.test.consumer.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "com.framework.dubbo.test.consumer.service")
@PropertySource("classpath:consumer.properties")
@ComponentScan("com.framework.dubbo.test.consumer.service")
public class ConsumerConfig {
}
