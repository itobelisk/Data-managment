package com.dream.data.permissions.controller;

import com.dream.data.base.BaseResponse;
import com.dream.data.permissions.api.PermissionApi;
import com.dream.data.permissions.dao.request.PermissionRequest;
import com.dream.data.permissions.service.impl.PermissionServiceImpl;
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
    public ResponseEntity<BaseResponse<?>> save(PermissionRequest permissionRequest) {
        BaseResponse<?> response = permissionService.save(permissionRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> all() {
        BaseResponse<?> response = permissionService.all();
        return new ResponseEntity<>(response, response.getMessage());
       
    }

    @Override
    public ResponseEntity<BaseResponse<?>> single(PermissionRequest permissionRequest) {
        BaseResponse<?> response = permissionService.single(permissionRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> update(PermissionRequest permissionRequest) {
        BaseResponse<?> response = permissionService.update(permissionRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> delete(PermissionRequest permissionRequest) {
        BaseResponse<?> response = permissionService.delete(permissionRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }

}
