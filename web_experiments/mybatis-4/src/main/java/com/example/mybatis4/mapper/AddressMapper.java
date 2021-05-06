package com.example.mybatis4.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis4.dto.UserDTO;
import com.example.mybatis4.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface AddressMapper extends BaseMapper<Address> {

    UserDTO getAddressesByUserId(long id);
}
