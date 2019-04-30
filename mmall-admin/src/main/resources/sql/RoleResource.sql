-- auto Generated on 2019-04-30
-- DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource`(
	`id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`role_id` BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'roleId',
	`resource_id` BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'resourceId',
	`is_deleted` INT (11) NOT NULL DEFAULT -1 COMMENT 'isDeleted',
	`create_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createTime',
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '`role_resource`';