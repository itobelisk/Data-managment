package com.dream.data.building.buildingparts.dao.response;

import com.dream.data.building.buildingparts.entity.BuildingParts;
import com.dream.data.building.dao.response.BuildingResponse;
import com.dream.data.building.entity.BuildingEntity;
import com.dream.data.building.floor.dao.response.FloorResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuildingPartsResponse {
    private Long id;
    private Date creationDate;
    private Date updatedDate;
    private List<BuildingResponse> buildingEntityResponses;
    private String buildingPartName;
}
