package com.self.study.controller;

import com.self.study.common.ResultVO;
import com.self.study.service.SmsService;
import com.self.study.utils.AssertUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: duyubo
 * @date: 2020年11月26日, 0026 15:38
 * @description:
 */

@Api(tags = "短信验证发送类")
@RestController
public class SmsController {

    @Autowired
    private SmsService smsService;

    @ApiOperation("发送短信验证")
    @PostMapping("sendMessage")
    public ResultVO sendMessage(String phone) {
        boolean result = smsService.sendMessage(phone);
        AssertUtil.isTrue(result, "服务器出错啦！");
        return ResultVO.success(null);
    }
}
