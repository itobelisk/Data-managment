package com.dream.data.permissions.dao.response;

import com.dream.data.permissioncategory.dao.response.PermissionCategoryResponse;
import com.dream.data.permissioncategory.entity.PermissionCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionResponse {
    private Long id;
    private Date createdDate;
    private Date updatedDate;
    private String permissionName;
    private Boolean isActive;
    private PermissionCategoryResponse permissionCategoryResponse;

}
