package com.example.prj.controller;

import com.example.prj.annotation.Decode;
import com.example.prj.annotation.Timer;
import com.example.prj.dto.Cust;
import com.example.prj.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/aop")
public class AOPTestController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name){
        //System.out.println("get method : id =" + id + ", name = "+ name)    ;
        return id+ " " + name;
    }

    @PostMapping("/post")
    //Valid 어노테이션을 통해 DTO에 정의된 valid한 값을 확인, 해당 결과는 bindingresult로 출력
    public Cust post(@RequestBody Cust user){
        System.out.println("!!!!!!!!!!!!!!!!!!!!~~~~~~~~~~~~~~~~~");
        log.info("User : {}" ,user);
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        Thread.sleep(1000*2);
    }

    @Decode
    @PostMapping("/put")
    public User put(User user){
        return user;
    }
}
