/*
 Navicat Premium Data Transfer

 Source Server         : DataBase
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : highwaytollmanager

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 07/10/2019 17:12:35
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
-- Table structure for cardinfo
-- ----------------------------
DROP TABLE IF EXISTS `cardinfo`;
CREATE TABLE `cardinfo`  (
  `cardNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `drivingRecordNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `carType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberPlate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cardType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `balance` float(8, 0) NOT NULL,
  `usedFee` float(8, 0) NOT NULL,
  PRIMARY KEY (`cardNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cardinfo
-- ----------------------------
INSERT INTO `cardinfo` VALUES ('123456789', '000001', 'coach1', '皖A-12345', 'temporary', 100, 0);

-- ----------------------------
-- Table structure for laneinfo
-- ----------------------------
DROP TABLE IF EXISTS `laneinfo`;
CREATE TABLE `laneinfo`  (
  `laneNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tollBooshNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `principal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trafficVolume` int(8) NOT NULL,
  `trafficTime` float(16, 0) NOT NULL,
  `laneName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`laneNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of laneinfo
-- ----------------------------
INSERT INTO `laneinfo` VALUES ('001', '100000', '190001', 0, 0, '1车道');

-- ----------------------------
-- Table structure for tollbooshinfo
-- ----------------------------
DROP TABLE IF EXISTS `tollbooshinfo`;
CREATE TABLE `tollbooshinfo`  (
  `tollBooshNo` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numbersOfLane` int(8) NOT NULL,
  `totalTrafficVolume` int(8) NOT NULL,
  `totalTrafficTime` int(8) NOT NULL,
  `tollBooshName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`tollBooshNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tollbooshinfo
-- ----------------------------
INSERT INTO `tollbooshinfo` VALUES ('100000', 12, 0, 0, '合肥高速收费站');

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
  `laneNo` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`tollCollectorNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tollcollectorinfo
-- ----------------------------
INSERT INTO `tollcollectorinfo` VALUES ('100001', '100000', 'cxk', '男', '合淮高速收费站', '收费员', '2019-09-29', '123123123', '123123123@123.com', '北京', '');
INSERT INTO `tollcollectorinfo` VALUES ('190001', '100000', 'zx', '男', '合淮高速收费站', '收费员', '2019-09-01', '1234567891', '222222@qq.com', '安徽合肥', '');

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of worklog
-- ----------------------------
INSERT INTO `worklog` VALUES (0000000001, '100001', '2019-09-01 15:31:39', '2019-09-28 15:31:51', '100000');
INSERT INTO `worklog` VALUES (0000000002, '190001', '2019-09-30 17:20:33', '2019-09-30 22:20:39', '100000');
INSERT INTO `worklog` VALUES (0000000003, '100001', '2019-09-30 17:21:25', '2019-09-30 20:21:28', '100000');
INSERT INTO `worklog` VALUES (0000000004, '100001', '2019-09-30 17:30:54', '2019-09-30 22:30:57', '100000');
INSERT INTO `worklog` VALUES (0000000005, '190001', '2019-10-07 13:37:08', '2019-10-07 13:37:10', '100000');

-- ----------------------------
-- Table structure for 入站信息表
-- ----------------------------
DROP TABLE IF EXISTS `入站信息表`;
CREATE TABLE `入站信息表`  (
  `收费站编号` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `位置` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `所属路段` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `车道数量` int(8) NOT NULL,
  PRIMARY KEY (`收费站编号`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 班次信息表
-- ----------------------------
DROP TABLE IF EXISTS `班次信息表`;
CREATE TABLE `班次信息表`  (
  `日期` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `收费站编号` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `班次` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `值班姓名` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`日期`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 车辆信息表
-- ----------------------------
DROP TABLE IF EXISTS `车辆信息表`;
CREATE TABLE `车辆信息表`  (
  `车牌号` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `车辆信息` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `路段类型` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `单里程费用` int(8) NOT NULL,
  PRIMARY KEY (`车辆信息`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
