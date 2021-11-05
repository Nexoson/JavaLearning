package com.example.springcore.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className MyAopAspect
 * @date 2021/11/2 15:34
 * @desc 切面配置
 **/

@Aspect
@Component
@Slf4j
public class MyAopAspect {

    @Pointcut("execution(* com.example.springcore.service.TestServiceImpl.getInfo(..))")
    private void testPoint() {
    }

    @Before("testPoint()")
    private void testBefore() {
        log.info("before");
    }

    @Around("testPoint()")
    private void testAfter(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        Object proceed = null;

        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info("消耗时间: " + (end - start));
    }

    @After("testPoint()")
    private void testAround() {
        log.info("after");
    }


}
