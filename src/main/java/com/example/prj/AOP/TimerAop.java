package com.example.prj.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

@Aspect
@Component
public class TimerAop {

    @Pointcut("execution(* com.example.prj.controller..*.*(..))") // 해당 디렉토리 아래 모든 메소드에 대해서 실행시키겠다.
    private void cut(){

    }

    @Pointcut("@annotation(com.example.prj.annotation.Timer)")
    private void enableTimer(){

    }

    @Around("cut() && enableTimer()") // point컷이 지정된 메소드를 가진 함수인 cut을 around때 실행하겠다.
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();
        System.out.println("total time : "+ stopWatch.getTotalTimeSeconds());
    }


}
