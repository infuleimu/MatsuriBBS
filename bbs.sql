/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : bbs

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 20/06/2019 16:19:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `announcement_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `followerId` int(11) NOT NULL,
  `followDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uid`(`uid`, `followerId`) USING BTREE,
  INDEX `followerId`(`followerId`) USING BTREE,
  CONSTRAINT `follow_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `follow_ibfk_2` FOREIGN KEY (`followerId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for main_section
-- ----------------------------
DROP TABLE IF EXISTS `main_section`;
CREATE TABLE `main_section`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of main_section
-- ----------------------------
INSERT INTO `main_section` VALUES (1, '弟弟');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `receive_uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  `status` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `postDate` datetime(0) NULL DEFAULT NULL,
  `type` int(1) NOT NULL,
  `replyNum` int(11) NULL DEFAULT NULL,
  `viewNum` int(11) NULL DEFAULT NULL,
  `likeNum` int(11) NULL DEFAULT NULL,
  `isTop` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sid`(`sid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `sub_section` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `post_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (1, 1, 3, '嘻嘻哈哈', '喂喂喂', '2019-06-04 00:00:00', 0, 0, 0, 0, 0);
INSERT INTO `post` VALUES (2, 2, 1, 'test', 'nmsl', '2019-06-11 19:18:39', 0, 0, 0, 0, 0);
INSERT INTO `post` VALUES (3, 3, 1, '测试', '测试', '2019-06-11 18:56:29', 0, 0, 0, 0, 0);
INSERT INTO `post` VALUES (4, 1, 1, '测试测试', '测试测试', '2019-06-11 19:24:34', 1, 0, 0, 0, 0);
INSERT INTO `post` VALUES (5, 1, 1, '发帖测试', '发帖测试', '2019-06-18 07:30:18', 2, 0, 0, 0, 1);

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `replyDate` datetime(0) NULL DEFAULT NULL,
  `likeNum` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `pid`(`pid`) USING BTREE,
  CONSTRAINT `reply_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `reply_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES (1, 2, 1, '傻逼楼主,nmsl', '2019-06-10 16:00:43', 0);
INSERT INTO `reply` VALUES (2, 1, 1, '你说你妈呢', '2019-06-10 16:02:43', 0);
INSERT INTO `reply` VALUES (3, 3, 1, '看戏看戏', '2019-06-10 16:19:36', 0);
INSERT INTO `reply` VALUES (4, 2, 1, 'wcnm', '2019-06-10 20:20:53', 0);
INSERT INTO `reply` VALUES (6, 3, 1, '灌水测试02', '2019-06-11 16:42:50', 0);
INSERT INTO `reply` VALUES (7, 3, 1, '灌水测试03', '2019-06-11 16:44:17', 0);
INSERT INTO `reply` VALUES (10, 1, 1, '回复测试01', '2019-06-18 13:52:35', 0);

-- ----------------------------
-- Table structure for sub_reply
-- ----------------------------
DROP TABLE IF EXISTS `sub_reply`;
CREATE TABLE `sub_reply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `replyDate` datetime(0) NULL DEFAULT NULL,
  `likeNum` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  CONSTRAINT `sub_reply_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `sub_reply_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `reply` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sub_reply
-- ----------------------------
INSERT INTO `sub_reply` VALUES (1, 3, 1, '吃瓜', '2019-06-10 19:47:02', 0);
INSERT INTO `sub_reply` VALUES (2, 2, 1, 'sb', '2019-06-10 21:04:33', 0);
INSERT INTO `sub_reply` VALUES (3, 1, 1, '???', '2019-06-10 23:48:54', 0);
INSERT INTO `sub_reply` VALUES (4, 2, 1, '¿', '2019-06-09 23:49:12', 0);
INSERT INTO `sub_reply` VALUES (5, 3, 2, 'zaima?', '2019-06-11 15:40:26', 0);
INSERT INTO `sub_reply` VALUES (6, 1, 2, '???什么鬼', '2019-06-11 15:40:50', 0);
INSERT INTO `sub_reply` VALUES (7, 2, 2, '认真的?', '2019-06-11 16:26:24', 0);

-- ----------------------------
-- Table structure for sub_section
-- ----------------------------
DROP TABLE IF EXISTS `sub_section`;
CREATE TABLE `sub_section`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) NOT NULL,
  `title` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `mid`(`mid`) USING BTREE,
  CONSTRAINT `sub_section_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `main_section` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sub_section
-- ----------------------------
INSERT INTO `sub_section` VALUES (1, 1, '弟弟时刻', NULL);
INSERT INTO `sub_section` VALUES (2, 1, '弟弟心声', NULL);
INSERT INTO `sub_section` VALUES (3, 1, '弟弟杂谈', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `regDate` datetime(0) NULL DEFAULT NULL,
  `admin` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', '女', NULL, '100000@qq.com', '18078060977', '2019-06-04 16:42:53', '1');
INSERT INTO `user` VALUES (2, '1702040031', '123456', '男', NULL, '1200000@qq.com', '18078060978', '2019-06-04 16:54:37', '0');
INSERT INTO `user` VALUES (3, '迪克', '123456', '男', NULL, '100124@qq.com', '18078060979', '2019-06-10 16:20:37', '1');
INSERT INTO `user` VALUES (4, 'yuge', '123456', '男', NULL, '1660213@qq.com', NULL, '2019-06-12 09:17:41', '\0');

-- ----------------------------
-- Table structure for user_collection
-- ----------------------------
DROP TABLE IF EXISTS `user_collection`;
CREATE TABLE `user_collection`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `collectionDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `pid&uid`(`pid`, `uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_collection
-- ----------------------------
INSERT INTO `user_collection` VALUES (1, 1, 1, '2019-06-19 11:40:19');
INSERT INTO `user_collection` VALUES (2, 2, 1, '2019-06-18 11:40:56');
INSERT INTO `user_collection` VALUES (7, 3, 1, NULL);

-- ----------------------------
-- Procedure structure for reply
-- ----------------------------
DROP PROCEDURE IF EXISTS `reply`;
delimiter ;;
CREATE PROCEDURE `reply`(IN pid INT)
BEGIN
	SELECT r.*,u.id,u.userName,u.avatar FROM reply r,user u where r.uid =u.id and r.pid=1 ORDER BY r.replyDate;
	SELECT sr.*,u.id,u.userName,u.avatar FROM reply r,sub_reply sr,user u where sr.rid = r.id and sr.uid =u.id and r.pid=1 ORDER BY sr.replyDate;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for replywhile
-- ----------------------------
DROP PROCEDURE IF EXISTS `replywhile`;
delimiter ;;
CREATE PROCEDURE `replywhile`(IN pid INT)
BEGIN
	DECLARE a INT DEFAULT 0;
	SELECT r.*,u.id,u.userName,u.avatar FROM reply r,user u where r.uid =u.id and r.pid=1 ORDER BY r.replyDate;
	WHILE a<3 DO
			SELECT sr.*,u.id,u.userName,u.avatar FROM sub_reply sr,user u where sr.rid = r.id and sr.uid =u.id and r.pid=1 ORDER BY sr.replyDate;
			SET a = a+1;
	END WHILE;
	
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
