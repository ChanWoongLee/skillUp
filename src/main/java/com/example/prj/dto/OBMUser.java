package com.example.prj.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Setter
@Getter
public class OBMUser {
    private String name;
    private int age;
    @Valid // car에 유효성겁사를 한다고 해도 valid를 체크하기위해서 꼭 이 어노테이션을 추가해야한다.
    private List<Car> cars;
}
