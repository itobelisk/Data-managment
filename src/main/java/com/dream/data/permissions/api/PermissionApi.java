package com.dream.data.permissions.api;

import com.dream.data.base.BaseResponse;
import com.dream.data.permissions.dao.request.PermissionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/data/permission")
public interface PermissionApi {

    @PostMapping("/save")
    ResponseEntity<BaseResponse<?>> save(@RequestBody PermissionRequest permissionRequest);
    @PostMapping("/all")
    ResponseEntity<BaseResponse<?>> all();
    @PostMapping("/single")
    ResponseEntity<BaseResponse<?>> single(@RequestBody PermissionRequest permissionRequest);
    @PostMapping("/update")
    ResponseEntity<BaseResponse<?>> update(@RequestBody PermissionRequest permissionRequest);
    @PostMapping("/delete")
    ResponseEntity<BaseResponse<?>> delete(@RequestBody PermissionRequest permissionRequest);

}
