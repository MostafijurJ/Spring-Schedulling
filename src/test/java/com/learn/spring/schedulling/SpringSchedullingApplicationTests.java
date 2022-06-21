package com.learn.spring.schedulling;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSchedullingApplicationTests {

    private static final String ANIMAL_NAME = "Animal Name is contains in the final string";
    @Test
    void contextLoads() {
        if(ANIMAL_NAME.contains("Animal name")) {
            System.out.println(" Animal Name is contains in the final string");
        }
        else {
            System.out.println(" Animal Name is not contains in the final string");
        }
    }

}
