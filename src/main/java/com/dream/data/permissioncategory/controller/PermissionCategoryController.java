package com.dream.data.permissioncategory.controller;

import com.dream.data.base.BaseResponse;
import com.dream.data.permissioncategory.api.PermissionCategoryApi;
import com.dream.data.permissioncategory.dao.request.PermissionCategoryRequest;
import com.dream.data.permissioncategory.service.impl.PermissionCategoryServiceImpl;
import com.dream.data.security.CheckPermissions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PermissionCategoryController implements PermissionCategoryApi {

    private final PermissionCategoryServiceImpl permissionCategoryServiceImpl;
    private final CheckPermissions checkPermissions;

    @Override
    public ResponseEntity<BaseResponse<?>> save(String accessToken, PermissionCategoryRequest permissionCategoryRequest) {
        checkPermissions.checkPermission(accessToken);
        BaseResponse<?> response = permissionCategoryServiceImpl.savePermissionCategory(permissionCategoryRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> single(String accessToken, PermissionCategoryRequest permissionCategoryRequest) {
        checkPermissions.checkPermission(accessToken);
        BaseResponse<?> response = permissionCategoryServiceImpl.getSinglePermissionCategory(permissionCategoryRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> update(String accessToken, PermissionCategoryRequest permissionCategoryRequest) {
        checkPermissions.checkPermission(accessToken);
        BaseResponse<?> response = permissionCategoryServiceImpl.updatePermissionCategory(permissionCategoryRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> delete(String accessToken, PermissionCategoryRequest permissionCategoryRequest) {
        checkPermissions.checkPermission(accessToken);
        BaseResponse<?> response = permissionCategoryServiceImpl.deletePermissionCategory(permissionCategoryRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> showAll(String accessToken) {
        checkPermissions.checkPermission(accessToken);
        BaseResponse<?> response = permissionCategoryServiceImpl.showAllPermissionCategory();
        return new ResponseEntity<>(response, response.getMessage());
    }
}
