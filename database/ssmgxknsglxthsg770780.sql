/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50160
Source Host           : localhost:3306
Source Database       : ssmgxknsglxthsg770780

Target Server Type    : MYSQL
Target Server Version : 50160
File Encoding         : 65001

Date: 2020-03-08 15:33:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `allusers`
-- ----------------------------
DROP TABLE IF EXISTS `allusers`;
CREATE TABLE `allusers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `cx` varchar(50) DEFAULT '普通管理员',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of allusers
-- ----------------------------
INSERT INTO `allusers` VALUES ('2', 'hsg', 'hsg', '超级管理员', '2020-03-02 20:38:14');

-- ----------------------------
-- Table structure for `banjixinxi`
-- ----------------------------
DROP TABLE IF EXISTS `banjixinxi`;
CREATE TABLE `banjixinxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `banji` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of banjixinxi
-- ----------------------------
INSERT INTO `banjixinxi` VALUES ('2', 'B03', '2020-03-02 20:38:21');
INSERT INTO `banjixinxi` VALUES ('3', 'D01', '2020-03-02 20:38:21');
INSERT INTO `banjixinxi` VALUES ('4', 'E02', '2020-03-02 20:38:21');
INSERT INTO `banjixinxi` VALUES ('5', 'A02', '2020-03-02 20:38:21');
INSERT INTO `banjixinxi` VALUES ('6', 'D03', '2020-03-02 20:38:21');
INSERT INTO `banjixinxi` VALUES ('7', 'AA班', '2020-03-02 22:43:25');

-- ----------------------------
-- Table structure for `gangweixinxi`
-- ----------------------------
DROP TABLE IF EXISTS `gangweixinxi`;
CREATE TABLE `gangweixinxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bumenzhanghao` varchar(50) DEFAULT NULL,
  `bumenmingcheng` varchar(50) DEFAULT NULL,
  `lianxidianhua` varchar(50) DEFAULT NULL,
  `dizhi` varchar(50) DEFAULT NULL,
  `gangwei` varchar(50) DEFAULT NULL,
  `xiangxi` varchar(500) DEFAULT NULL,
  `xueyuanshenhe` varchar(50) DEFAULT NULL,
  `issh` varchar(10) DEFAULT '否',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of gangweixinxi
-- ----------------------------
INSERT INTO `gangweixinxi` VALUES ('2', '001', '员工部', '7856954', '河滨东路139号', '销售', '1313', '通过', '是', '2020-03-02 22:03:36');
INSERT INTO `gangweixinxi` VALUES ('3', '4', '4', '40040004', '的个第三个', '豆腐干豆腐干', '飞过海飞过海', '通过', '是', '2020-03-02 22:50:32');

-- ----------------------------
-- Table structure for `gongzuojiluxinxi`
-- ----------------------------
DROP TABLE IF EXISTS `gongzuojiluxinxi`;
CREATE TABLE `gongzuojiluxinxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bumenzhanghao` varchar(50) DEFAULT NULL,
  `bumenmingcheng` varchar(50) DEFAULT NULL,
  `gangwei` varchar(50) DEFAULT NULL,
  `xuehao` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `xingbie` varchar(50) DEFAULT NULL,
  `gongzuojilu` varchar(50) DEFAULT NULL,
  `issh` varchar(10) DEFAULT '待审核',
  `shhf` varchar(200) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of gongzuojiluxinxi
-- ----------------------------
INSERT INTO `gongzuojiluxinxi` VALUES ('2', '001', '员工部', '销售', '001', '阿萨德', '男', '飞刀封个第三个', '已通过', '发送金额100', '2020-03-02 22:35:45');
INSERT INTO `gongzuojiluxinxi` VALUES ('3', '4', '4', '豆腐干豆腐干', '2', '2', '男', 'dfgsdgsdg', '已通过', '日薪806', '2020-03-02 22:52:46');

-- ----------------------------
-- Table structure for `jiaoshixinxi`
-- ----------------------------
DROP TABLE IF EXISTS `jiaoshixinxi`;
CREATE TABLE `jiaoshixinxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gonghao` varchar(50) DEFAULT NULL,
  `mima` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `xingbie` varchar(50) DEFAULT NULL,
  `shenfenzheng` varchar(50) DEFAULT NULL,
  `dianhua` varchar(50) DEFAULT NULL,
  `banji` varchar(50) DEFAULT NULL,
  `beizhu` varchar(500) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of jiaoshixinxi
