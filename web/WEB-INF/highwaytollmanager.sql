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

 Date: 11/10/2019 16:30:54
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
  `cardNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `carType` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberPlate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `balance` float(32, 1) NOT NULL,
  `usedFee` float(32, 1) NOT NULL,
  `cardIssueTollBooshNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cardIssueTollCollectorNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`cardNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cardinfo
-- ----------------------------
INSERT INTO `cardinfo` VALUES ('123', '客车(7座以下)', '皖A-12345', 371.4, 422.9, '', '', '', '', '');

-- ----------------------------
-- Table structure for feerateinfo
-- ----------------------------
DROP TABLE IF EXISTS `feerateinfo`;
CREATE TABLE `feerateinfo`  (
  `roadNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `carType` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fee` float(32, 2) NOT NULL,
  PRIMARY KEY (`roadNo`, `carType`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feerateinfo
-- ----------------------------
INSERT INTO `feerateinfo` VALUES ('000001', '客车(7座以下)', 0.35);
INSERT INTO `feerateinfo` VALUES ('000002', '客车(7座以下)', 0.35);

-- ----------------------------
-- Table structure for laneinfo
-- ----------------------------
DROP TABLE IF EXISTS `laneinfo`;
CREATE TABLE `laneinfo`  (
  `laneNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tollBooshNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `principal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `laneName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of laneinfo
-- ----------------------------
INSERT INTO `laneinfo` VALUES ('001', '100000', '190001', '1车道');
INSERT INTO `laneinfo` VALUES ('002', '110000', '100001', '2车道');

