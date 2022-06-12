package com.learn.spring.schedulling;

import org.springframework.stereotype.Component;

@Component
public class MethodName {

    public String getCurrentMethodName() {
        return new Throwable()
            .getStackTrace()[0]
            .getMethodName();
    }
}
