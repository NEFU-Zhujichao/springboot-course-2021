package com.example.springaop.aspect;

import com.example.springaop.annotation.MyInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MyAspect {
    @Pointcut("execution(* com.example.springaop.service.UserService.buy*(..))")
    public void pointcut(){}

    @Around("pointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.debug("{}",joinPoint.getSignature());
        log.debug("方法执行了{}毫秒",(end - start));
        return object;
    }

    @Around("@annotation(myInterceptor)")
    public Object checkType(ProceedingJoinPoint joinPoint, MyInterceptor myInterceptor) throws Throwable {
        Object obj = joinPoint.proceed();
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        if (ms.getMethod().getAnnotation(MyInterceptor.class) != null) {
            log.debug("{}",ms.getMethod().getAnnotation(MyInterceptor.class).value());
            return obj;
        }
        for (MyInterceptor.AuthorityType au : myInterceptor.value()) {
            log.debug("{}", au);
        }
        return obj;
    }
}
