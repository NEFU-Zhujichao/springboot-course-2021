package com.example.springmvc.exception;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class MyException extends RuntimeException{

    private int code;
    private String message;

    public MyException(int code,String message){
        super(message);
        this.code = code;
    }
}
