package com.example.prj.eceception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AuthException extends RuntimeException  {
    private String message;

}
