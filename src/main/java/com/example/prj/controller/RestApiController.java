package com.example.prj.controller;

import com.example.prj.annotation.Timer;
import com.example.prj.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aop")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name){
        //System.out.println("get method : id =" + id + ", name = "+ name)    ;
        return id+ " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user){
        //System.out.println(user.toString());
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        Thread.sleep(1000*2);
    }
}
