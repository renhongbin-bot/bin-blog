package com.rhb.blog.domain;

import lombok.Data;

@Data
public class R<T> {
    private int code; // 状态码
    private String message; // 消息
    private T data; // 数据

    // 构造方法
    public R(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
