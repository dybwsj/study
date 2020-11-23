package com.self.study.controller;

import com.self.study.common.ResultVO;
import com.self.study.param.UserParam;
import com.self.study.service.UserService;
import com.self.study.utils.AssertUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 10:16
 * @description:
 */

@Api(value = "用户管理类")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("登陆")
    @PostMapping("/login")
    public ResultVO login(@RequestBody @Valid UserParam userParam) {
        String email = userParam.getEmail();
        String password = userParam.getPassword();
        String token = userService.login(email, password);
        AssertUtil.notNull(token, "登陆失败！");
        return ResultVO.success("登陆成功！", token);
    }

    @PostMapping("/test")
    public ResultVO test() {
        return ResultVO.success("测试路径成功");
    }
}
