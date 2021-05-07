package com.example.springaop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyInterceptor {

    AuthorityType[] value() default AuthorityType.USER;
    String key() default "";
    enum AuthorityType{
        USER,ADMIN,SUPERADMIN
    }
}
