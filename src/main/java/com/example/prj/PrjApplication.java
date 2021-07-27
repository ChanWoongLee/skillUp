package com.example.prj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class PrjApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrjApplication.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();

    }

}


@Configuration // 한개의 클래스에서 여러개의 빈을 등록하겠다.
class AppConfig{

}