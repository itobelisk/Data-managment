package com.dream.data.permissions.entity;

import com.dream.data.base.BaseEntity;
import com.dream.data.permissioncategory.entity.PermissionCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Table(name = "permissions")
public class PermissionsEntity extends BaseEntity {

//    @Column(name = "permission_name", columnDefinition = "varchar 255 default '' ")
    private String permissionName;

    private Boolean isActive = false;

    @ManyToOne
    @JoinColumn(name = "permissions_id", nullable = false, referencedColumnName = "id")
    private PermissionCategory permissionCategory;
}
