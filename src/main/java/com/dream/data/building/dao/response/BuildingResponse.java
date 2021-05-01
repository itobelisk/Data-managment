package com.dream.data.building.dao.response;

import com.dream.data.building.buildingparts.dao.response.BuildingPartsResponse;
import com.dream.data.building.floor.dao.response.FloorResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuildingResponse {
    private Long id;
    private Date createdDate;
    private Date updatedDate;
    private BuildingPartsResponse buildingPartsResponse;
    private FloorResponse floorResponse;

}
