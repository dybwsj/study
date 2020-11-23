package com.self.study.common;

import io.swagger.annotations.ApiResponses;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 10:34
 * @description:
 */

public enum ResultCode {
    /**
     * SUCCESS 成功
     * FAIL 失敗
     */
    SUCCESS(200, "操作成功！"),
    FAIL(500, "操作失敗!");

    private int code;
    private String message;

    /**
     *
     * @param code 返回碼
     * @param message 返回信息
     */
    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
