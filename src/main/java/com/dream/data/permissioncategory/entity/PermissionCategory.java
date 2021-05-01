package com.dream.data.permissioncategory.entity;

import com.dream.data.base.BaseEntity;
import com.dream.data.permissions.entity.PermissionsEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "permission_category")
public class PermissionCategory extends BaseEntity {

    @OneToMany(mappedBy = "permissionCategory")
    private List<PermissionsEntity> permissionCategoryList;

    @Column(columnDefinition = "varchar 255 default '")
    private String permissionCategoryName;

}
