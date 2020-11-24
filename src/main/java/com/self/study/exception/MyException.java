package com.self.study.exception;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 13:38
 * @description:
 */
public class MyException extends RuntimeException {
    private int code;

    public MyException(int code, String message) {
        super(message);
        this.code = code;
    }

    public MyException(String message) {
        super(message);
    }

    public int getCode() {
        return this.code;
    }
}
