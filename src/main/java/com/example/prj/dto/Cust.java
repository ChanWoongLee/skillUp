package com.example.prj.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class Cust {
    @JsonProperty(value = "cust_no")
    private long custNo;
    private String name;

    public long getCustNo() {
        return custNo;
    }

    public void setCustNo(long custNo) {
        this.custNo = custNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
