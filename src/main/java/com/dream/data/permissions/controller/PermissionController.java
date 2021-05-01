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
    private final CheckPermissions checkPermissions;

    @Override
    public ResponseEntity<BaseResponse<?>> save(String accessToken, PermissionRequest permissionRequest) {
        checkPermissions.checkPermission(accessToken);
        BaseResponse<?> response = permissionService.save(permissionRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> all(String accessToken) {
        checkPermissions.checkPermission(accessToken);
        BaseResponse<?> response = permissionService.showAll();
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> single(String accessToken, PermissionRequest permissionRequest) {
        checkPermissions.checkPermission(accessToken);
        BaseResponse<?> response = permissionService.single(permissionRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> update(String accessToken, PermissionRequest permissionRequest) {
        checkPermissions.checkPermission(accessToken);
        BaseResponse<?> response = permissionService.update(permissionRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> delete(String accessToken, PermissionRequest permissionRequest) {
        checkPermissions.checkPermission(accessToken);
        BaseResponse<?> response = permissionService.delete(permissionRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }
}
