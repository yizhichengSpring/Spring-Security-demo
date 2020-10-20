/*
 Navicat Premium Data Transfer

 Source Server         : my-test
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 127.0.0.1:3306
 Source Schema         : security-demo

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 20/10/2020 16:01:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'yizhicheng', '123456');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
