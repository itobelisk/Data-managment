package com.dream.data.permissioncategory.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionCategoryResponse {
    private Long id;
    private Date createdDate;
    private Date updatedDate;
    private String permissionCategoryName;

    public PermissionCategoryResponse(Long id, String permissionCategoryName) {
        this.id =id;
        this.permissionCategoryName = permissionCategoryName;
    }
}
