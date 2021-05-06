package com.example.mybatis4.mapper;

import com.example.mybatis4.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(value = false)
@Slf4j
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test_addUser(){
        User user = new User();
        user.setId(1L);
        user.setName("Chao");
        user.setCompany("NEFU");
        userMapper.insert(user);
    }

    @Test
    public void test_getUserById(){
        User user = userMapper.getUserById(2L);
        log.debug("{}/{}/{}",
                user.getName(),
                user.getCompany(),
                user.getCreateTime());
    }

    @Test
    public void test_listUser(){
        userMapper.list().forEach(user -> {
            log.debug("{}/{}/{}",
                    user.getName(),
                    user.getCompany(),
                    user.getCreateTime());
        });
    }

    @Test
    public void test_deleteUser(){
        int i = userMapper.remove(1L);
        log.debug(String.valueOf(i));
    }

    @Test
    public void test_updateUser(){
        User user = userMapper.getUserById(2L);
        user.setName("Zhang");
        user.setCompany("QiqiHaer");
        int i = userMapper.update(user);
        log.debug(String.valueOf(i));
    }
}
