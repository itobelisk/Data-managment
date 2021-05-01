package com.dream.data.permissioncategory.dao.request;

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
public class PermissionCategoryRequest {
    private Long id;
    private Date createdDate;
    private Date updatedDate;
    private String permissionCategoryName;
}
