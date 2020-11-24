SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `phone` char(11) DEFAULT NULL COMMENT '电话',
    `password` varchar(64) DEFAULT NULL COMMENT '密码',
    `nickname` varchar(200) DEFAULT NULL COMMENT '昵称',
    `status` int(1) DEFAULT '1' COMMENT '账号启用状态：1.启用 0.禁用',
    primary key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=UTF8 COMMENT='用户表';

INSERT INTO `user` VALUES ('1', '15680735503', '$2a$10$iYuTs3CeureCDP5oBNHvz.n3J.9Q/WuitTTM.R/.GWxKbBoMHEhOC', '杜宇博', '1');
INSERT INTO `user` VALUES ('2', '17761402495', '$2a$10$iYuTs3CeureCDP5oBNHvz.n3J.9Q/WuitTTM.R/.GWxKbBoMHEhOC', '小杜', '1');

DROP TABLE IF EXISTS `user_role_relation`;
CREATE TABLE `user_role_relation` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `user_id` bigint(20) DEFAULT NULL,
    `role_id` bigint(20) DEFAULT NULL,
    primary key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=UTF8 COMMENT='用户角色关系表';

INSERT INTO `user_role_relation` VALUES ('1', '1', '1');
INSERT INTO `user_role_relation` VALUES ('2', '2', '2');

DROP TABLE IF EXISTS `user_resource`;
CREATE TABLE `user_resource` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `name` varchar(200) DEFAULT NULL COMMENT '资源名称',
    `url` varchar(200) DEFAULT NULL COMMENT '资源URL',
    `description` varchar(500) DEFAULT NULL COMMENT '描述',
    primary key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=UTF8 COMMENT='用户资源表';

INSERT INTO `user_resource` VALUES ('1', '2020-02-04 17:04:55', '测试路径', '/test', null);

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(100) DEFAULT NULL COMMENT '名称',
    `description` varchar(500) DEFAULT NULL COMMENT '描述',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `status` int(1) DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
    primary key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=UTF8 COMMENT='用户角色表';

INSERT INTO `user_role` VALUES ('1', '管理员', '最高权限', '2020-02-04 17:04:55', '1');
INSERT INTO `user_role` VALUES ('2', '游客', '最高权限', '2020-02-04 17:04:55', '1');

DROP TABLE IF EXISTS `user_role_resource_relation`;
CREATE TABLE `user_role_resource_relation` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
    `resource_id` bigint(20) DEFAULT NULL COMMENT '资源ID',
     primary key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=UTF8 COMMENT='角色资源关系表';

INSERT INTO `user_role_resource_relation` VALUES ('1', '1', '1');
