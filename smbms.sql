/*
 Navicat Premium Data Transfer

 Source Server         : zhangwei
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3306
 Source Schema         : smbms

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 03/07/2020 18:06:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for smbms_bill
-- ----------------------------
DROP TABLE IF EXISTS `smbms_bill`;
CREATE TABLE `smbms_bill`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `billCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '账单编码',
  `productName` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `productDesc` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品描述',
  `productUnit` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '单位',
  `productCount` decimal(20, 2) DEFAULT NULL COMMENT '商品数量',
  `totalPrice` decimal(20, 2) DEFAULT NULL COMMENT '账单总金额',
  `isPayment` int(10) DEFAULT NULL COMMENT '是否付款（1 已支付 0 未支付）',
  `providerId` int(20) DEFAULT NULL COMMENT '供应商ID',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `createdBy` int(20) DEFAULT NULL COMMENT '创建者',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  `modifyBy` int(20) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of smbms_bill
-- ----------------------------
INSERT INTO `smbms_bill` VALUES (1, '1', '北大高考模拟卷', '北京大学的高考模拟卷', '吨', 10.00, 10000.00, 1, 1, '2016-10-28 20:28:30', 1, '2016-10-28 23:04:04', 6);
INSERT INTO `smbms_bill` VALUES (2, '1', '浙大高考模拟卷', '浙江大学的高考模拟卷', '吨', 20.00, 20000.00, 1, 2, '2016-10-28 20:33:43', 1, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (3, '1', '武大高考模拟卷', '武汉大学的高考模拟卷', '吨', 30.00, 30000.00, 1, 3, '2016-10-28 20:38:31', 1, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (4, '1', '复旦高考模拟卷', '复旦大学的高考模拟卷', '吨', 40.00, 40000.00, 1, 4, '2020-07-09 15:06:12', 1, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (5, '1', '南大高考模拟机', '南京大学的高考模拟机', '吨', 50.00, 50000.00, 1, 5, '2020-07-09 15:06:12', 1, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (6, '2', '武大高考模拟卷', '武汉大学的高考模拟卷', '吨', 10.00, 10000.00, 1, 3, '2016-10-28 20:28:30', 2, '2016-10-28 23:04:04', 6);
INSERT INTO `smbms_bill` VALUES (7, '2', '复旦高考模拟卷', '复旦大学的高考模拟卷', '吨', 20.00, 20000.00, 1, 4, '2016-10-28 20:33:43', 2, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (8, '2', '南大高考模拟机', '南京大学的高考模拟机', '吨', 30.00, 30000.00, 1, 5, '2016-10-28 20:38:31', 2, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (9, '2', '上交高考模拟卷', '上海交通大学的高考模拟卷', '吨', 40.00, 40000.00, 1, 6, '2020-07-09 15:06:12', 2, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (10, '2', '华科高考模拟机', '华中科技大学的高考模拟机', '吨', 50.00, 50000.00, 1, 7, '2020-07-09 15:06:12', 2, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (11, '3', '南大高考模拟机', '南京大学的高考模拟机', '吨', 10.00, 10000.00, 1, 5, '2016-10-28 20:28:30', 3, '2016-10-28 23:04:04', 6);
INSERT INTO `smbms_bill` VALUES (12, '3', '上交高考模拟卷', '上海交通大学的高考模拟卷', '吨', 20.00, 20000.00, 1, 6, '2016-10-28 20:33:43', 3, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (13, '3', '华科高考模拟机', '华中科技大学的高考模拟机吨', '吨', 30.00, 30000.00, 1, 7, '2016-10-28 20:38:31', 3, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (14, '3', '哈工高考模拟卷', '哈尔滨工业大学的高考模拟卷', '吨', 40.00, 40000.00, 1, 8, '2020-07-09 15:06:12', 3, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (15, '3', '中科高考模拟机', '中国科学技术大学的高考模拟机', '吨', 50.00, 50000.00, 1, 9, '2020-07-09 15:06:12', 3, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (16, '4', '华科高考模拟机', '华中科技大学的高考模拟机', '吨', 10.00, 10000.00, 1, 7, '2016-10-28 20:28:30', 4, '2016-10-28 23:04:04', 6);
INSERT INTO `smbms_bill` VALUES (17, '4', '哈工高考模拟卷', '哈尔滨工业大学的高考模拟卷', '吨', 20.00, 20000.00, 1, 8, '2016-10-28 20:33:43', 4, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (18, '4', '中科高考模拟机', '中国科学技术大学的高考模拟机', '吨', 30.00, 30000.00, 1, 9, '2016-10-28 20:38:31', 4, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (19, '4', '人大高考模拟卷', '中国人民大学的高考模拟卷', '吨', 40.00, 40000.00, 1, 10, '2020-07-09 15:06:12', 4, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (20, '4', '北大高考模拟机', '北京大学的高考模拟机', '吨', 50.00, 50000.00, 1, 1, '2020-07-09 15:06:12', 4, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (21, '5', '中科高考模拟机', '中国科学技术大学的高考模拟机', '吨', 10.00, 10000.00, 1, 9, '2016-10-28 20:28:30', 5, '2016-10-28 23:04:04', 6);
INSERT INTO `smbms_bill` VALUES (22, '5', '人大高考模拟卷', '中国人民大学的高考模拟卷', '吨', 20.00, 20000.00, 1, 10, '2016-10-28 20:33:43', 5, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (23, '5', '北大高考模拟机', '北京大学的高考模拟机', '吨', 30.00, 30000.00, 1, 1, '2016-10-28 20:38:31', 5, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (24, '5', '浙大高考模拟卷', '浙江大学大学的高考模拟卷', '吨', 40.00, 40000.00, 1, 2, '2020-07-09 15:06:12', 5, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (25, '5', '武大高考模拟机', '武汉大学的高考模拟机', '吨', 50.00, 50000.00, 1, 3, '2020-07-09 15:06:12', 5, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (26, '6', '浙大高考模拟卷', '浙江大学大学的高考模拟卷', '吨', 10.00, 10000.00, 1, 2, '2016-10-28 20:28:30', 6, '2016-10-28 23:04:04', 6);
INSERT INTO `smbms_bill` VALUES (27, '6', '复旦高考模拟卷', '复旦大学的高考模拟卷', '吨', 20.00, 20000.00, 0, 4, '2016-10-28 20:33:43', 6, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (28, '6', '上交高考模拟卷', '上海交通大学的高考模拟卷', '吨', 30.00, 30000.00, 0, 6, '2016-10-28 20:38:31', 6, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (29, '6', '哈工高考模拟卷', '哈尔滨工业大学的高考模拟卷', '吨', 40.00, 40000.00, 0, 8, '2020-07-09 15:06:12', 6, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (30, '6', '人大高考模拟卷', '中国人民大学的高考模拟卷', '吨', 50.00, 50000.00, 0, 10, '2020-07-09 15:06:12', 6, NULL, NULL);
INSERT INTO `smbms_bill` VALUES (31, NULL, '清华大学高考资料', NULL, '吨', 100.00, NULL, 0, 5, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for smbms_provider
-- ----------------------------
DROP TABLE IF EXISTS `smbms_provider`;
CREATE TABLE `smbms_provider`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `proCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商编码',
  `proName` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商名称',
  `proDesc` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商描述信息',
  `proContact` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商联系人',
  `proPhone` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `proAddress` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
  `proFax` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '传真',
  `createdBy` int(20) DEFAULT NULL COMMENT '创建者（userId）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` int(20) DEFAULT NULL COMMENT '更新者',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of smbms_provider
-- ----------------------------
INSERT INTO `smbms_provider` VALUES (1, '1', '北大', '北京大学', '北大校长', '11111111111', '北京', '1111', 1, '2014-02-12 00:00:00', 6, '2016-10-28 22:54:36');
INSERT INTO `smbms_provider` VALUES (2, '2', '浙大', '浙江大学', '浙大校长', '22222222222', '浙江', '2222', 2, '2014-02-12 00:00:00', NULL, NULL);
INSERT INTO `smbms_provider` VALUES (3, '3', '武大', '武汉大学', '武大校长', '33333333333', '武汉', '3333', 3, '2014-02-12 00:00:00', 6, '2016-10-28 22:54:36');
INSERT INTO `smbms_provider` VALUES (4, '4', '复旦', '复旦大学', '复旦校长', '44444444444', '上海', '4444', 4, '2014-02-12 00:00:00', NULL, NULL);
INSERT INTO `smbms_provider` VALUES (5, '5', '南京', '南京大学', '南大校长', '55555555555', '南京', '5555', 5, '2014-02-12 00:00:00', 6, '2016-10-28 22:54:36');
INSERT INTO `smbms_provider` VALUES (6, '6', '上交', '上海交通大学', '上交校长', '66666666666', '上海', '6666', 6, '2014-02-12 00:00:00', NULL, NULL);
INSERT INTO `smbms_provider` VALUES (7, '7', '华科', '华中科技大学', '华科校长', '77777777777', '武汉', '7777', 1, '2014-02-12 00:00:00', 6, '2016-10-28 22:54:36');
INSERT INTO `smbms_provider` VALUES (8, '8', '哈工', '哈尔滨工业大学', '哈工校长', '88888888888', '哈尔滨', '8888', 2, '2014-02-12 00:00:00', NULL, NULL);
INSERT INTO `smbms_provider` VALUES (9, ',9', '中科', '	中国科学技术大学', '中科大校长', '99999999999', '北京', '9999', 3, '2014-02-12 00:00:00', 6, '2016-10-28 22:54:36');
INSERT INTO `smbms_provider` VALUES (10, '10', '人大', '中国人民大学', '人大校长', '10101010101', '北京', '1010', 4, '2014-02-12 00:00:00', NULL, NULL);

-- ----------------------------
-- Table structure for smbms_user
-- ----------------------------
DROP TABLE IF EXISTS `smbms_user`;
CREATE TABLE `smbms_user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户编码',
  `userName` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名称',
  `userPassword` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户密码',
  `gender` int(10) DEFAULT NULL COMMENT '性别（1 男 2 女）',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机',
  `address` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
  `userType` int(10) DEFAULT NULL COMMENT '用户类型（1 系统管理员 2 经理 3 普通员工 ）',
  `createdBy` int(20) DEFAULT NULL COMMENT '创建者（userId）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` int(20) DEFAULT NULL COMMENT '更新者（userId）',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of smbms_user
-- ----------------------------
INSERT INTO `smbms_user` VALUES (1, '1', '张三', '333333', 1, '2020-07-02', '13523456789', '武汉', 2, 1, '2020-06-28 19:33:02', 1, '2020-07-02 15:53:18');
INSERT INTO `smbms_user` VALUES (2, '2', '李四', '444444', 1, '2016-10-04', '13523456789', '黄石', 2, 2, '2020-06-29 20:39:15', NULL, NULL);
INSERT INTO `smbms_user` VALUES (3, '3', '王五', '555555', 2, '2013-10-15', '13123456789', '武汉', 2, 6, '2020-06-30 23:06:25', 6, '2016-10-18 23:08:38');
INSERT INTO `smbms_user` VALUES (4, '4', '小刘', '666666', 2, '2013-10-15', '13123456789', '宜昌', 1, 2, '2020-07-01 23:06:25', NULL, NULL);
INSERT INTO `smbms_user` VALUES (5, '5', '小何', '111111', 2, '2013-10-15', '13123456789', '荆门', 2, 6, '2020-07-02 23:06:25', NULL, NULL);
INSERT INTO `smbms_user` VALUES (6, '6', '小陈', '222222', 1, '2013-10-15', '13123456789', '黄冈', 2, 6, '2020-07-03 23:06:25', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
