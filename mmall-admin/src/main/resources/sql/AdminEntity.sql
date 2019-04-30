-- auto Generated on 2019-04-30
-- DROP TABLE IF EXISTS `admin_entity`;
CREATE TABLE `admin`(
	`id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
	`shop_ids` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '对应商户id 因为需求已改为多选 所以存储逗号分隔字符串',
	`role_ids` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '角色编号',
	`role_names` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '角色名称',
	`login_name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '登录名',
	`login_password` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '登录密码',
	`owner` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '所属人',
	`state` INT (11) NOT NULL DEFAULT -1 COMMENT '状态 正常 1,停用 2',
	`create_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT '创建日期',
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
	`is_deleted` INT (11) NOT NULL DEFAULT -1 COMMENT '删除标记',
	`last_login_at` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT '最后登陆日期',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '`admin`';
