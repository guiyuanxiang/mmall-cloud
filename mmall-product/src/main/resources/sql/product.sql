/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : mmall_product

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-11 18:05:47
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`
(
  `id`          int(11)        NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `category_id` int(11)        NOT NULL COMMENT '分类id,对应mmall_category表的主键',
  `name`        varchar(100)   NOT NULL COMMENT '商品名称',
  `subtitle`    varchar(200)            DEFAULT NULL COMMENT '商品副标题',
  `price`       decimal(20, 2) NOT NULL COMMENT '价格,单位-元保留两位小数',
  `stock`       int(11)        NOT NULL DEFAULT '0' COMMENT '库存数量',
  `status`      int(6)                  DEFAULT '1' COMMENT '商品状态.1-在售 2-下架 3-删除',
  `is_del`      int(11)        NOT NULL COMMENT '是否删除 0-未删除 1-已删除',
  `create_time` datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 30
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `product_blob`;
CREATE TABLE `product_blob`
(
  `id`          int(11)  NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `main_image`  varchar(500)      DEFAULT NULL COMMENT '产品主图,url相对地址',
  `sub_images`  text COMMENT '图片地址,json格式,扩展用',
  `detail`      text COMMENT '商品详情',
  `is_del`      int(11)  NOT NULL COMMENT '是否删除 0-未删除 1-已删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 30
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `product_sku`;
CREATE TABLE `product_sku`
(
  `id`                   int(11)        NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `color`                varchar(500)            DEFAULT NULL COMMENT '颜色',
  `packing`              int(11) COMMENT '包装 1-盒装 2-箱装 3-罐装 4-袋装 5-散装 6-联装',
  `specifications_type`  int(11) COMMENT '规格类型 1-毫升 2-克 3-个 ',
  `specifications_value` int(11) COMMENT '规格',
  `seller_code`          varchar(500)            DEFAULT NULL COMMENT '商家编码',
  `price`                decimal(20, 2) NOT NULL COMMENT '价格,单位-元保留两位小数',
  `is_del`               int(11)        NOT NULL COMMENT '是否删除 0-未删除 1-已删除',
  `create_time`          datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time`          datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 30
  DEFAULT CHARSET = utf8;