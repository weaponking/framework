package com.framework.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath*:app-config.xml")
@Slf4j
public class TestCase {

    @Test
    public void test() {
        log.info("test");
    }
}
