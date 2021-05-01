package com.dream.data.permissions.dao.request;

import com.dream.data.permissioncategory.dao.request.PermissionCategoryRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionRequest {
    private Long id;
    private String permissionName;
    private PermissionCategoryRequest permissionCategory;
    private Boolean isActive = false;
}
