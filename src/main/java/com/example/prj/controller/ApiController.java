package com.example.prj.controller;

import com.example.prj.dto.Car;
import com.example.prj.dto.Cust;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
//@Controller 라고 쓰면 String recurn시 static에서 리소스를 찾게된다.
//리소스를 찾는것이 아니라 reponseBody를 만들어서 return하고 싶으면 @responseBody를 추가해야한다.
@RestController // 해당 클래스는 rest api 처리하는 controller
@RequestMapping("/api") // uri를 지정하는 annotation
public class ApiController {

    @PostMapping("/hello")
    public String hello(){
        return "hello spring boot";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String hi(){
        return "hi";
    }

    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String name){
        return name;
    }
    // query param
    @GetMapping(path = "/query-param")
    public String queryParam(Map<String,String> queryParam){
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");
        });
        return "queryParam";
    }// 키값 모름

    @GetMapping(path = "/query-pqram2")
    public String queryParam2(
            @RequestParam String name,
            @RequestParam String email
    ){
        return "queryParam2";
    }//잘못받을 수 있음 따라서

    @PostMapping(path = "/query-param3")
    // req -> object mapper -> object -> method -> object -> object mapper -> json -> response
    public Car queryParm3(@RequestBody Car car){
        return car;
    }// 이런식으로 DTO로 받음

    @PutMapping("/put")// 이런식의 reposeEntity 방법이 좋다.
    public ResponseEntity<Car> put(@RequestBody Car car){
        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }

    @PostMapping("/post-test")
    public void post(@RequestBody Map<String, Object> requestData){

        requestData.forEach((key, value) -> {
            System.out.println("key : " + key);
            System.out.println("value : " + value);
        });

    }

    @PostMapping("/test")
    public Cust put(@RequestBody Cust cust){
        return cust;
    }
}


