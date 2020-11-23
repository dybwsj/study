package com.self.study.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 11:35
 * @description:  PO ：有时也被称为Data对象，对应数据库中的entity，可以简单认为一个PO对应数据库中的一条记录。
 */

@Data
public class UserPO {
    private Long id;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "电话")
    private String phone;
    @ApiModelProperty(value = "昵称")
    private String nickname;
    @ApiModelProperty(value = "状态")
    private Integer status;
}
