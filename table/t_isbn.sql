/*
 Navicat MySQL Data Transfer

 Source Server         : demo
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 01/04/2022 18:15:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_isbn
-- ----------------------------
DROP TABLE IF EXISTS `t_isbn`;
CREATE TABLE `t_isbn`  (
  `ISBN` char(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`ISBN`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_isbn
-- ----------------------------
INSERT INTO `t_isbn` VALUES ('123');
INSERT INTO `t_isbn` VALUES ('978-3442267747');
INSERT INTO `t_isbn` VALUES ('978-3442267819');
INSERT INTO `t_isbn` VALUES ('978-3608963762');
INSERT INTO `t_isbn` VALUES ('978-3841335180');
INSERT INTO `t_isbn` VALUES ('978-758245159');

SET FOREIGN_KEY_CHECKS = 1;
