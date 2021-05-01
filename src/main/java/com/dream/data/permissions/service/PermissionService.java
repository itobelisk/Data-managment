package com.dream.data.permissions.service;

import com.dream.data.base.BaseResponse;
import com.dream.data.permissions.dao.request.PermissionRequest;

public interface PermissionService {
    BaseResponse<?> save(PermissionRequest permissionRequest);

    BaseResponse<?> showAll();

    BaseResponse<?> single(PermissionRequest permissionRequest);

    BaseResponse<?> update(PermissionRequest permissionRequest);

    BaseResponse<?> delete(PermissionRequest permissionRequest);
}
