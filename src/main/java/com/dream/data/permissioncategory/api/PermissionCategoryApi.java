package com.dream.data.permissioncategory.api;

import com.dream.data.base.BaseResponse;
import com.dream.data.permissioncategory.dao.request.PermissionCategoryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/data/permission/category")
public interface PermissionCategoryApi {

    @PostMapping("/save")
    ResponseEntity<BaseResponse<?>> save(@RequestHeader(name = "Authorization") String accessToken,
                                         @RequestBody PermissionCategoryRequest permissionCategoryRequest);

    @PostMapping("/single")
    ResponseEntity<BaseResponse<?>> single(@RequestHeader(name = "Authorization") String accessToken,
                                           @RequestBody PermissionCategoryRequest permissionCategoryRequest);

    @PostMapping("/update")
    ResponseEntity<BaseResponse<?>> update(@RequestHeader(name = "Authorization") String accessToken,
                                           @RequestBody PermissionCategoryRequest permissionCategoryRequest);

    @PostMapping("/delete")
    ResponseEntity<BaseResponse<?>> delete(@RequestHeader(name = "Authorization") String accessToken,
                                           @RequestBody PermissionCategoryRequest permissionCategoryRequest);

    @PostMapping("/showAll")
    ResponseEntity<BaseResponse<?>> showAll(@RequestHeader(name = "Authorization") String accessToken);
}
