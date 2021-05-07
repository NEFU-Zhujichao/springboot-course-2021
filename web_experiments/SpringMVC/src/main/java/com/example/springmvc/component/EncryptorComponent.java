package com.example.springmvc.component;

import com.example.springmvc.exception.MyException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EncryptorComponent{

    @Autowired
    private ObjectMapper objectMapper;
    @Value("${my.secretKey}")
    private String secretKey;
    @Value("${my.salt}")
    private String salt;
    @Autowired
    private TextEncryptor textEncryptor;

    @Bean
    public TextEncryptor getTextEncryptor(){
        return Encryptors.text(secretKey,salt);
    }

    public String encrypt(Map<String,Object> payload){
        try {
            String json = objectMapper.writeValueAsString(payload);
            return textEncryptor.encrypt(json);
        } catch (JsonProcessingException e) {
            throw new MyException(500,"服务器异常");
        }
    }

    public Map<String,Object> decrypt(String token){
        try {
            String json = textEncryptor.decrypt(token);
            return objectMapper.readValue(json,Map.class);
        } catch (JsonProcessingException e) {
            throw new MyException(403,"无权限");
        }
    }
}
