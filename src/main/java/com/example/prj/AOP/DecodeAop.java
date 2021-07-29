package com.example.prj.AOP;

import com.example.prj.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.prj.controller..*.*(..))") // 해당 디렉토리 아래 모든 메소드에 대해서 실행시키겠다.
    private void cut(){

    }

    @Pointcut("@annotation(com.example.prj.annotation.Decode)")
    private void enableDecode(){

    }

    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args = joinPoint.getArgs();
        for(Object arg : args){
            if(arg instanceof User){
                User user = User.class.cast(arg);
                String base64Email = user.getEmail();
                String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8");
                user.setEmail(email);
            }
        }
    }
    // 이런식으로 request 즉 실행되는 메소드에 대해서 이렇게 암호화가 가능하다.
    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint,Object returnObj){
        if(returnObj instanceof User){
            User user = (User)returnObj;
            String email = user.getEmail();
            String base64Email = new String(Base64.getEncoder().encodeToString(email.getBytes()));
            user.setEmail(base64Email);
        }
    }

}
