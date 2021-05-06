package com.example.mybatis4.dto;

import com.example.mybatis4.entity.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String company;
    private List<Address> addresses;
}
