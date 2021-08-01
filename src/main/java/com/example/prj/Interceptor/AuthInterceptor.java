package com.example.prj.Interceptor;

import com.example.prj.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 여러개의 파라미터들을 연결하여 URL형태로 만들어주는 기능!
        //UriComponents uriComponents = UriComponentsBuilder.fromUriString(request.getRequestURI()).build();
        boolean hasAnnotation = checkAnnotation(handler, Auth.class);


        // Auth 권한을 가진 요청에 대해서는 세션, 쿠키 권한 체크
        if(hasAnnotation){
            String query = UriComponentsBuilder.fromUriString(request.getRequestURI()).query(request.getQueryString()).build().getQuery();
            log.debug("quert : {}",query);
            if(query.equals("name=steve")){
                return true;
            }
            return false;
        }

        return true;
    }

    private boolean checkAnnotation(Object handler, Class clazz) {
        //rsource는 그냥 통과 javascript, html
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }
        //anntation check
        HandlerMethod handlerMethod = (HandlerMethod)handler;

        if(null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)){
            //Auth annotation이 있을때는 true
            return true;
        }
        return false;
    }
}
