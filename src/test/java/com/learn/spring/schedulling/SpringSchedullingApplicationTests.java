package com.learn.spring.schedulling;

import com.learn.spring.schedulling.service.FileReaderService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringSchedullingApplicationTests {

    @Autowired
    private FileReaderService fileReaderService;
    private static final String ANIMAL_NAME = "Animal Name is contains in the final string";
    @Test
    @Disabled
    void contextLoads() {
        if(ANIMAL_NAME.contains("Animal name")) {
            System.out.println(" Animal Name is contains in the final string");
        }
        else {
            System.out.println(" Animal Name is not contains in the final string");
        }
    }

    @Test
    void fileReadTest() throws IOException {
        fileReaderService.readFileFromProperty();
    }

    @Test
    @Disabled
    public void whenResourceAsStream_thenReadSuccessful()
        throws IOException {
        InputStream resource = new ClassPathResource(
            "info.csv").getInputStream();
        try ( BufferedReader reader = new BufferedReader(
            new InputStreamReader(resource)) ) {
            String employees = reader.lines()
                .collect(Collectors.joining("\n"));

            assertEquals("Joe Employee,Jan Employee,James T. Employee", employees);
        }
    }

}
