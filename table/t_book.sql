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

 Date: 01/04/2022 18:15:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `pageCount` int NULL DEFAULT NULL,
  `genre` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ISBN` char(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('1fb5bfa64f644d12ad880fe197eb9174', 'book_3', 30.00, 300, 'Comic', '978-3442267747');
INSERT INTO `t_book` VALUES ('28d7da1185e249b69c1970abdae2e08c', '123', 123.00, 123, '123', '123');
INSERT INTO `t_book` VALUES ('4259d13859a947fb84a8cc579f6531d1', 'book_4', 40.00, 100, 'Fantasy', '978-3608963762');
INSERT INTO `t_book` VALUES ('60fd21d06df94ead909117b605a60fb3', 'book_2', 20.00, 200, 'Biography', '978-3442267819');
INSERT INTO `t_book` VALUES ('9e14185518ad4dd4a7cbd9f5a89d811b', 'book_5', 50.00, 100, 'Comic', '978-758245159');
INSERT INTO `t_book` VALUES ('9f63bfa1717849dda27a18f166c00670', 'book_1', 10.00, 100, 'Adventure', '978-3841335180');

SET FOREIGN_KEY_CHECKS = 1;
