package com.dream.data.building.floor.service;

import com.dream.data.base.BaseResponse;

public interface FloorService {
    void addFloors();

    BaseResponse<?> all(String accessToken);

}
