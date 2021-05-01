package com.dream.data.constances.connection;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application-admin-links.properties")
@RequiredArgsConstructor
public class AdminLinks {

    @Value("${Data_Base_Url}")
    private static String baseUrl;

    public  static final String ROLE_NEW = "http://localhost:9090/auth/check";
}
