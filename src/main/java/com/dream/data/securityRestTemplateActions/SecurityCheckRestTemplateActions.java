package com.dream.data.securityRestTemplateActions;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SecurityCheckRestTemplateActions<T> {

    public ResponseEntity<?> sendPostRequestCheck(T t, String url){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization",t.toString());
        HttpEntity<T> request = new HttpEntity<>(t, headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(url, request , String.class);
    }
}
