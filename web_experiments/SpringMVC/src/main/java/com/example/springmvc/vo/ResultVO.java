package com.example.springmvc.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultVO {

    private int code;
    private Map<String, Object> data;
    private String message;

    public static ResultVO success(Map<String, Object> data){
        return ResultVO.builder().code(200).data(data).build();
    }

    public static ResultVO error(int code,String message){
        return ResultVO.builder().code(code).message(message).build();
    }
}
