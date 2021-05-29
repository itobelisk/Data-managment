package com.dream.data.security;

import com.dream.data.constances.connection.AdminLinks;
import com.dream.data.securityRestTemplateActions.SecurityCheckRestTemplateActions;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckPermissions {

    private final SecurityCheckRestTemplateActions<String> securityCheckRestTemplateActions;

    @Async
    public void checkPermission(String accessToken) {
        securityCheckRestTemplateActions.sendPostRequestCheck(accessToken, AdminLinks.CHECK_USER);
    }
}
