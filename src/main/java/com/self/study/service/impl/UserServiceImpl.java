package com.self.study.service.impl;

import com.self.study.bo.UserDetail;
import com.self.study.dao.UserResourceDao;
import com.self.study.exception.LogonFailureException;
import com.self.study.param.RegisterParam;
import com.self.study.po.UserResourcePO;
import com.self.study.po.UserPO;
import com.self.study.dao.UserDao;
import com.self.study.service.UserService;
import com.self.study.utils.AssertUtil;
import com.self.study.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public String login(String phone, String password) {

        Authentication authenticate;
        try {
            authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(phone, password));
        } catch (Exception e) {
            throw new LogonFailureException("用户名或密码错误！");
        }
        Object principal = authenticate.getPrincipal();
        return jwtTokenUtil.generateToken((UserDetail)principal);
    }

    @Override
    public UserDetail loadUserByUsername(String phone) {
        UserPO user = userDao.getUserByPhone(phone);
        AssertUtil.notNull(user, "该邮箱不存在！");
        List<UserResourcePO> resourceList = userResourceDao.getResourceListById(user.getId());
        return new UserDetail(user, resourceList);
    }

    @Override
    public void register(RegisterParam param) {
        final BeanCopier beanCopier = BeanCopier.create(RegisterParam.class, UserPO.class, false);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserPO userInfo = userDao.getUserByPhone(param.getPhone());
        AssertUtil.isNull(userInfo, "该邮箱已存在！");
        UserPO user = new UserPO();
        beanCopier.copy(param, user, null);
        user.setPassword(encoder.encode(param.getPassword()));
        user.setStatus(1);
        userDao.insertUser(user);
    }

    @Override
    public String refreshToken(String token) {
        String newToken = jwtTokenUtil.refreshHeadToken(token);
        AssertUtil.notNull(newToken, "token已失效！");
        return newToken;
    }

    @Override
    public UserPO getUserInfo(String token) {
        String userName = jwtTokenUtil.getUserNameFromToken(token);
        return userDao.getUserByPhone(userName);
    }

}
