package com.example.springaop.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AspectTest {

    @Autowired
    private UserService userService;

    @Test
    public void test_buyCar(){
        log.debug(userService.buyCar());
    }

    @Test
    public void test_buyCar2(){
        log.debug(userService.buyCar2());
    }

    @Test
    public void test_purchaseCar(){
        log.debug(userService.purchaseCar());
    }
}