-- ----------------------------
INSERT INTO `jiaoshixinxi` VALUES ('2', '019', '001', '姚明', '男', '330327198615482633', '6460224', 'A02', 'abc', '2020-03-02 20:38:32');
INSERT INTO `jiaoshixinxi` VALUES ('3', '012', '001', '周盛', '男', '330327198406150488', '4265325', 'E02', 'abc', '2020-03-02 20:38:32');
INSERT INTO `jiaoshixinxi` VALUES ('4', '007', '001', '李景阳', '女', '330327199504059511', '6498567', 'A02', 'ok', '2020-03-02 20:38:32');
INSERT INTO `jiaoshixinxi` VALUES ('5', '021', '001', '连小云', '男', '330327198708070789', '8900541', 'D01', 'ok', '2020-03-02 20:38:32');
INSERT INTO `jiaoshixinxi` VALUES ('6', '001', '001', '杨颖', '女', '33032719900723568X', '8945622', 'A02', '暂无', '2020-03-02 20:38:32');
INSERT INTO `jiaoshixinxi` VALUES ('7', '1', '1', '1', '男', '564456456789456123', '13685245645', 'AA班', '的身高多少', '2020-03-02 22:43:56');

-- ----------------------------
-- Table structure for `kunnanshengshenqing`
-- ----------------------------
DROP TABLE IF EXISTS `kunnanshengshenqing`;
CREATE TABLE `kunnanshengshenqing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `xuehao` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `xingbie` varchar(50) DEFAULT NULL,
  `banji` varchar(50) DEFAULT NULL,
  `shenqingliyou` varchar(50) DEFAULT NULL,
  `jiaoshishenhe` varchar(50) DEFAULT NULL,
  `xueyuanshenhe` varchar(50) DEFAULT NULL,
  `xuexiaoshenhe` varchar(50) DEFAULT NULL,
  `kunnanleibie` varchar(50) DEFAULT NULL,
  `issh` varchar(10) DEFAULT '否',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of kunnanshengshenqing
-- ----------------------------
INSERT INTO `kunnanshengshenqing` VALUES ('5', '001', '阿萨德', '男', 'A02', '的发士大夫', '审核通过', '审核通过', '审核通过', '一级', '是', '2020-03-02 21:00:45');
INSERT INTO `kunnanshengshenqing` VALUES ('6', '001', '阿萨德', '男', 'A02', '77', '待审', '待审', '待审', '', '否', '2020-03-02 21:02:39');
INSERT INTO `kunnanshengshenqing` VALUES ('7', '2', '2', '男', 'AA班', '的根深蒂固', '审核通过', '审核通过', '审核通过', '一级', '是', '2020-03-02 22:45:33');

-- ----------------------------
-- Table structure for `qingongzhuxue`
-- ----------------------------
DROP TABLE IF EXISTS `qingongzhuxue`;
CREATE TABLE `qingongzhuxue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bumenzhanghao` varchar(50) DEFAULT NULL,
  `bumenmingcheng` varchar(50) DEFAULT NULL,
  `lianxidianhua` varchar(50) DEFAULT NULL,
  `dizhi` varchar(50) DEFAULT NULL,
  `gangwei` varchar(50) DEFAULT NULL,
  `xuehao` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `xingbie` varchar(50) DEFAULT NULL,
  `banji` varchar(50) DEFAULT NULL,
  `jiaoshishenhe` varchar(50) DEFAULT NULL,
  `issh` varchar(10) DEFAULT '否',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of qingongzhuxue
-- ----------------------------
INSERT INTO `qingongzhuxue` VALUES ('2', '001', '员工部', '7856954', '河滨东路139号', '销售', '001', '阿萨德', '男', 'A02', '是', '是', '2020-03-02 22:18:49');
INSERT INTO `qingongzhuxue` VALUES ('3', '001', '员工部', '7856954', '河滨东路139号', '销售', '2', '2', '男', 'AA班', '是', '否', '2020-03-02 22:45:45');
INSERT INTO `qingongzhuxue` VALUES ('4', '4', '4', '40040004', '的个第三个', '豆腐干豆腐干', '2', '2', '男', 'AA班', '是', '是', '2020-03-02 22:51:52');

-- ----------------------------
-- Table structure for `xueshengxinxi`
-- ----------------------------
DROP TABLE IF EXISTS `xueshengxinxi`;
CREATE TABLE `xueshengxinxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `xuehao` varchar(50) DEFAULT NULL,
  `mima` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `xingbie` varchar(50) DEFAULT NULL,
  `shenfenzheng` varchar(50) DEFAULT NULL,
  `dianhua` varchar(50) DEFAULT NULL,
  `banji` varchar(50) DEFAULT NULL,
  `kunnanleibie` varchar(50) DEFAULT NULL,
  `beizhu` varchar(500) DEFAULT NULL,
  `issh` varchar(10) DEFAULT '否',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of xueshengxinxi
