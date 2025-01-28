-- ----------------------------
-- Table structure for tbl_order
-- ----------------------------
DROP DATABASE IF EXISTS seata_order;
CREATE DATABASE seata_order CHARACTER SET UTF8;
USE seata_order;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS `tbl_order`;
CREATE TABLE `tbl_order`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count` int(0) NULL DEFAULT 0,
  `amount` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


-- ----------------------------
-- Table structure for tbl_account
-- ----------------------------

DROP DATABASE IF EXISTS seata_account;
CREATE DATABASE seata_account CHARACTER SET UTF8;
USE seata_account;


DROP TABLE IF EXISTS `tbl_account`;
CREATE TABLE `tbl_account`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `balance` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_account
-- ----------------------------
INSERT INTO `tbl_account` VALUES (1, '101', 10000);

SET FOREIGN_KEY_CHECKS = 1;


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_repo
-- ----------------------------

DROP DATABASE IF EXISTS seata_repo;
CREATE DATABASE seata_repo CHARACTER SET UTF8;
USE seata_repo;


DROP TABLE IF EXISTS `tbl_repo`;
CREATE TABLE `tbl_repo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `product_code`(`product_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_repo
-- ----------------------------
INSERT INTO `tbl_repo` VALUES (1, '键盘', 'GP20121212001', 1000);
INSERT INTO `tbl_repo` VALUES (2, '抱枕', 'GP20121212002', 300);

SET FOREIGN_KEY_CHECKS = 1;
