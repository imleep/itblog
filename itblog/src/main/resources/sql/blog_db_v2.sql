/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50530
Source Host           : localhost:3306
Source Database       : blog_db_v2

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2020-06-30 13:21:13
*/

CREATE DATABASE blog_db_v2;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_blog`
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog` (
  `blogid` char(32) NOT NULL,
  `userid` char(32) NOT NULL,
  `title` char(64) NOT NULL,
  `content` text NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  `display` int(11) NOT NULL COMMENT '0:不可见 |1:可见',
  PRIMARY KEY (`blogid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_blog
-- ----------------------------

-- ----------------------------
-- Table structure for `t_blog_click`
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_click`;
CREATE TABLE `t_blog_click` (
  `blogid` char(32) NOT NULL,
  `userid` char(32) NOT NULL,
  `clicktype` int(11) NOT NULL,
  `clicktime` datetime NOT NULL,
  PRIMARY KEY (`blogid`,`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_blog_click
-- ----------------------------

-- ----------------------------
-- Table structure for `t_blog_read`
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_read`;
CREATE TABLE `t_blog_read` (
  `readid` char(32) NOT NULL,
  `blogid` char(32) NOT NULL,
  `userid` char(32) DEFAULT NULL,
  `readtime` datetime NOT NULL,
  PRIMARY KEY (`readid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_blog_read
-- ----------------------------

-- ----------------------------
-- Table structure for `t_blog_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_type`;
CREATE TABLE `t_blog_type` (
  `typeid` char(32) NOT NULL,
  `parentname` char(32) NOT NULL,
  `typename` char(32) NOT NULL,
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_blog_type
-- ----------------------------
INSERT INTO `t_blog_type` VALUES ('0336af4c16e1566b90020cd51bf37073', '数据库', 'MySQL');
INSERT INTO `t_blog_type` VALUES ('1845fc62833e54648af094b5b2ef9d28', '数据库', 'PostgreSQL');
INSERT INTO `t_blog_type` VALUES ('20bd1ad50d9a5d6289f826102bbe87ca', '框架', 'Mybatis');
INSERT INTO `t_blog_type` VALUES ('34da2b40f7e95a87b468cb9ebf2c8408', '数据库', 'SQL Server');
INSERT INTO `t_blog_type` VALUES ('5dd7737c3b575fe895356689d4184da4', '框架', 'Spring Boot');
INSERT INTO `t_blog_type` VALUES ('6b00ef6cc1e855a3b8ceace5f0e5710e', '编程语言', 'GO');
INSERT INTO `t_blog_type` VALUES ('92ace640e9f65a4abf0ba88451ede450', '框架', 'Spring MVC');
INSERT INTO `t_blog_type` VALUES ('a428105a654551c4be3843f81a1139d7', '框架', 'Struts2');
INSERT INTO `t_blog_type` VALUES ('a5e4cd2064d65f16a41ac1cbe3713125', '编程语言', 'JavaScript');
INSERT INTO `t_blog_type` VALUES ('c530f9e4dd725892b3f8fb6475257fac', '编程语言', 'C/C++');
INSERT INTO `t_blog_type` VALUES ('e4c8c7a541495a3d86991e9688053ece', '编程语言', 'Python');
INSERT INTO `t_blog_type` VALUES ('f05d028e0a55537b9174c1a4a6a01108', '编程语言', 'JAVA');

-- ----------------------------
-- Table structure for `t_file`
-- ----------------------------
DROP TABLE IF EXISTS `t_file`;
CREATE TABLE `t_file` (
  `fileid` char(32) NOT NULL,
  `filetype` char(32) NOT NULL COMMENT 'avatar|appendix|source',
  `filename` char(128) NOT NULL,
  `userid` char(32) NOT NULL,
  `size` bigint(20) NOT NULL,
  `uploadtime` datetime NOT NULL,
  PRIMARY KEY (`fileid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_file
-- ----------------------------
INSERT INTO `t_file` VALUES ('1c542b71075b4354872a1be597a78da1', 'png', '1.png', '831cfa267f8f56a0acbb9dde2cb67108', '12290', '2020-06-29 01:15:17');
INSERT INTO `t_file` VALUES ('23e97b7c95aa40f9a89a3b71d7d75157', 'png', '3.png', '831cfa267f8f56a0acbb9dde2cb67108', '27613', '2020-06-29 01:16:34');
INSERT INTO `t_file` VALUES ('42c9e648a9b547ab828e91007979a47b', 'png', '3.png', '831cfa267f8f56a0acbb9dde2cb67108', '27613', '2020-06-29 01:13:27');
INSERT INTO `t_file` VALUES ('4948d49d923c4d2094cdb6f5e141c301', 'png', '3.png', '831cfa267f8f56a0acbb9dde2cb67108', '27613', '2020-06-29 01:14:45');
INSERT INTO `t_file` VALUES ('d3a4fc0af17f4b89b07541ba89f71ff8', 'png', '3.png', '831cfa267f8f56a0acbb9dde2cb67108', '27613', '2020-06-29 01:16:07');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userid` char(32) NOT NULL,
  `username` char(32) NOT NULL,
  `realname` char(32) NOT NULL,
  `birthday` date NOT NULL,
  `email` char(32) NOT NULL,
  `password` char(32) NOT NULL,
  `avatar` char(32) DEFAULT NULL,
  `registtime` datetime NOT NULL,
  `role` char(16) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('831cfa267f8f56a0acbb9dde2cb67108', 'YK_831c7108', '游客831c7108', '2020-06-28', '831c7108@blog.com', '123123', null, '2020-06-28 00:00:01', '游客');
