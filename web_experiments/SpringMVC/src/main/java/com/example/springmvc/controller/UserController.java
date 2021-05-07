package com.example.springmvc.controller;

import com.example.springmvc.dto.User;
import com.example.springmvc.vo.ResultVO;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {
    @GetMapping("/index")
    public ResultVO index(){
        return ResultVO.success(Map.of("msg","Hello World"));
    }

    @GetMapping("/users")
    public ResultVO getUsers(){
        return ResultVO.success(Map.of("users",users));
    }

    @PostMapping("/users")
    public ResultVO postUsers(@RequestBody User user){
        log.debug("{}/{}/{}",user.getId(),user.getUsername(),user.getPassword());
        return ResultVO.success(Map.of("users",addUser(user)));
    }


    @GetMapping("/users/{uid}")
    public ResultVO getUser(@PathVariable("uid") Long id){
        try {
            return ResultVO.success(Map.of("users",getUserById(id)));
        } catch (Exception e) {
            return ResultVO.error(404,e.getMessage());
        }
    }

    private List<User> users = listUsers();

    private List<User> listUsers(){
        ArrayList<User> users = new ArrayList<>();
        User user1 = User.builder().id(1L).username("chao").password("123456").build();
        User user2 = User.builder().id(2L).username("zhang").password("123456").build();
        User user3 = User.builder().id(3L).username("qi").password("123456").build();
        users.add(user1); users.add(user2); users.add(user3);
        return users;
    }

    private User getUserById(Long id) throws Exception {
        User user = users.stream().
                filter(u -> u.getId() == id).
                findFirst().orElseThrow(() -> new RuntimeException("没有ID为"+id+"的用户"));
        return user;
    }

    private List<User> addUser(User user){
        users.add(user);
        return users;
    }
}
