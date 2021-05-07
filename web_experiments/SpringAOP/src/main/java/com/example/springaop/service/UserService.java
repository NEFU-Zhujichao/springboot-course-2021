package com.example.springaop.service;

import com.example.springaop.annotation.MyInterceptor;
import org.springframework.stereotype.Service;

@Service
@MyInterceptor
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

    @MyInterceptor(value = MyInterceptor.AuthorityType.ADMIN)
    public void addUser(){}
}
