package com.dream.data.constances.connection;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
@RequiredArgsConstructor
public class AdminLinks {

    @Value("${auth_base_url}")
    private static String baseUrl;

    public  static final String CHECK_USER = "http://45.61.48.50:8080/authorization/auth/check";
}
