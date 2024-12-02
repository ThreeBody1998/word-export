/*
 Navicat Premium Dump SQL

 Source Server         : 192.168.1.9
 Source Server Type    : MySQL
 Source Server Version : 50736 (5.7.36)
 Source Host           : 192.168.1.9:3306
 Source Schema         : word_export

 Target Server Type    : MySQL
 Target Server Version : 50736 (5.7.36)
 File Encoding         : 65001

 Date: 02/12/2024 17:13:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `uuid` varchar(50) NOT NULL COMMENT '主键',
  `relation_id` varchar(50) DEFAULT NULL COMMENT '关联ID',
  `file_name` varchar(100) DEFAULT NULL COMMENT '文件名',
  `status` tinyint(1) DEFAULT NULL COMMENT '文件状态',
  `type` tinyint(2) DEFAULT NULL COMMENT '文件类型',
  `save_path` varchar(100) DEFAULT NULL COMMENT '存储路径',
  `is_delete` tinyint(1) DEFAULT NULL COMMENT '假删除的标志',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_time` varchar(20) DEFAULT NULL COMMENT '更新时间',
  `update_user` varchar(255) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件表';

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
  `uuid` varchar(50) NOT NULL COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `birth_day` varchar(20) DEFAULT NULL COMMENT '出生年月',
  `nation` varchar(10) DEFAULT NULL COMMENT ' 民族',
  `political_status` tinyint(2) DEFAULT NULL COMMENT '政治面貌',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话',
  `graduation_school` varchar(20) DEFAULT NULL COMMENT '毕业院校',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `educational_level` tinyint(2) DEFAULT NULL COMMENT '学历',
  `profile_picture_url` varchar(100) DEFAULT NULL COMMENT '头像地址',
  `address` varchar(200) DEFAULT NULL COMMENT '住址',
  `job_intention` varchar(50) DEFAULT NULL COMMENT '求职意向',
  `educational_background` varchar(500) DEFAULT NULL COMMENT '教育背景',
  `internship_experience` varchar(255) DEFAULT NULL COMMENT '实习经历',
  `campus_practice` varchar(500) DEFAULT NULL COMMENT '校内实践',
  `skills_certificate` varchar(500) DEFAULT NULL COMMENT '技能证书',
  `self_evaluation` varchar(300) DEFAULT NULL COMMENT '自我评价',
  `is_delete` tinyint(1) DEFAULT NULL COMMENT '假删除的标志',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_time` varchar(20) DEFAULT NULL COMMENT '更新时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简历表';

SET FOREIGN_KEY_CHECKS = 1;
