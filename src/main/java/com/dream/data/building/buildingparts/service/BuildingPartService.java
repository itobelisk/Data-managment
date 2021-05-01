package com.dream.data.building.buildingparts.service;

import com.dream.data.base.BaseResponse;
import com.dream.data.building.dao.request.BuildingRequest;

public interface BuildingPartService{
    void addBuildingPart();

    BaseResponse<?> saveBuilding(BuildingRequest buildingRequest);
}
