package com.example.prj.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect // AOP로 동작
@Component // spring 에서 bean으로 관리
public class ParameterAop {

    @Pointcut("execution(* com.example.prj.controller..*.*(..))") // 해당 디렉토리 아래 모든 메소드에 대해서 실행시키겠다.
    private void cut(){

    }
    
    @Before("cut()") // cut이 해당되는 메소드가 시작될때 before를 실행하겠다.
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());
    }
    
    @AfterReturning(value = "cut()", returning = "returnObj") // 반환값을 알기위해서
    public void afterReturn(JoinPoint joinPoint, Object returnObj){ // 해당 리턴값이 오브젝트로 반환됨
        System.out.println("returnObj" + returnObj);
    }
}
