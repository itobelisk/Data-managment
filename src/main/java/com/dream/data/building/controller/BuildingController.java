package com.dream.data.building.controller;

import com.dream.data.base.BaseResponse;
import com.dream.data.building.api.BuildingApi;
import com.dream.data.building.buildingparts.service.impl.BuildingPartServiceImpl;
import com.dream.data.building.dao.request.BuildingRequest;
import com.dream.data.security.CheckPermissions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BuildingController implements BuildingApi {

    private final CheckPermissions checkPermissions;
    private final BuildingPartServiceImpl buildingPartServiceImpl;

    @Override
    public ResponseEntity<BaseResponse<?>> save(String accessToken, BuildingRequest buildingRequest) {
        checkPermissions.checkPermission(accessToken);
        BaseResponse<?> response = buildingPartServiceImpl.saveBuilding(buildingRequest);
        return new ResponseEntity<>(response, response.getMessage());
    }
}
