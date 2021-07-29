package com.example.prj;

import com.example.prj.DI.Base64Encoder;
import com.example.prj.DI.Encoder;
import com.example.prj.DI.UrlEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class PrjApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrjApplication.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();


    }

}


//@Configuration// 한개의 클래스에서 여러개의 빈을 등록하겠다. 따라서 Bean어노테이션은 component와 달리 method에 붙이는 것이다.
//class AppConfig {
//
//    @Bean("base64Encode")
//    //이미 Base64Encoder인 이름의 Bean이 있으면 spring에서 알아서 주입해준다.
//    public Encoder encoder(Base64Encoder base64Encoder) {
//        return new Encoder(base64Encoder);
//    }
//
//    @Bean("urlEncode")
//    public Encoder encoder(UrlEncoder urlEncoder) {
//        return new Encoder(urlEncoder);
//    }
//
//
//}