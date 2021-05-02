package com.dream.data.permissions.service;

import com.dream.data.base.BaseResponse;
import com.dream.data.permissions.dao.request.PermissionRequest;

public interface PermissionService {
    BaseResponse<?> save(String accessToken, PermissionRequest permissionRequest);

    BaseResponse<?> showAll(String accessToken);

    BaseResponse<?> single(String accessToken, PermissionRequest permissionRequest);

    BaseResponse<?> update(String accessToken, PermissionRequest permissionRequest);

    BaseResponse<?> delete(String accessToken, PermissionRequest permissionRequest);
}
