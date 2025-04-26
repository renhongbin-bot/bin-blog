package com.rhb.blog.utils;

import com.rhb.blog.domain.R;
import com.rhb.blog.domain.enums.ResponseCode;

public class ResponseUtil {

    public static <T> R<T> success(T data) {
        return new R<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }
    public static <T> R<T> success() {
        return new R<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), null);
    }

    public static <T> R<T> fail(String message) {
        return new R<>(ResponseCode.FAIL.getCode(), message, null);
    }

    public static <T> R<T> unAuthorized() {
        return new R<>(ResponseCode.UNAUTHORIZED.getCode(), "没有权限访问此接口", null);
    }

    public static <T> R<T> fail(int code, String message) {
        return new R<>(code, message, null);
    }
}
