package com.dream.data.building.floor.service.impl;

import com.dream.data.building.buildingparts.entity.BuildingParts;
import com.dream.data.building.floor.entity.Floor;
import com.dream.data.building.floor.repository.BuildingFloorRepository;
import com.dream.data.building.floor.service.BuildingFloorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuildINgFloorServiceImpl implements BuildingFloorService {

    private final BuildingFloorRepository buildingFloorRepository;

    @Override
    public void addFloors() {
        List<Floor> floorArrayList = new ArrayList<>();
        for (int i = -5; i < 5; i++) {
            floorArrayList.add(Floor.builder()
                    .floors(i)
                    .build());
        }
        List<Floor> buildingPartsList = buildingFloorRepository.findAll();
        if (buildingPartsList.isEmpty()) {
            buildingFloorRepository.saveAll(floorArrayList);
        }
    }
}
