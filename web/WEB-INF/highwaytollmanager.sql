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

 Date: 10/10/2019 00:36:49
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
  `balance` float(32, 2) NOT NULL,
  `usedFee` float(32, 2) NOT NULL,
  PRIMARY KEY (`cardNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cardinfo
-- ----------------------------
INSERT INTO `cardinfo` VALUES ('123', '000001', '客车(7座以下)', '皖A-12345', 'temporary', 314.99, 264.30);

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
INSERT INTO `totalfee` VALUES ('2019-10-09 23:14:19', '123', '客车(7座以下)', 26.43, '100001', '110000', '002');
INSERT INTO `totalfee` VALUES ('2019-10-09 23:18:00', '123', '客车(7座以下)', 0.00, '100001', '110000', '002');
INSERT INTO `totalfee` VALUES ('2019-10-08 23:18:25', '123', '客车(7座以下)', 26.43, '190001', '100000', '001');
INSERT INTO `totalfee` VALUES ('2019-10-09 23:19:09', '123', '客车(7座以下)', 26.43, '100001', '110000', '002');
INSERT INTO `totalfee` VALUES ('2019-10-09 23:20:59', '123', '客车(7座以下)', 0.00, '100001', '110000', '002');
INSERT INTO `totalfee` VALUES ('2019-10-09 23:21:19', '123', '客车(7座以下)', 26.43, '100001', '110000', '002');

-- ----------------------------
-- Table structure for trafficinfo
-- ----------------------------
DROP TABLE IF EXISTS `trafficinfo`;
CREATE TABLE `trafficinfo`  (
  `cardNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `startTollBooshNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `startLaneNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `startTime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `endTollBooshNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `endLaneNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `endTime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mileage` float(32, 1) NULL DEFAULT NULL,
  `totalFee` float(32, 2) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trafficinfo
-- ----------------------------
INSERT INTO `trafficinfo` VALUES ('123', '100000', '001', '2019/10/8 21:37:43', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '110000', '002', '2019/10/8 21:38:3', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '100000', '001', '2019/10/8 21:44:10', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '110000', '002', '2019/10/8 21:44:30', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '100000', '001', '2019/10/8 21:50:11', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '110000', '002', '2019/10/8 21:50:27', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '100000', '001', '2019/10/8 22:0:22', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '100000', '001', '2019/10/8 22:14:50', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '110000', '002', '2019/10/8 22:15:18', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '100000', '001', '2019/10/8 22:15:35', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '110000', '002', '2019/10/8 22:15:55', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '100000', '001', '2019/10/9 17:49:17', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '100000', '001', '2019/10/9 18:27:29', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '100000', '001', '2019/10/9 22:5:54', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '100000', '001', '2019-10-09 23:09:13', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '110000', '002', '2019-10-09 23:17:52', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '110000', '002', '2019-10-09 23:18:17', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '100000', '001', '2019-10-09 23:18:58', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '110000', '002', '2019-10-09 23:20:54', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);
INSERT INTO `trafficinfo` VALUES ('123', '100000', '001', '2019-10-09 23:21:08', '110000', '002', '2019-10-09 23:21:19', 75.5, 26.43);

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
INSERT INTO `trafficvolume` VALUES ('110000', '002', '客车(7座以下)', 3);

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
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of worklog
-- ----------------------------
INSERT INTO `worklog` VALUES (0000000001, '100001', '2019-09-01 15:31:39', '2019-09-28 15:31:51', '100000');
INSERT INTO `worklog` VALUES (0000000002, '190001', '2019-09-30 17:20:33', '2019-09-30 22:20:39', '100000');
INSERT INTO `worklog` VALUES (0000000003, '100001', '2019-09-30 17:21:25', '2019-09-30 20:21:28', '100000');
INSERT INTO `worklog` VALUES (0000000004, '100001', '2019-09-30 17:30:54', '2019-09-30 22:30:57', '100000');
INSERT INTO `worklog` VALUES (0000000005, '190001', '2019-10-07 13:37:08', '2019-10-07 13:37:10', '100000');
INSERT INTO `worklog` VALUES (0000000006, '190001', '2019-10-07 22:17:06', '2019-10-07 22:17:07', '100000');
INSERT INTO `worklog` VALUES (0000000007, '190001', '2019-10-08 00:13:40', '2019-10-08 00:13:43', '100000');
INSERT INTO `worklog` VALUES (0000000008, '100001', '2019-10-08 17:02:14', '2019-10-08 21:25:52', '110000');
INSERT INTO `worklog` VALUES (0000000009, '190001', '2019-10-09 15:55:23', '2019-10-09 15:55:30', '100000');

SET FOREIGN_KEY_CHECKS = 1;