-- ----------------------------
INSERT INTO `xueshengxinxi` VALUES ('2', '001', '001', '阿萨德', '男', '321456789456123465', '13678945612', 'A02', '一级', '防火防盗和', '是', '2020-03-02 20:44:54');
INSERT INTO `xueshengxinxi` VALUES ('3', '2', '2', '2', '男', '321465897456123456', '13678945612', 'AA班', '一级', '大锅饭豆腐干十多个', '是', '2020-03-02 22:44:41');

-- ----------------------------
-- Table structure for `xueyuan`
-- ----------------------------
DROP TABLE IF EXISTS `xueyuan`;
CREATE TABLE `xueyuan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zhanghao` varchar(50) DEFAULT NULL,
  `mima` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `xingbie` varchar(50) DEFAULT NULL,
  `lianxifangshi` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of xueyuan
-- ----------------------------
INSERT INTO `xueyuan` VALUES ('2', '030', '001', '李中国', '男', '13025896548', '2020-03-02 20:38:42');
INSERT INTO `xueyuan` VALUES ('3', '016', '001', '周盛', '男', '13587835380', '2020-03-02 20:38:42');
INSERT INTO `xueyuan` VALUES ('4', '006', '001', '詹姆斯', '女', '13623256544', '2020-03-02 20:38:42');
INSERT INTO `xueyuan` VALUES ('5', '031', '001', '陈贵柏', '女', '18956482221', '2020-03-02 20:38:42');
INSERT INTO `xueyuan` VALUES ('6', '001', '001', '张燕', '女', '13186835580', '2020-03-02 20:38:42');
INSERT INTO `xueyuan` VALUES ('7', '3', '3', '3', '男', '2', '2020-03-02 22:44:13');

-- ----------------------------
-- Table structure for `yonggongbumen`
-- ----------------------------
DROP TABLE IF EXISTS `yonggongbumen`;
CREATE TABLE `yonggongbumen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bumenzhanghao` varchar(50) DEFAULT NULL,
  `mima` varchar(50) DEFAULT NULL,
  `bumenmingcheng` varchar(50) DEFAULT NULL,
  `fuzeren` varchar(50) DEFAULT NULL,
  `lianxidianhua` varchar(50) DEFAULT NULL,
  `dizhi` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of yonggongbumen
-- ----------------------------
INSERT INTO `yonggongbumen` VALUES ('2', '018', '001', '后勤部', '003', '8900541', '泰兴路22号', '2020-03-02 20:38:57');
INSERT INTO `yonggongbumen` VALUES ('3', '007', '001', '助理部', '008', '6944658', '解放路73号', '2020-03-02 20:38:57');
INSERT INTO `yonggongbumen` VALUES ('4', '012', '001', '秘书部', '009', '4231999', '方城丽圆11幢201室', '2020-03-02 20:38:57');
INSERT INTO `yonggongbumen` VALUES ('5', '028', '001', '技术部', '006', '5261554', '开明路22号', '2020-03-02 20:38:57');
INSERT INTO `yonggongbumen` VALUES ('6', '001', '001', '员工部', '001', '7856954', '河滨东路139号', '2020-03-02 20:38:57');
INSERT INTO `yonggongbumen` VALUES ('7', '4', '4', '4', '4', '40040004', '的个第三个', '2020-03-02 22:44:59');

-- ----------------------------
-- Table structure for `zhuxuejin`
-- ----------------------------
DROP TABLE IF EXISTS `zhuxuejin`;
CREATE TABLE `zhuxuejin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `xuehao` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `xingbie` varchar(50) DEFAULT NULL,
  `kunnanleibie` varchar(50) DEFAULT NULL,
  `shenqingliyou` varchar(50) DEFAULT NULL,
  `xueyuanshenhe` varchar(50) DEFAULT NULL,
  `xuexiaoshenhe` varchar(50) DEFAULT NULL,
  `zhuxuejine` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of zhuxuejin
-- ----------------------------
INSERT INTO `zhuxuejin` VALUES ('2', '001', '阿萨德', '男', '一级', '沙发撒毒粉', '通过', '通过', '800', '2020-03-02 21:53:06');
INSERT INTO `zhuxuejin` VALUES ('3', '2', '2', '男', '一级', '的三个收到', '通过', '通过', '800', '2020-03-02 22:49:22');
