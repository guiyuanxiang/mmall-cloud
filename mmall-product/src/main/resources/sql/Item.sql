-- auto Generated on 2018-12-10 17:28:11 
-- DROP TABLE IF EXISTS item; 
CREATE TABLE item(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
	title VARCHAR (128) NOT NULL DEFAULT '' COMMENT '商品名称',
	item_code VARCHAR (255) NOT NULL DEFAULT '' COMMENT '商品编码',
	bar_code VARCHAR (255) UNIQUE NOT NULL DEFAULT '' COMMENT '商品条码',
	property VARCHAR (255) NOT NULL DEFAULT '' COMMENT '商品属性',
	selling_point VARCHAR (50) NOT NULL DEFAULT '' COMMENT '商品卖点',
	buy_remind VARCHAR (50) NOT NULL DEFAULT '' COMMENT '购买提醒',
	expiration_date DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT '保质期',
	tags VARCHAR (50) NOT NULL DEFAULT '' COMMENT '商品标签',
	category_id INT (11) NOT NULL DEFAULT -1 COMMENT '商品类目id',
	brand_id INT (11) NOT NULL DEFAULT -1 COMMENT '商品品牌id',
	unit_id INT (11) NOT NULL DEFAULT -1 COMMENT '单位id',
	expiration_date_status INT (11) NOT NULL DEFAULT -1 COMMENT '是否有保质期 0-无 1-有',
	item_type INT (11) NOT NULL DEFAULT -1 COMMENT '商品类型 0-实物 1-虚拟类商品比如服务',
	is_present TINYINT (3) NOT NULL DEFAULT 0 COMMENT '是否是赠品 0-不是 1-是',
	is_recycle TINYINT (3) NOT NULL DEFAULT 0 COMMENT '是否放入回收站 0-不是 1-是',
	is_deleted TINYINT (3) NOT NULL DEFAULT 0 COMMENT '1-删除 0-正常',
	create_time DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT '创建时间',
	update_time DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT '修改时间',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'item';
