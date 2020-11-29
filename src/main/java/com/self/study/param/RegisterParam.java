package com.self.study.param;

import com.self.study.validator.Phone;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;


/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 10:59
 * @description:
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterParam {
    @Phone(message = "手机号格式错误！")
    @ApiModelProperty("电话")
    private String phone;
    @NotEmpty(message = "密码不能为空！")
    @ApiModelProperty("密码")
    private String password;
    @NotEmpty(message = "用户昵称不能为空！")
    @ApiModelProperty("昵称")
    private String nickname;
    @NotEmpty(message = "验证码不能为空！")
    @ApiModelProperty("验证码")
    private String code;
}
