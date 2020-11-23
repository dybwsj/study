package com.self.study.dao;

import com.self.study.po.UserPO;

/**
 * @author duyubo
 */
public interface UserDao {
    /**
     * getUserByEmail
     * @param email
     * @return
     */
    UserPO getUserByEmail(String email);
}
