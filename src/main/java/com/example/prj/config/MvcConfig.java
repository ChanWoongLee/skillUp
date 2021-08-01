package com.example.prj.config;

import com.example.prj.Interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

    //@Autowired로도 받아올수 있지만 순환참조가 발생할수 있기 때문에 롬복의 RequiredArgsContructor를 이용해서 초기화를 시켜준다.
    private  final AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/api/private/*");
        //registry.addInterceptor(). 이렇게 뒤에 추가하면 authInterceptor이 실행된다음에 밑의 인터셉터가 실행된다.
    }


}
