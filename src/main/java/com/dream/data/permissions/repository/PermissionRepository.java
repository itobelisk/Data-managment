package com.dream.data.permissions.repository;

import com.dream.data.permissions.entity.PermissionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<PermissionsEntity,Long> {
}
