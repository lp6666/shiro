/*
Navicat MySQL Data Transfer

Source Server         : attendance
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : security

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-16 16:04:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `roles_permissions`
-- ----------------------------
DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission` varchar(20) DEFAULT NULL,
  `role_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles_permissions
-- ----------------------------
INSERT INTO `roles_permissions` VALUES ('1', 'user:delete', 'user');

-- ----------------------------
-- Table structure for `test_user`
-- ----------------------------
DROP TABLE IF EXISTS `test_user`;
CREATE TABLE `test_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_user
-- ----------------------------
INSERT INTO `test_user` VALUES ('1', 'xiaoming', '48e231e66ff8943db0f6d2b6cb6536d2');

-- ----------------------------
-- Table structure for `test_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `test_user_role`;
CREATE TABLE `test_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `role_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_user_role
-- ----------------------------
INSERT INTO `test_user_role` VALUES ('1', 'xiaoming', 'user');

-- ----------------------------
-- Procedure structure for `queryMsgById`
-- ----------------------------
DROP PROCEDURE IF EXISTS `queryMsgById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `queryMsgById`(in id int,out counts int)
BEGIN
select COUNT(*) INTO counts from project where project_id=id ;
end
;;
DELIMITER ;
