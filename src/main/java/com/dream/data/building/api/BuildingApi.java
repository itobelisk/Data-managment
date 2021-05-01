package com.dream.data.building.api;

import com.dream.data.base.BaseResponse;
import com.dream.data.building.dao.request.BuildingRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/data/building")
public interface BuildingApi {
    @PostMapping("/save")
    ResponseEntity<BaseResponse<?>> save(@RequestHeader(name = "Authorization") String accessToken,
                                         @RequestBody BuildingRequest buildingRequest);
}
