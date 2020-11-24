package com.self.study.service;

import com.self.study.bo.UserDetail;
import com.self.study.param.RegisterParam;
import com.self.study.po.UserPO;

/**
 * @author duyubo
 */
public interface UserService {

    /**
     * login 登陆
     * @param email
     * @param password
     * @return
     */
    String login(String email, String password);

    /**
     * getUserByEmail 通過用户名獲取用戶
     * @param email
     * @return
     */
    UserDetail loadUserByUsername(String email);

    /**
     * register 注册
     * @param param
     */
    void register(RegisterParam param);

    /**
     * refreshToken 刷新token
     * @param token
     * @return
     */
    String refreshToken(String token);

    /**
     * getUserInfo 获取用户信息
     * @param token
     * @return
     */
    UserPO getUserInfo(String token);
}
