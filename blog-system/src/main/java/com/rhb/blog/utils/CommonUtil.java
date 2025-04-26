package com.rhb.blog.utils;

import com.rhb.blog.domain.R;

public class CommonUtil {
    public static R<Boolean> handleResult(int result, String failMessage) {
        if (result > 0) {
            return ResponseUtil.success();
        } else {
            return ResponseUtil.fail(failMessage);
        }
    }
}
