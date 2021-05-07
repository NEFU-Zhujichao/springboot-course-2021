package com.example.springmvc.controller;

import com.example.springmvc.component.EncryptorComponent;
import com.example.springmvc.dto.User;
import com.example.springmvc.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/interceptor")
@Slf4j
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EncryptorComponent encryptorComponent;

    private Map<String, User> map = new HashMap<>();

    /*private Map listUsers(){
        Map<String, User> map = new HashMap<>(){};
        // $2a$10$8BoOrie1Z5bD59a7v9aGoeIcbgKYqmJrSfWw47Qr4duKVLj33NVQi
        User user = User.builder().id(3L).username("zhujichao").password("$2a$10$8BoOrie1Z5bD59a7v9aGoeIcbgKYqmJrSfWw47Qr4duKVLj33NVQi").build();
        map.put(user.getUsername(),user);
        return map;
    }*/

    @GetMapping("/index")
    public Map index(@RequestAttribute("username") String username){
        log.debug("->");
        log.debug(username);
        return Map.of("username",username);
    }

    @PostMapping("/register")
    public Map register(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        map.put(user.getUsername(),user);
        log.debug("{}",user);
        return map;
    }

    @PostMapping("/login")
    public Map login(@RequestBody User user, HttpServletResponse response){
        if (!map.containsKey(user.getUsername()) || !passwordEncoder.matches(user.getPassword(),map.get(user.getUsername()).getPassword())){
            throw new MyException(401,"用户名或密码错误");
        }
        response.addHeader("token",encryptorComponent.encrypt(Map.of("username",user.getUsername())));
        return Map.of();
    }
}
