package com.example.jpahibernate;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaHibernateApplicationTests {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    void contextLoads() {
        logger.info("Test cases for find by");
    }

}
