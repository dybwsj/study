package com.self.study.exception;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 13:43
 * @description:
 */
public class LogonFailureException extends MyException {
    public LogonFailureException(int code, String message) {
        super(code, message);
    }

    public LogonFailureException(String message) {
        super(message);
    }
}
