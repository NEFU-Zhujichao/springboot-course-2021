package com.example.mybatis4.mapper;

import com.example.mybatis4.entity.Address;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(value = false)
@Slf4j
public class AddressMapperTest {

    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void test_addAddress(){
        Address address = Address.builder().id(1L).detail("哈尔滨").userId(2L).build();
        Address address2 = Address.builder().id(2L).detail("内蒙古").userId(2L).build();
        addressMapper.insert(address);
        addressMapper.insert(address2);
    }

    @Test
    public void test_getAddressesByUserId(){
        addressMapper.getAddressesByUserId(2L).getAddresses().forEach(a -> {
            log.debug("{}/{}/{}",a.getId(),a.getDetail(),a.getUserId());
        });
    }
}
