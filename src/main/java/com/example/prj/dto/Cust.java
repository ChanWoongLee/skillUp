package com.example.prj.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cust {
    @JsonProperty(value = "cust_no")
    private long custNo;
    private String name;
}
