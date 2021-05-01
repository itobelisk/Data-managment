package com.dream.data.permissions.entity;

import com.dream.data.base.BaseEntity;
import com.dream.data.permissioncategory.entity.PermissionCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "permissions")
public class PermissionsEntity extends BaseEntity {
    @Column(columnDefinition = "varchar 255 default '")
    private String permissionName;

    private Boolean isActive = false;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "permission_id", nullable = false, referencedColumnName = "id")
    private PermissionCategory permissionCategory;
}
