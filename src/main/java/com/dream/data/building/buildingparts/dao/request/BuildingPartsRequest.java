package com.dream.data.building.buildingparts.dao.request;

import com.dream.data.building.dao.request.BuildingRequest;
import com.dream.data.building.entity.BuildingEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuildingPartsRequest {
    private Long id;
    private Date createdDate;
    private Date updatedDate;
    private List<BuildingRequest> buildingRequests;
    private String buildingPartName;

}
