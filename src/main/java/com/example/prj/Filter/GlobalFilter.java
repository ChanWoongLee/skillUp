//package com.example.prj.Filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.util.ContentCachingRequestWrapper;
//import org.springframework.web.util.ContentCachingResponseWrapper;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Slf4j
//@Component
////ServletComponent 어노테이션 추가한다음에  WebFilter 어노테이션을 통해 원하는 컨트롤러에 필터 적용가능
//public class GlobalFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        // 전처리
//        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest)request);
//        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse)response);
//
//        chain.doFilter(httpServletRequest,httpServletResponse); // 이후에 reponse가 만들어진다!
//
//        String url = httpServletRequest.getRequestURI();
//
//        // 후처리
//        String reqContent = new String(httpServletRequest.getContentAsByteArray());
//        log.info("Filter request url: {}, request body{}", url, reqContent);
//
//        String resContent = new String(httpServletResponse.getContentAsByteArray());
//        int httpStatus = httpServletResponse.getStatus();
//
//        httpServletResponse.copyBodyToResponse();// 커서 다시 옮기기   reponse를 다시 줘야하기 때문에
//
//        log.info("Filter response status: {}, response body", httpStatus , resContent);
//    }
//}
