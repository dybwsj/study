package com.self.study.service;

import com.self.study.bo.UserDetail;

/**
 * @author duyubo
 */
public interface UserService {

    /**
     * getUserByEmail 通過郵箱獲取用戶
     * @param email
     * @param password
     * @return
     */
    String login(String email, String password);

    /**
     * getUserByEmail 通過郵箱獲取用戶
     * @param email
     * @return
     */
    UserDetail loadUserByUsername(String email);
}
