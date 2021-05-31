package com.dream.data.permissioncategory.api;

import com.dream.data.base.BaseResponse;
import com.dream.data.permissioncategory.dao.request.PermissionCategoryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/data/permission/category")
@CrossOrigin
public interface PermissionCategoryApi {

    @PostMapping("/save")
    ResponseEntity<BaseResponse<?>> save(@RequestBody PermissionCategoryRequest permissionCategoryRequest);

    @PostMapping("/single")
    ResponseEntity<BaseResponse<?>> single(@RequestBody PermissionCategoryRequest permissionCategoryRequest);

    @PostMapping("/update")
    ResponseEntity<BaseResponse<?>> update(@RequestBody PermissionCategoryRequest permissionCategoryRequest);

    @PostMapping("/delete")
    ResponseEntity<BaseResponse<?>> delete(@RequestBody PermissionCategoryRequest permissionCategoryRequest);

    @PostMapping("/all")
    ResponseEntity<BaseResponse<?>> all();
}
