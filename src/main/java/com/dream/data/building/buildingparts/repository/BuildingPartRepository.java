package com.dream.data.building.buildingparts.repository;

import com.dream.data.building.buildingparts.entity.BuildingParts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingPartRepository extends JpaRepository<BuildingParts,Long> {
}
