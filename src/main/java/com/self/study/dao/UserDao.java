package com.self.study.dao;

import com.self.study.po.UserPO;

/**
 * @author duyubo
 */
public interface UserDao {
    /**
     * getUserByPhone
     * @param phone
     * @return
     */
    UserPO getUserByPhone(String phone);

    /**
     * insertUser
     * @param user
     * @return
     */
    Integer insertUser(UserPO user);
}
