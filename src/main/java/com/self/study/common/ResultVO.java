package com.self.study.common;

import lombok.Data;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 10:25
 * @description:
 */

@Data
public class ResultVO<T> {
    private int code;
    private String message;
    private T data;

    private ResultVO(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> ResultVO<T> success(String message, T data) {
        return new ResultVO<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> ResultVO<T> success(int code, String message, T data) {
        return new ResultVO<T>(code, message, data);
    }

    public static <T> ResultVO<T> fail() {
        return new ResultVO<T>(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage(), null);
    }

    public static <T> ResultVO<T> fail(String message) {
        return new ResultVO<T>(ResultCode.FAIL.getCode(), message, null);
    }
}
