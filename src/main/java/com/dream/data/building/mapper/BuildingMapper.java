package com.dream.data.building.mapper;

import com.dream.data.building.buildingparts.mapper.BuildingPartMapper;
import com.dream.data.building.dao.request.BuildingRequest;
import com.dream.data.building.dao.response.BuildingResponse;
import com.dream.data.building.entity.BuildingEntity;
import com.dream.data.building.floor.mapper.BuildingFloorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuildingMapper {
    private final BuildingPartMapper buildingPartMapper;
    private final BuildingFloorMapper buildingFloorMapper;

    public BuildingEntity toSaveBuilding(BuildingRequest buildingRequest) {
        return BuildingEntity.builder()
                .buildingParts(buildingPartMapper.toPartsRequest(buildingRequest.getBuildingPartsRequest()))
                .floor(buildingFloorMapper.toFloorRequest(buildingRequest.getFloorRequest()))
                .build();
    }

    public BuildingResponse toSaveBuildingResponse(BuildingEntity save) {
        return BuildingResponse.builder()
                .id(save.getId())
                .createdDate(save.getCreatedDate())
                .updatedDate(save.getLastModifiedDate())
                .buildingPartsResponse(buildingPartMapper.toPartsResponse(save.getBuildingParts()))
                .floorResponse(buildingFloorMapper.toFloorResponse(save.getFloor()))
                .build();
    }
}
