package com.example.springaop.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String buyCar(){
        return "buyCar()";
    }

    public String buyCar2(){
        return "buyCar2()";
    }

    public String purchaseCar(){
        return "purchaseCar()";
    }
}
