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

 Date: 01/04/2022 18:16:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_stock
-- ----------------------------
DROP TABLE IF EXISTS `t_stock`;
CREATE TABLE `t_stock`  (
  `id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `shopId` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `shopName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bookId` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bookTitle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `stock` int NULL DEFAULT NULL,
  `soldout` int NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_stock
-- ----------------------------
INSERT INTO `t_stock` VALUES ('006c9f7bee6f486297f34a85b2269c01', '958033615a5244b4b8a4ba71abd9072b', 'shop_2', '9e14185518ad4dd4a7cbd9f5a89d811b', 'book_5', 95, 5, 110.00);
INSERT INTO `t_stock` VALUES ('1f6bd3f76e664a8dad384ea0693c9bc1', '958033615a5244b4b8a4ba71abd9072b', 'shop_2', '4259d13859a947fb84a8cc579f6531d1', 'book_4', 96, 4, 50.00);
INSERT INTO `t_stock` VALUES ('34486f9b64854ed29d30a6fabb399053', 'cccf83cd8a134a1988dc149c098eae29', 'shop_1', '4259d13859a947fb84a8cc579f6531d1', 'book_4', 100, 0, 90.00);

SET FOREIGN_KEY_CHECKS = 1;
