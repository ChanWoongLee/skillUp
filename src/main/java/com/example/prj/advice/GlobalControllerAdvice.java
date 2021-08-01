package com.example.prj.advice;

import com.example.prj.eceception.AuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 전체 예외를 받는 클래스!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class GlobalControllerAdvice {

//    @ExceptionHandler(value = Exception.class) // value 값에는 어떤 예외클래스가 왔을때 받아서 처리할것이냐
//    // 이 함수를 컨트롤러 클래스에 옮기면 그 컨트롤러에서만 이런 예외를 잡아서 처리해준다.
//    // but RestControllerAdvice에 basePackageClasses 를 지정해주면 동일한 효과를 발생
//    public ResponseEntity exception(Exception e) {
//
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
//    }

    @ExceptionHandler(value = AuthException.class)
    public ResponseEntity authException(AuthException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

}
