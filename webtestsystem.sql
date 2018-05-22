/*
Navicat MySQL Data Transfer

Source Server         : db01
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : webtestsystem

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-22 17:28:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `exam`
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `ExamId` int(11) NOT NULL,
  `ExamNumber` text,
  `ExamSubject` text,
  `ExamClass` text,
  `ExamTeacher` text,
  `ExamData` text,
  `ExamStatus` text,
  `ExamFileName` text,
  PRIMARY KEY (`ExamId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES ('10', '201500010000', '语文', '2055', '20150001', '2018-05-1500:03:00 - 04:00:00', '未开始', null);
INSERT INTO `exam` VALUES ('15', '201500010001', '化学', '2015', '20150001', '2018-05-2400:02:00 - 04:04:04', '未开始', null);
INSERT INTO `exam` VALUES ('16', '201500010002', '美术', '2015', '20150001', '2018-05-1700:00:00 - 00:00:00', '进行中', null);

-- ----------------------------
-- Table structure for `student_new`
-- ----------------------------
DROP TABLE IF EXISTS `student_new`;
CREATE TABLE `student_new` (
  `StuId` int(11) NOT NULL,
  `StuNumber` text,
  `StuName` text,
  `StuStatus` text,
  `ExamNumber` text,
  `IpAdress` text,
  `UploadFileName` text,
  `UploadFileDate` text,
  PRIMARY KEY (`StuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_new
-- ----------------------------
INSERT INTO `student_new` VALUES ('13', '1510120011', 'Lee11', '离线', '', '0:0:0:0:0:0:0:1', '444.jpg', '2018-05-22 01:20:28');
INSERT INTO `student_new` VALUES ('15', '1510120012', 'Lee12', '离线', null, '0:0:0:0:0:0:0:2', null, null);
INSERT INTO `student_new` VALUES ('16', '1510120013', 'Lee13', '离线', null, '127.0.0.1', null, null);

-- ----------------------------
-- Table structure for `teacher_new`
-- ----------------------------
DROP TABLE IF EXISTS `teacher_new`;
CREATE TABLE `teacher_new` (
  `TeacherId` int(11) NOT NULL,
  `TeacherNumber` text,
  `TeacherName` text,
  `ExamNumber` text,
  `IsAdmin` text,
  `Status` text,
  `UploadFileName` text,
  `UploadFileDate` text,
  PRIMARY KEY (`TeacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_new
-- ----------------------------
INSERT INTO `teacher_new` VALUES ('1', '123456', 'LeeTeacher', '', '否', '离线', null, null);
INSERT INTO `teacher_new` VALUES ('15', '123456', 'admin', null, '是', '离线', null, null);
