package com.dream.data.building.floor.api;

import com.dream.data.base.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/data/floor")
public interface FloorApi {

    @PostMapping("/all")
    ResponseEntity<BaseResponse<?>> all(@RequestHeader(name = "Authorization") String accessToken);
}
