package com.dream.data.permissioncategory.mapper;

import com.dream.data.permissioncategory.dao.request.PermissionCategoryRequest;
import com.dream.data.permissioncategory.dao.response.PermissionCategoryResponse;
import com.dream.data.permissioncategory.entity.PermissionCategory;
import com.dream.data.permissions.dao.request.PermissionRequest;
import com.dream.data.permissions.entity.PermissionsEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PermissionCategoryMapper {

    public PermissionCategory permissionCategoryEntity(PermissionCategoryRequest permissionCategoryRequest) {
        return PermissionCategory.builder()
                .permissionCategoryName(permissionCategoryRequest.getPermissionCategoryName())
                .build();
    }

    public PermissionCategoryResponse toPermissionCategoryResponse(PermissionCategory save) {
        return PermissionCategoryResponse.builder()
                .id(save.getId())
                .createdDate(save.getCreatedDate())
                .updatedDate(save.getLastModifiedDate())
                .permissionCategoryName(save.getPermissionCategoryName())
                .build();
    }

    public List<PermissionCategoryResponse> toPermissionCategoryResponseList(List<PermissionCategory> all) {
        return all.stream()
                .map(e -> new PermissionCategoryResponse(
                        e.getId(),
                        e.getCreatedDate(),
                        e.getLastModifiedDate(),
                        e.getPermissionCategoryName()
                )).collect(Collectors.toList());
    }

    public PermissionCategoryResponse permissionCategoryResponse(PermissionCategory permissionCategory) {
        return PermissionCategoryResponse.builder()
                .id(permissionCategory.getId())
                .createdDate(permissionCategory.getCreatedDate())
                .updatedDate(permissionCategory.getLastModifiedDate())
                .permissionCategoryName(permissionCategory.getPermissionCategoryName())
                .build();
    }


    public PermissionCategoryResponse toPermissionCategoryResponseLists(PermissionCategory permissionCategoryList) {
        return PermissionCategoryResponse.builder()
                .id(permissionCategoryList.getId())
                .createdDate(permissionCategoryList.getCreatedDate())
                .updatedDate(permissionCategoryList.getLastModifiedDate())
                .permissionCategoryName(permissionCategoryList.getPermissionCategoryName())
                .build();
    }

    public PermissionCategory toPermissionCategoryResponseUpdatePermission(PermissionCategory permissionCategoryRequest,
                                                                           PermissionRequest permissionRequest) {
        PermissionCategory permissionCategory = new PermissionCategory();
        permissionCategory.setId(permissionCategoryRequest.getId());
        permissionCategory.setCreatedDate(permissionCategoryRequest.getCreatedDate());
        permissionCategory.setLastModifiedDate(permissionCategoryRequest.getLastModifiedDate());
        permissionCategory.setPermissionCategoryName(permissionRequest.getPermissionCategory().getPermissionCategoryName());
        return permissionCategory;
    }
}
