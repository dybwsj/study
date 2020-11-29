package com.self.study;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 不加RunWith会出现Dao层无法注入的问题
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class StudyApplicationTests {

    @Test
    void contextLoads() {
    }

}
