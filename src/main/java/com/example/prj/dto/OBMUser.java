package com.example.prj.dto;

import javax.validation.Valid;
import java.util.List;

public class OBMUser {
    private String name;
    private int age;
    @Valid // car에 유효성겁사를 한다고 해도 valid를 체크하기위해서 꼭 이 어노테이션을 추가해야한다.
    private List<Car> cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
