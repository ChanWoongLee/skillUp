package com.example.prj.service;

import com.example.prj.dto.UserRequest;
import com.example.prj.dto.UserRequest2;
import com.example.prj.dto.UserResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Type;
import java.net.URI;

@Service
public class RestTemplateService {

    public ResponseEntity<UserResponse> hello(){
        // 이런식으로 서번간의 통신을 통해서 해당 결과를 받아올수 있다.
        //GET
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost")
                .path("/api/server/hello")
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri,UserResponse.class);

        //POST
        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);

        ResponseEntity<UserResponse> result2 = restTemplate.postForEntity(uri,req,UserResponse.class);

        // headr를 실어서 보내기
        RequestEntity<UserRequest> request = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("custom-header","1111")
                .body(req);
        ResponseEntity<UserResponse> result3 = restTemplate.exchange(request,UserResponse.class);// exchange를 통해서 header지정후 통신

        // header body 분리가 되어있을땐 ?  재사용을 위해서!! header, body를 끼워넣을수 있또록
        UserRequest2<UserRequest> userRequest2 = new UserRequest2<>();
        userRequest2.setBody(new UserRequest("steve",10));
        userRequest2.setHeader(new UserRequest2.Header());

        RequestEntity<UserRequest2<UserRequest>> request2erRequestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("custom-header","1111")
                .body(userRequest2);

        ResponseEntity<UserRequest2<UserResponse>> result4
                = restTemplate.exchange(request2erRequestEntity, new ParameterizedTypeReference<UserRequest2<UserResponse>>(){});
        //  제너릭을 메소드에 넣는방법

        return result;

    }


}
