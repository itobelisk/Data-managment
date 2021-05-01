package com.dream.data.permissioncategory.service.impl;

import com.dream.data.base.BaseResponse;
import com.dream.data.exceptions.PermissionCategoryIdNotFound;
import com.dream.data.permissioncategory.dao.request.PermissionCategoryRequest;
import com.dream.data.permissioncategory.dao.response.PermissionCategoryResponse;
import com.dream.data.permissioncategory.entity.PermissionCategory;
import com.dream.data.permissioncategory.mapper.PermissionCategoryMapper;
import com.dream.data.permissioncategory.repository.PermissionCategoriesRepository;
import com.dream.data.permissioncategory.service.PermissionCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionCategoryServiceImpl implements PermissionCategoryService {

    private final PermissionCategoriesRepository permissionCategoriesRepository;
    private final PermissionCategoryMapper permissionCategoryMapper;

    @Override
    public BaseResponse<?> savePermissionCategory(PermissionCategoryRequest permissionCategoryRequest) {
        PermissionCategory permissionCategory = permissionCategoryMapper.permissionCategoryEntity(permissionCategoryRequest);
        PermissionCategoryResponse response = permissionCategoryMapper.toPermissionCategoryResponse(permissionCategoriesRepository.save(permissionCategory));
        return new BaseResponse<>(new Date(), true,HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, response);
    }

    @Override
    public BaseResponse<?> getSinglePermissionCategory(PermissionCategoryRequest permissionCategoryRequest) {
        checkPermissionCategoryRequest(permissionCategoryRequest);
        PermissionCategoryResponse response = permissionCategoryMapper.toPermissionCategoryResponse(permissionCategoriesRepository.getOne(permissionCategoryRequest.getId()));
        return new BaseResponse<>(new Date(), true,HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, response);
    }

    @Override
    public BaseResponse<?> updatePermissionCategory(PermissionCategoryRequest permissionCategoryRequest) {
        checkPermissionCategoryRequest(permissionCategoryRequest);
        PermissionCategory permissionCategory = permissionCategoriesRepository.getOne(permissionCategoryRequest.getId());
        permissionCategory.setPermissionCategoryName(permissionCategoryRequest.getPermissionCategoryName());
        permissionCategoryRequest.setId(permissionCategory.getId());
        PermissionCategoryResponse permissionCategoryResponse = permissionCategoryMapper.toPermissionCategoryResponse(permissionCategoriesRepository.save(permissionCategory));
        return new BaseResponse<>(new Date(), true,HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, permissionCategoryResponse);
    }

    @Override
    public BaseResponse<?> deletePermissionCategory(PermissionCategoryRequest permissionCategoryRequest) {
        checkPermissionCategoryRequest(permissionCategoryRequest);
        permissionCategoriesRepository.deleteById(permissionCategoryRequest.getId());
        return new BaseResponse<>(new Date(), true,HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, null);

    }

    @Override
    public BaseResponse<?> showAllPermissionCategory() {
        List<PermissionCategoryResponse> permissionCategoryResponse = permissionCategoryMapper.toPermissionCategoryResponseList(permissionCategoriesRepository.findAll());
        return new BaseResponse<>(new Date(), true, HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED, permissionCategoryResponse);
    }

    private void checkPermissionCategoryRequest(PermissionCategoryRequest permissionCategoryRequest) {
        if (!permissionCategoriesRepository.existsById(permissionCategoryRequest.getId()))
            throw new PermissionCategoryIdNotFound();
    }
}
