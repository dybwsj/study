package com.self.study.service;

/**
 * @author: duyubo
 * @date: 2020年11月26日, 0026 15:40
 * @description:
 */
public interface SmsService {
    /**
     * sendMessage
     * @param phone
     * @return
     */
    boolean sendMessage(String phone);
}
