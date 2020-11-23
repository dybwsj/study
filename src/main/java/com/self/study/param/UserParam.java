package com.self.study.param;

import com.self.study.annotation.Phone;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 10:59
 * @description:
 */

@Data
public class UserParam {
    @Email(message = "不是一个合法的邮箱！")
    @ApiModelProperty("邮箱")
    private String email;
    @NotEmpty(message = "密码不能为空！")
    @ApiModelProperty("密码")
    private String password;
    @Phone(message = "手机号格式错误！")
    @ApiModelProperty("电话")
    private String phone;
    @NotEmpty(message = "用户昵称不能为空！")
    @ApiModelProperty("昵称")
    private String nickname;
}
