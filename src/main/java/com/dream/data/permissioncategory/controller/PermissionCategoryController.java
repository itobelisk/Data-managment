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
    public ResponseEntity<BaseResponse<?>> save(PermissionCategoryRequest permissionCategoryRequest) {
        BaseResponse<?> response = permissionCategoryServiceImpl.savePermissionCategory(permissionCategoryRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> single(PermissionCategoryRequest permissionCategoryRequest) {
        BaseResponse<?> response = permissionCategoryServiceImpl.getSinglePermissionCategory(permissionCategoryRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> update(PermissionCategoryRequest permissionCategoryRequest) {
        BaseResponse<?> response = permissionCategoryServiceImpl.updatePermissionCategory(permissionCategoryRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> delete(PermissionCategoryRequest permissionCategoryRequest) {
        BaseResponse<?> response = permissionCategoryServiceImpl.deletePermissionCategory(permissionCategoryRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> all() {
        BaseResponse<?> response = permissionCategoryServiceImpl.showAllPermissionCategory();
        return new ResponseEntity<>(response, response.getMessage());
    }
}
