package com.dream.data.building.repository;

import com.dream.data.building.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<BuildingEntity,Long> {
}
