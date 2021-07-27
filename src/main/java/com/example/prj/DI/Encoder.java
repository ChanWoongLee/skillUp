package com.example.prj.DI;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Encoder implements IEncoder{

    private IEncoder iEncoder;

    public Encoder(@Qualifier("base64Encoder") IEncoder encoder){
        this.iEncoder = encoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }
}
