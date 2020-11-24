package com.self.study.param;

import com.self.study.annotation.Phone;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * @author: duyubo
 * @date: 2020年11月24日, 0024 14:10
 * @description:
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginParam {
    @Phone(message = "手机号格式错误！")
    @ApiModelProperty("手机")
    private String phone;
    @NotEmpty(message = "密码不能为空！")
    @ApiModelProperty("密码")
    private String password;
}
