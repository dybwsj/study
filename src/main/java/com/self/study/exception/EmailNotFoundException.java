package com.self.study.exception;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 13:43
 * @description:
 */
public class EmailNotFoundException extends MyException {
    public EmailNotFoundException(int code, String message) {
        super(code, message);
    }

    public EmailNotFoundException(String message) {
        super(message);
    }
}
