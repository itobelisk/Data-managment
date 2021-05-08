package com.dream.data.building.floor.controller;

import com.dream.data.base.BaseResponse;
import com.dream.data.building.floor.api.FloorApi;
import com.dream.data.building.floor.service.impl.FloorServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FloorController implements FloorApi {

    private final FloorServiceImpl floorServiceImpl;

    @Override
    public ResponseEntity<BaseResponse<?>> all(String accessToken) {
        BaseResponse<?> response = floorServiceImpl.all(accessToken);
        return new ResponseEntity<>(response, response.getMessage());
    }
}
