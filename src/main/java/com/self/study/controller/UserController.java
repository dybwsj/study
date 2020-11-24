package com.self.study.controller;

import com.self.study.common.ResultVO;
import com.self.study.param.LoginParam;
import com.self.study.param.RegisterParam;
import com.self.study.po.UserPO;
import com.self.study.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 10:16
 * @description:
 */

@Api(tags = "用户管理类")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${jwt.tokenHeader}")
    private String header;

    @ApiOperation("登陆")
    @PostMapping("/login")
    public ResultVO login(@RequestBody @Valid LoginParam param) {
        String token = userService.login(param.getPhone(), param.getPassword());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("header", header);
        hashMap.put("token", token);
        return ResultVO.success("登陆成功！", hashMap);
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public ResultVO register(@RequestBody @Valid RegisterParam param) {
        userService.register(param);
        return ResultVO.success("注册成功！");
    }

    @ApiOperation("刷新token")
    @PostMapping("/refreshToken")
    public ResultVO refreshToken(HttpServletRequest request) {
        String token = userService.refreshToken(request.getHeader(header));
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("header", header);
        hashMap.put("token", token);
        return ResultVO.success("刷新token成功！", hashMap);
    }

    /**
     * fixme 请求logout路径会报405，怀疑是SpringSecurity的原因
     * @param request
     * @return
     */
//    @ApiOperation("登出")
//    @RequestMapping(value = "/admin/logout", method = RequestMethod.POST)
//    public ResultVO test() {
//        return ResultVO.success(null);
//    }

    @ApiOperation("获取用户信息")
    @PostMapping("/getUserInfo")
    public ResultVO getUserInfo(HttpServletRequest request) {
        UserPO userInfo = userService.getUserInfo(request.getHeader(header));
        return ResultVO.success(userInfo);
    }
}
