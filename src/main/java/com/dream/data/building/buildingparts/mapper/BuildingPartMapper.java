package com.dream.data.building.buildingparts.mapper;

import com.dream.data.building.buildingparts.dao.request.BuildingPartsRequest;
import com.dream.data.building.buildingparts.dao.response.BuildingPartsResponse;
import com.dream.data.building.buildingparts.entity.BuildingParts;
import org.springframework.stereotype.Component;

@Component
public class BuildingPartMapper {

    public BuildingParts toPartsRequest(BuildingPartsRequest buildingPartsRequest) {
        return BuildingParts.builder()
                .buildingPartName(buildingPartsRequest.getBuildingPartName())
                .build();
    }

    public BuildingPartsResponse toPartsResponse(BuildingParts buildingParts) {
        return BuildingPartsResponse.builder()
                .id(buildingParts.getId())
                .buildingPartName(buildingParts.getBuildingPartName())
                .build();
    }
}
