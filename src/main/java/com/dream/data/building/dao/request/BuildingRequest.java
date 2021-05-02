package com.dream.data.building.dao.request;

import com.dream.data.building.buildingparts.dao.request.BuildingPartsRequest;
import com.dream.data.building.floor.dao.request.FloorRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuildingRequest {
    private Long id;
    private BuildingPartsRequest buildingPartsRequest;
    private FloorRequest floorRequest;
}
