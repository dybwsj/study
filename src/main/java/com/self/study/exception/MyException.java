package com.self.study.exception;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 13:38
 * @description:
 */
public class MyException extends RuntimeException {
    private int code;
    private String message;

    public MyException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public MyException(String message) {
        this.message = message;
    }
}
