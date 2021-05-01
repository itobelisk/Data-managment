package com.dream.data.building.buildingparts.service.impl;

import com.dream.data.base.BaseResponse;
import com.dream.data.building.buildingparts.entity.BuildingParts;
import com.dream.data.building.buildingparts.repository.BuildingPartRepository;
import com.dream.data.building.buildingparts.service.BuildingPartService;
import com.dream.data.building.dao.request.BuildingRequest;
import com.dream.data.building.dao.response.BuildingResponse;
import com.dream.data.building.entity.BuildingEntity;
import com.dream.data.building.mapper.BuildingMapper;
import com.dream.data.building.repository.BuildingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuildingPartServiceImpl implements BuildingPartService {
    private final BuildingPartRepository buildingPartRepository;
    private final BuildingMapper buildingMapper;
    private final BuildingRepository buildingRepository;

    @Override
    public BaseResponse<?> saveBuilding(BuildingRequest buildingRequest) {
        BaseResponse<?> response = null;
        try {
            BuildingEntity buildingEntity = buildingMapper.toSaveBuilding(buildingRequest);
            BuildingResponse buildingResponse = buildingMapper.toSaveBuildingResponse(buildingRepository.save(buildingEntity));
            response = new BaseResponse<>(new Date(), true, HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, buildingResponse);
        } catch (Exception e) {
            response = new BaseResponse<>(new Date(), false, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return new BaseResponse<>(new Date(), true, HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, response);
    }

    @Override
    public void addBuildingPart() {
        List<BuildingParts> locationTypeRequests = new ArrayList<>();
        locationTypeRequests.add(BuildingParts.builder()
                .buildingPartName("kitchen")
                .build());
        locationTypeRequests.add(BuildingParts.builder()
                .buildingPartName("Entrance")
                .build());
        locationTypeRequests.add(BuildingParts.builder()
                .buildingPartName("Waiting area")
                .build());
        locationTypeRequests.add(BuildingParts.builder()
                .buildingPartName("Bar")
                .build());
        locationTypeRequests.add(BuildingParts.builder()
                .buildingPartName("Dining Room")
                .build());
        locationTypeRequests.add(BuildingParts.builder()
                .buildingPartName("Storage spaces")
                .build());
        locationTypeRequests.add(BuildingParts.builder()
                .buildingPartName("Restrooms")
                .build());
        locationTypeRequests.add(BuildingParts.builder()
                .buildingPartName("Backroom")
                .build());
        locationTypeRequests.add(BuildingParts.builder()
                .buildingPartName("Outdoor seating")
                .build());
        locationTypeRequests.add(BuildingParts.builder()
                .buildingPartName("Garden Outdoor")
                .build());

        List<BuildingParts> buildingPartsList = buildingPartRepository.findAll();
        if (buildingPartsList.isEmpty()) {
            buildingPartRepository.saveAll(locationTypeRequests);
        }
    }
}