-- ----------------------------
-- Table structure for rechargelog
-- ----------------------------
DROP TABLE IF EXISTS `rechargelog`;
CREATE TABLE `rechargelog`  (
  `time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cardNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tollCollectorNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rechargeAmount` float(32, 1) NOT NULL,
  PRIMARY KEY (`cardNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rechargelog
-- ----------------------------
INSERT INTO `rechargelog` VALUES ('2019-10-11 16:06:13', '123', '190001', 11.0);

-- ----------------------------
-- Table structure for roadinfo
-- ----------------------------
DROP TABLE IF EXISTS `roadinfo`;
CREATE TABLE `roadinfo`  (
  `roadNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `startTollBooshNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `endTollBooshNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `roadMileage` float(32, 1) NOT NULL,
  PRIMARY KEY (`roadNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roadinfo
-- ----------------------------
INSERT INTO `roadinfo` VALUES ('000001', '100000', '110000', 75.5);
INSERT INTO `roadinfo` VALUES ('000002', '110000', '100000', 75.5);

-- ----------------------------
-- Table structure for tollbooshinfo
-- ----------------------------
DROP TABLE IF EXISTS `tollbooshinfo`;
CREATE TABLE `tollbooshinfo`  (
  `tollBooshNo` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numbersOfLane` int(8) NOT NULL,
  `tollBooshName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`tollBooshNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tollbooshinfo
-- ----------------------------
INSERT INTO `tollbooshinfo` VALUES ('100000', 12, '合肥高速收费站');
INSERT INTO `tollbooshinfo` VALUES ('110000', 10, '淮南高速收费站');

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
  `laneNo` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`tollCollectorNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tollcollectorinfo
-- ----------------------------
INSERT INTO `tollcollectorinfo` VALUES ('100001', '110000', 'cxk', '男', '合淮高速收费站', '收费员', '2019-09-29', '123123123', '123123123@123.com', '北京', '002');
INSERT INTO `tollcollectorinfo` VALUES ('190001', '100000', 'zx', '男', '合淮高速收费站', '收费员', '2019-09-01', '1234567891', '222222@qq.com', '安徽合肥', '001');

-- ----------------------------
-- Table structure for totalfee
-- ----------------------------
DROP TABLE IF EXISTS `totalfee`;
CREATE TABLE `totalfee`  (
  `time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cardNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `carType` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fee` float(32, 2) NOT NULL,
  `collectorNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tollBooshNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `laneNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of totalfee
-- ----------------------------
INSERT INTO `totalfee` VALUES ('2019-10-10 17:44:39', '123', '客车(7座以下)', 26.43, '100001', '110000', '002');
INSERT INTO `totalfee` VALUES ('2019-10-10 17:44:55', '123', '客车(7座以下)', 26.43, '190001', '100000', '001');
INSERT INTO `totalfee` VALUES ('2019-10-11 13:42:00', '123', '客车(7座以下)', 26.43, '100001', '110000', '002');

-- ----------------------------
-- Table structure for trafficinfo
-- ----------------------------
DROP TABLE IF EXISTS `trafficinfo`;
CREATE TABLE `trafficinfo`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `cardNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `carType` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `startTollBooshNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `startLaneNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `startTime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `endTollBooshNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `endLaneNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `endTime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mileage` float(32, 1) NULL DEFAULT NULL,
  `totalFee` float(32, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trafficinfo
-- ----------------------------
INSERT INTO `trafficinfo` VALUES (29, '123', '客车(7座以下)', '100000', '001', '2019-10-10 17:44:01', '110000', '002', '2019-10-11 13:42:00', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES (30, '123', '客车(7座以下)', '110000', '002', '2019-10-10 17:44:43', '110000', '002', '2019-10-11 13:42:00', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES (31, '123', '客车(7座以下)', '100000', '001', '2019-10-11 13:41:13', '110000', '002', '2019-10-11 13:42:00', 75.5, 26.43);

-- ----------------------------
-- Table structure for trafficvolume
-- ----------------------------
DROP TABLE IF EXISTS `trafficvolume`;
CREATE TABLE `trafficvolume`  (
  `tollBooshNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `laneNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `carType` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numbersOfPass` int(8) NOT NULL,
  PRIMARY KEY (`tollBooshNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trafficvolume
-- ----------------------------
INSERT INTO `trafficvolume` VALUES ('100000', '001', '客车(7座以下)', 1);
INSERT INTO `trafficvolume` VALUES ('110000', '002', '客车(7座以下)', 2);

-- ----------------------------
-- Table structure for worklog
-- ----------------------------
DROP TABLE IF EXISTS `worklog`;
CREATE TABLE `worklog`  (
  `workLogNo` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tollCollectorNo` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `startWorkTime` datetime(0) NULL DEFAULT NULL,
  `finishWorkTime` datetime(0) NULL DEFAULT NULL,
  `tollBooshNo` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`workLogNo`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of worklog
-- ----------------------------
INSERT INTO `worklog` VALUES (13, '190001', '2019-10-10 17:22:05', '2019-10-10 17:23:12', '100000');
INSERT INTO `worklog` VALUES (14, '190001', '2019-10-10 17:23:18', '2019-10-10 17:23:23', '100000');
INSERT INTO `worklog` VALUES (15, '190001', '2019-10-10 17:23:35', '2019-10-10 17:24:05', '100000');
INSERT INTO `worklog` VALUES (16, '190001', '2019-10-10 17:24:55', '2019-10-10 17:27:47', '100000');
INSERT INTO `worklog` VALUES (17, '190001', '2019-10-10 17:27:49', '2019-10-10 17:28:29', '100000');
INSERT INTO `worklog` VALUES (18, '100001', '2019-10-10 17:28:04', '2019-10-10 17:33:20', '110000');
INSERT INTO `worklog` VALUES (19, '100001', '2019-10-10 17:33:22', '2019-10-10 17:33:23', '110000');
INSERT INTO `worklog` VALUES (20, '190001', '2019-10-10 17:33:35', '2019-10-10 17:33:37', '100000');
INSERT INTO `worklog` VALUES (21, '190001', '2019-10-10 17:33:41', '2019-10-10 17:33:43', '100000');

SET FOREIGN_KEY_CHECKS = 1;
