package com.self.study.service.impl;

import com.self.study.bo.UserDetail;
import com.self.study.po.UserResource;
import com.self.study.dao.UserResourceDao;
import com.self.study.po.UserPO;
import com.self.study.dao.UserDao;
import com.self.study.service.UserService;
import com.self.study.utils.AssertUtil;
import com.self.study.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 11:39
 * @description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserResourceDao userResourceDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public String login(String email, String password) {

        Authentication authenticate;
        try {
            authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (Exception e) {
            throw new RuntimeException("用户名或密码错误！");
        }
        Object principal = authenticate.getPrincipal();
        return jwtTokenUtil.generateToken((UserDetail)principal);
    }

    @Override
    public UserDetail loadUserByUsername(String email) {
        UserPO user = userDao.getUserByEmail(email);
        AssertUtil.notNull(user, "该邮箱不存在！");
        List<UserResource> resourceList = userResourceDao.getResourceListById(user.getId());
        return new UserDetail(user, resourceList);
    }
}
