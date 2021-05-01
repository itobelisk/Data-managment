package com.dream.data.permissioncategory.repository;

import com.dream.data.permissioncategory.entity.PermissionCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PermissionCategoriesRepository extends JpaRepository<PermissionCategory,Long> {
    @Query("select e from PermissionCategory e where e.id=?1")
    PermissionCategory findByCategoryId(Long id);

}
