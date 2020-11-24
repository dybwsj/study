package com.self.study.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 14:15
 * @description:
 */

@Data
public class UserResourcePO {
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "资源名称")
    private String name;

    @ApiModelProperty(value = "资源URL")
    private String url;

    @ApiModelProperty(value = "资源描述")
    private String description;
}
