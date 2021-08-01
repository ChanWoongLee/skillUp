package com.example.prj.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

// 한 파일에 대해서 카멜에 대한 스네이크 인지
@Setter
@Getter
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL) // null은 포함하지 않겠다.
public class Car {
    // 특정 변수만 활용
    @JsonProperty("name_name")
    private String name;
    private int age;

}
