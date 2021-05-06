package com.example.mybatis4.mapper;

import com.example.mybatis4.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper{

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") Long id);

    @Select("select * from user")
    List<User> list();

    @Insert("insert into user(id, name, company) values (#{id},#{name},#{company})")
    int insert(User user);

    @Delete("delete from user where id = #{id}")
    int remove(Long id);

    @Update("update user set name = #{name},company = #{company} where id = #{id}")
    int update(User user);
}