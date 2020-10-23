/*
Navicat MySQL Data Transfer

Source Server         : qmx
Source Server Version : 50642
Source Host           : localhost:3306
Source Database       : studentdb

Target Server Type    : MYSQL
Target Server Version : 50642
File Encoding         : 65001

Date: 2020-12-27 20:57:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `stuscore`
-- ----------------------------
DROP TABLE IF EXISTS `stuscore`;
CREATE TABLE `stuscore` (
  `id` varchar(6) NOT NULL,
  `name` varchar(8) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `score` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stuscore
-- ----------------------------
INSERT INTO `stuscore` VALUES ('600001', '宋皓宇', '男', '71');
INSERT INTO `stuscore` VALUES ('620395', '张一弛', '男', '88');
INSERT INTO `stuscore` VALUES ('800001', '贺楠苏', '男', '86');
INSERT INTO `stuscore` VALUES ('800002', '张梓煜', '男', '83');
INSERT INTO `stuscore` VALUES ('800003', '徐坤', '男', '76');
INSERT INTO `stuscore` VALUES ('800004', '王茂赟', '男', '65');
INSERT INTO `stuscore` VALUES ('800005', '卢爽', '女', '67');
INSERT INTO `stuscore` VALUES ('800007', '李长烨', '男', '55');
INSERT INTO `stuscore` VALUES ('800008', '马馨竹', '女', '98');
INSERT INTO `stuscore` VALUES ('800009', '王梓铭', '男', '92');
INSERT INTO `stuscore` VALUES ('800010', '孙健恺', '男', '100');
INSERT INTO `stuscore` VALUES ('800011', '赵雨萱', '女', '33');
INSERT INTO `stuscore` VALUES ('800012', '李明睿', '男', '56');
INSERT INTO `stuscore` VALUES ('800013', '程云杨', '男', '79');
INSERT INTO `stuscore` VALUES ('800014', '李可欣', '女', '83');
INSERT INTO `stuscore` VALUES ('800015', '李闻天', '男', '78');
INSERT INTO `stuscore` VALUES ('800016', '何朝旭', '男', '88');
INSERT INTO `stuscore` VALUES ('800017', '杨章驰', '男', '89');
INSERT INTO `stuscore` VALUES ('800018', '张浩阳', '男', '83');
INSERT INTO `stuscore` VALUES ('800019', '尹丹彤', '女', '76');
INSERT INTO `stuscore` VALUES ('800020', '孟鸽', '女', '91');
INSERT INTO `stuscore` VALUES ('800021', '吴昌鸿', '男', '82');
INSERT INTO `stuscore` VALUES ('800022', '耿嘉辉', '男', '70');
INSERT INTO `stuscore` VALUES ('800023', '梁鹤飞', '男', '64');
INSERT INTO `stuscore` VALUES ('800024', '李腾飞', '男', '55');
INSERT INTO `stuscore` VALUES ('800025', '张岩', '女', '61');
INSERT INTO `stuscore` VALUES ('800026', '曾永泽', '男', '78');
INSERT INTO `stuscore` VALUES ('800027', '何毅辉', '男', '70');
INSERT INTO `stuscore` VALUES ('800028', '庄伯语', '男', '59');
INSERT INTO `stuscore` VALUES ('800029', '许艺帆', '男', '80');
INSERT INTO `stuscore` VALUES ('800030', '赫明佳', '女', '47');
INSERT INTO `stuscore` VALUES ('800031', '申亦轩', '女', '56');
INSERT INTO `stuscore` VALUES ('800610', '袁立钊', '男', '79');
INSERT INTO `stuscore` VALUES ('810235', '刘晓奇', '男', '78');
