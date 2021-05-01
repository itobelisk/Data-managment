package com.dream.data.permissions.mapper;

import com.dream.data.permissioncategory.entity.PermissionCategory;
import com.dream.data.permissioncategory.mapper.PermissionCategoryMapper;
import com.dream.data.permissions.dao.request.PermissionRequest;
import com.dream.data.permissions.dao.response.PermissionResponse;
import com.dream.data.permissions.entity.PermissionsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.Permission;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class PermissionMapper {
    private final PermissionCategoryMapper permissionCategoryMapper;

    public PermissionsEntity toPermissionEntity(PermissionRequest permissionRequest,
                                                PermissionCategory permissionCategoryResponse) {
        return PermissionsEntity
                .builder()
                .permissionName(permissionRequest.getPermissionName())
                .permissionCategory(permissionCategoryResponse)
                .build();
    }

    public PermissionResponse toPermissionResponse(PermissionsEntity save) {
        return PermissionResponse
                .builder()
                .id(save.getId())
                .createdDate(save.getCreatedDate())
                .updatedDate(save.getLastModifiedDate())
                .permissionName(save.getPermissionName())
                .isActive(save.getIsActive())
                .permissionCategoryResponse(permissionCategoryMapper.permissionCategoryResponse(save.getPermissionCategory()))
                .build();
    }

    public List<PermissionResponse> toPermissionResponseList(List<PermissionsEntity> all) {
        List<PermissionResponse> permissionResponseList = new ArrayList<>();
        all.forEach(permissionsEntity -> {
            PermissionResponse permissionResponse = new PermissionResponse();
            permissionResponse.setId(permissionsEntity.getId());
            permissionResponse.setCreatedDate(permissionsEntity.getCreatedDate());
            permissionResponse.setUpdatedDate(permissionsEntity.getLastModifiedDate());
            permissionResponse.setPermissionName(permissionsEntity.getPermissionName());
            permissionResponse.setIsActive(permissionsEntity.getIsActive());
            permissionResponse.setPermissionCategoryResponse(permissionCategoryMapper.toPermissionCategoryResponseLists(permissionsEntity.getPermissionCategory()));
            permissionResponseList.add(permissionResponse);
        });
        return permissionResponseList;
    }
}
