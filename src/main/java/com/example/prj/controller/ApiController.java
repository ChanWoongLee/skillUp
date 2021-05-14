package com.example.prj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 클래스는 rest api 처리하는 controller
@RequestMapping("/api") // uri를 지정하는 annotation
public class ApiController {

    @GetMapping("/hello")
    public String hello(){
        return "hello spring boot";
    }
}
