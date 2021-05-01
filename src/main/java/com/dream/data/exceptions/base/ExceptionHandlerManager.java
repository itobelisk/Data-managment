package com.dream.data.exceptions.base;

import com.dream.data.base.BaseResponse;
import com.dream.data.exceptions.PermissionCategoryIdNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ExceptionHandlerManager {

    @ExceptionHandler(PermissionCategoryIdNotFound.class)
    public ResponseEntity<BaseResponse<?>> PermissionCategoryIdNotFound(PermissionCategoryIdNotFound permissionCategoryIdNotFound){
        BaseResponse<?> baseResponse = new BaseResponse<>(new Date(),false,HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,permissionCategoryIdNotFound.getMessage());
        return new ResponseEntity<>(baseResponse, HttpStatus.ACCEPTED);
    }
}
