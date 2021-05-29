package com.dream.data.permissions.service.impl;


import com.dream.data.base.BaseResponse;
import com.dream.data.exceptions.PermissionCategoryIdNotFound;
import com.dream.data.permissioncategory.dao.request.PermissionCategoryRequest;
import com.dream.data.permissioncategory.entity.PermissionCategory;
import com.dream.data.permissioncategory.mapper.PermissionCategoryMapper;
import com.dream.data.permissioncategory.repository.PermissionCategoriesRepository;
import com.dream.data.permissions.dao.request.PermissionRequest;
import com.dream.data.permissions.dao.response.PermissionResponse;
import com.dream.data.permissions.entity.PermissionsEntity;
import com.dream.data.permissions.mapper.PermissionMapper;
import com.dream.data.permissions.repository.PermissionRepository;
import com.dream.data.permissions.service.PermissionService;
import com.dream.data.security.CheckPermissions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;
    private final PermissionCategoryMapper permissionCategoryMapper;
    private final PermissionCategoriesRepository permissionCategoriesRepository;
    private final CheckPermissions checkPermissions;

    @Override
    public BaseResponse<?> save(String accessToken, PermissionRequest permissionRequest) {
        checkPermissions.checkPermission(accessToken);
        PermissionCategory permissionCategory = permissionCategoriesRepository.getOne(permissionRequest.getPermissionCategory().getId());
        PermissionsEntity permissionsEntity = permissionMapper.toPermissionEntity(permissionRequest, permissionCategory);
        PermissionResponse permissionResponse = permissionMapper.toPermissionResponse(permissionRepository.save(permissionsEntity));
        return new BaseResponse<>(new Date(), true, HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, permissionResponse);
    }

    public BaseResponse<?> showAll(String accessToken) {
        checkPermissions.checkPermission(accessToken);
        List<PermissionResponse> permissionResponse = permissionMapper.toPermissionResponseList(permissionRepository.findAll());
        return new BaseResponse<>(new Date(), true, HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, permissionResponse);
    }

    @Override
    public BaseResponse<?> single(String accessToken, PermissionRequest permissionRequest) {
        checkPermissions.checkPermission(accessToken);
        PermissionResponse permissionResponse = permissionMapper.toPermissionResponse(permissionRepository.getOne(permissionRequest.getId()));
        return new BaseResponse<>(new Date(), true, HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, permissionResponse);
    }

    @Override
    public BaseResponse<?> update(String accessToken, PermissionRequest permissionRequest) {
        checkPermissions.checkPermission(accessToken);
        checkPermissionRequest(permissionRequest);
        checkPermissionCategoryRequest(permissionRequest.getPermissionCategory());
        PermissionsEntity permissionsEntity = permissionRepository.getOne(permissionRequest.getId());
        permissionsEntity.setPermissionName(permissionRequest.getPermissionName());
        permissionsEntity.setCreatedDate(permissionsEntity.getCreatedDate());
        permissionsEntity.setIsActive(permissionRequest.getIsActive());
        permissionsEntity.setPermissionCategory(permissionCategoryMapper.toPermissionCategoryResponseUpdatePermission(permissionCategoriesRepository.getOne(permissionRequest.getPermissionCategory().getId()),permissionRequest));
        permissionsEntity.setId(permissionRequest.getId());

        PermissionResponse permissionResponse = permissionMapper.toPermissionResponse(permissionRepository.save(permissionsEntity));
        return new BaseResponse<>(new Date(), true, HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, permissionResponse);
    }

    @Override
    public BaseResponse<?> delete(String accessToken, PermissionRequest permissionRequest) {
        checkPermissions.checkPermission(accessToken);
        checkPermissionRequest(permissionRequest);
        permissionRepository.deleteById(permissionRequest.getId());
        return new BaseResponse<>(new Date(), true, HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, null);
    }

    private void checkPermissionCategoryRequest(PermissionCategoryRequest permissionRequest) {
        if (!permissionCategoriesRepository.existsById(permissionRequest.getId()))
            throw new PermissionCategoryIdNotFound();
    }

    private void checkPermissionRequest(PermissionRequest permissionRequest) {
        if (!permissionRepository.existsById(permissionRequest.getId()))
            throw new PermissionCategoryIdNotFound();
    }
}
