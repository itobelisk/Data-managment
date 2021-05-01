package com.dream.data.building.floor.repository;

import com.dream.data.building.floor.entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingFloorRepository extends JpaRepository<Floor,Long> {
}
