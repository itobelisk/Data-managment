package com.dream.data.permissions.controller;

import com.dream.data.base.BaseResponse;
import com.dream.data.permissions.api.PermissionApi;
import com.dream.data.permissions.dao.request.PermissionRequest;
import com.dream.data.permissions.service.impl.PermissionServiceImpl;
import com.dream.data.security.CheckPermissions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class PermissionController implements PermissionApi {
    private final PermissionServiceImpl permissionService;

    @Override
    public ResponseEntity<BaseResponse<?>> save(String accessToken, PermissionRequest permissionRequest) {
        BaseResponse<?> response = permissionService.save(accessToken,permissionRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> all(String accessToken) {
        BaseResponse<?> response = permissionService.showAll(accessToken);
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> single(String accessToken, PermissionRequest permissionRequest) {
        BaseResponse<?> response = permissionService.single(accessToken,permissionRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> update(String accessToken, PermissionRequest permissionRequest) {
        BaseResponse<?> response = permissionService.update(accessToken,permissionRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> delete(String accessToken, PermissionRequest permissionRequest) {
        BaseResponse<?> response = permissionService.delete(accessToken,permissionRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }
}
