/*
 Navicat Premium Data Transfer

 Source Server         : Database
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : highwaytollmanager

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 30/09/2019 21:46:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminNo` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tollCollectorNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `passWord` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`adminNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('190001', '100001', 'admin', 'admin');
INSERT INTO `admin` VALUES ('190004', '190001', '1', '1');

-- ----------------------------
-- Table structure for tollcollectorinfo
-- ----------------------------
DROP TABLE IF EXISTS `tollcollectorinfo`;
CREATE TABLE `tollcollectorinfo`  (
  `tollCollectorNo` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tollBoothNo` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `entryTime` date NOT NULL,
  `phoneNo` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `homeAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`tollCollectorNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tollcollectorinfo
-- ----------------------------
INSERT INTO `tollcollectorinfo` VALUES ('100001', '100000', 'cxk', '男', '合淮高速收费站', '收费员', '2019-09-29', '123123123', '123123123@123.com', '北京');
INSERT INTO `tollcollectorinfo` VALUES ('190001', '100000', 'zx', '男', '合淮高速收费站', '收费员', '2019-09-01', '1234567891', '222222@qq.com', '安徽合肥');

-- ----------------------------
-- Table structure for worklog
-- ----------------------------
DROP TABLE IF EXISTS `worklog`;
CREATE TABLE `worklog`  (
  `workLogNo` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `tollCollectorNo` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `startWorkTime` datetime(0) NULL DEFAULT NULL,
  `finishWorkTime` datetime(0) NULL DEFAULT NULL,
  `tollBooshNo` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`workLogNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of worklog
-- ----------------------------
INSERT INTO `worklog` VALUES (0000000001, '100001', '2019-09-01 15:31:39', '2019-09-28 15:31:51', '100000');
INSERT INTO `worklog` VALUES (0000000002, '190001', '2019-09-30 17:20:33', '2019-09-30 22:20:39', '100000');
INSERT INTO `worklog` VALUES (0000000003, '100001', '2019-09-30 17:21:25', '2019-09-30 20:21:28', '100000');
INSERT INTO `worklog` VALUES (0000000004, '100001', '2019-09-30 17:30:54', '2019-09-30 22:30:57', '100000');

SET FOREIGN_KEY_CHECKS = 1;
