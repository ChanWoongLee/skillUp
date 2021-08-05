package com.example.prj;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component // spring한테 객체의 생성주기나 관리르 맡기는것
public class ApplicationContextProvider implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override // 여기서 어플레케이션컨텍스트 주입은 스프링에서 알아서 해준다.
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;

    }

    public static ApplicationContext getContext(){
        return context;
    }
}
