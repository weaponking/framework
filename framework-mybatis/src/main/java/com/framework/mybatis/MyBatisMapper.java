package com.framework.mybatis;

import org.springframework.stereotype.Component;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * MybatisMapper注解
 * 支持org.mybatis.spring.mapper.MapperScannerConfigurer扫描
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface MyBatisMapper {

}