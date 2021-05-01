package com.dream.data.permissions.api;

import com.dream.data.base.BaseResponse;
import com.dream.data.permissions.dao.request.PermissionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/data/permission")
public interface PermissionApi {

    @PostMapping("/save")
    ResponseEntity<BaseResponse<?>> save(@RequestHeader(name = "Authorization") String accessToken,
                                         @RequestBody PermissionRequest permissionRequest);

    @PostMapping("/all")
    ResponseEntity<BaseResponse<?>> all(@RequestHeader(name = "Authorization") String accessToken);

    @PostMapping("/single")
    ResponseEntity<BaseResponse<?>> single(@RequestHeader(name = "Authorization") String accessToken,
                                           @RequestBody PermissionRequest permissionRequest);
    @PostMapping("/update")
    ResponseEntity<BaseResponse<?>> update(@RequestHeader(name = "Authorization") String accessToken,
                                           @RequestBody PermissionRequest permissionRequest);

    @PostMapping("/delete")
    ResponseEntity<BaseResponse<?>> delete(@RequestHeader(name = "Authorization") String accessToken,
                                           @RequestBody PermissionRequest permissionRequest);

}
