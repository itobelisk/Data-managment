package com.dream.data.building.floor.mapper;

import com.dream.data.building.floor.dao.request.FloorRequest;
import com.dream.data.building.floor.dao.response.FloorResponse;
import com.dream.data.building.floor.entity.Floor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuildingFloorMapper {
    public Floor toFloorRequest(FloorRequest floorRequest) {
        return Floor.builder()
                .floors(floorRequest.getFloors())
                .build();
    }

    public FloorResponse toFloorResponse(Floor floor) {
        return FloorResponse
                .builder()
                .id(floor.getId())
                .createdDate(floor.getCreatedDate())
                .updatedDate(floor.getLastModifiedDate())
                .floors(floor.getFloors())
                .build();
    }
}
