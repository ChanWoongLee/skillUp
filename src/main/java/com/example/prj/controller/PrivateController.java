package com.example.prj.controller;

import com.example.prj.annotation.Auth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
@Auth
public class PrivateController {

    @GetMapping("/hello")
    public String hello(){
        return "private";
    }
}
