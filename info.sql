/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : boss

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-07-19 15:42:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job` varchar(50) DEFAULT NULL,
  `salary` varchar(50) DEFAULT NULL,
  `company` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES ('72', 'Python', '15.5', '软通动力');
INSERT INTO `info` VALUES ('73', 'Python', '12.5', '上海易宝软件有限公司深圳分公司');
INSERT INTO `info` VALUES ('74', 'Python', '13.5', '纬创软件');
INSERT INTO `info` VALUES ('75', 'Python', '7.0', '筑梦园');
INSERT INTO `info` VALUES ('76', 'python', '9.5', '深圳中软国际');
INSERT INTO `info` VALUES ('77', 'Python', '16.0', '富士康');
INSERT INTO `info` VALUES ('78', 'python', '15.0', '软通动力');
INSERT INTO `info` VALUES ('79', 'python', '10.5', '中软国际');
INSERT INTO `info` VALUES ('80', 'Python', '25.0', '腾讯');
INSERT INTO `info` VALUES ('81', 'python', '15.0', '软通动力');
INSERT INTO `info` VALUES ('82', 'Python讲师', '9.5', '武汉尚云客');
INSERT INTO `info` VALUES ('83', 'python', '11.0', '韶关市立诚咨询服...');
INSERT INTO `info` VALUES ('84', 'Python', '15.5', '万得');
INSERT INTO `info` VALUES ('85', 'python', '13.0', '绛门科技');
INSERT INTO `info` VALUES ('86', 'python', '9.0', '绛门科技');
INSERT INTO `info` VALUES ('87', 'python讲师', '25.0', '中公教育');
INSERT INTO `info` VALUES ('88', 'python', '15.0', '博彦科技');
INSERT INTO `info` VALUES ('89', 'Python', '20.0', '软通动力');
INSERT INTO `info` VALUES ('90', 'python讲师', '8.5', '傲梦网络科技');
INSERT INTO `info` VALUES ('91', 'python', '15.0', '京北方');
INSERT INTO `info` VALUES ('92', 'Python开发', '17.0', '软通动力');
INSERT INTO `info` VALUES ('93', 'python', '13.5', '中软国际');
INSERT INTO `info` VALUES ('94', 'Python讲师', '9.0', '傲梦网络科技');
INSERT INTO `info` VALUES ('95', 'Python', '27.0', '安恒信息');
INSERT INTO `info` VALUES ('96', 'python讲师', '8.0', '傲梦网络科技');
INSERT INTO `info` VALUES ('97', 'python讲师', '7.0', '中软');
INSERT INTO `info` VALUES ('98', 'Python讲师', '7.5', '傲梦网络科技');
INSERT INTO `info` VALUES ('99', 'Python', '16.0', '万得');
INSERT INTO `info` VALUES ('100', 'Python', '8.0', '双马塑业');
INSERT INTO `info` VALUES ('101', 'Python', '21.0', '软通动力');
INSERT INTO `info` VALUES ('102', 'python讲师', '8.5', '傲梦网络科技');
INSERT INTO `info` VALUES ('103', 'python讲师', '6.5', '傲梦网络科技');
INSERT INTO `info` VALUES ('104', 'python爬虫', '16.0', '中新赛克');
INSERT INTO `info` VALUES ('105', 'Python', '15.0', '软通动力');
INSERT INTO `info` VALUES ('106', 'Python', '19.0', '软通动力');
INSERT INTO `info` VALUES ('107', 'Python', '30.0', 'Aibee');
INSERT INTO `info` VALUES ('108', 'Python', '27.5', '旷视MEGVII');
INSERT INTO `info` VALUES ('109', 'Python', '27.5', '土豆雅思');
INSERT INTO `info` VALUES ('110', 'Python', '12.5', '软通动力信息技术集团');
INSERT INTO `info` VALUES ('111', 'Python', '22.5', '安恒信息');
INSERT INTO `info` VALUES ('112', 'Python工程师', '15.0', '九次方大数据');
INSERT INTO `info` VALUES ('113', 'Python', '4.0', '国金科技');
INSERT INTO `info` VALUES ('114', 'python', '12.5', '富士康');
INSERT INTO `info` VALUES ('115', 'Python', '37.5', '蚂蚁金服');
INSERT INTO `info` VALUES ('116', 'python讲师', '8.0', '傲梦网络科技');
INSERT INTO `info` VALUES ('117', 'python', '17.5', '软通动力');
INSERT INTO `info` VALUES ('118', 'Python工程师', '27.5', '融360');
INSERT INTO `info` VALUES ('119', 'python开发', '21.0', '软通动力');
INSERT INTO `info` VALUES ('120', 'python', '13.5', '中软国际');
INSERT INTO `info` VALUES ('121', 'python开发工程师', '11.5', '中软国际');
INSERT INTO `info` VALUES ('122', 'python', '12.5', '兴融联科技');
INSERT INTO `info` VALUES ('123', 'Python讲师', '7.5', '傲梦网络科技');
INSERT INTO `info` VALUES ('124', 'python老师', '8.5', '傲梦网络科技');
INSERT INTO `info` VALUES ('125', 'python', '14.0', '韶关市立诚咨询服...');
INSERT INTO `info` VALUES ('126', 'Python开发工程师', '15.0', '南京苏宁软件');
INSERT INTO `info` VALUES ('127', 'Python', '15.0', '新华三技术有限公司');
INSERT INTO `info` VALUES ('128', 'Python工程师', '12.0', '优尔');
INSERT INTO `info` VALUES ('129', 'Python', '17.5', '世通亨奇');
INSERT INTO `info` VALUES ('130', 'Python', '12.5', '中软国际');
INSERT INTO `info` VALUES ('131', 'Python', '8.5', '元拓科技');
