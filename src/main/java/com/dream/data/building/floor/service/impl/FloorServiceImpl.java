package com.dream.data.building.floor.service.impl;

import com.dream.data.base.BaseResponse;
import com.dream.data.building.floor.dao.response.FloorResponse;
import com.dream.data.building.floor.entity.Floor;
import com.dream.data.building.floor.mapper.BuildingFloorMapper;
import com.dream.data.building.floor.repository.BuildingFloorRepository;
import com.dream.data.building.floor.service.FloorService;
import com.dream.data.security.CheckPermissions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FloorServiceImpl implements FloorService {

    private final BuildingFloorRepository buildingFloorRepository;
    private final BuildingFloorMapper buildingFloorMapper;
    private final CheckPermissions checkPermissions;


    @Override
    public BaseResponse<?> all(String accessToken) {
        checkPermissions.checkPermission(accessToken);
        List<FloorResponse> permissionResponse = buildingFloorMapper.toFloorResponseAll(buildingFloorRepository.findAll());
        return new BaseResponse<>(new Date(), true, HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, permissionResponse);
    }

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
