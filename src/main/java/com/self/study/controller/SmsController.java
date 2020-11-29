package com.self.study.controller;

import com.self.study.common.ResultVO;
import com.self.study.service.SmsService;
import com.self.study.utils.AssertUtil;
import com.self.study.validator.Phone;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author: duyubo
 * @date: 2020年11月26日, 0026 15:38
 * @description:
 */

@Api(tags = "短信验证发送类")
@RestController
@Validated
public class SmsController {

    @Autowired
    private SmsService smsService;

    @ApiOperation("发送短信验证")
    @PostMapping("sendMessage")
    public ResultVO sendMessage(@NotNull(message = "不能空位") @Phone String phone) {
        boolean result = smsService.sendMessage(phone);
        AssertUtil.isTrue(result, "服务器出错啦！");
        return ResultVO.success(null);
    }
}
