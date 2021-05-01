package com.dream.data.permissioncategory.service;

import com.dream.data.base.BaseResponse;
import com.dream.data.permissioncategory.dao.request.PermissionCategoryRequest;

public interface PermissionCategoryService {
    BaseResponse<?> savePermissionCategory(PermissionCategoryRequest permissionCategoryRequest);

    BaseResponse<?> getSinglePermissionCategory(PermissionCategoryRequest permissionCategoryRequest);

    BaseResponse<?> updatePermissionCategory(PermissionCategoryRequest permissionCategoryRequest);

    BaseResponse<?> deletePermissionCategory(PermissionCategoryRequest permissionCategoryRequest);

    BaseResponse<?> showAllPermissionCategory();
}
