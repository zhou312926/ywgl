/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : cssnj_admin

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 29/04/2019 12:31:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_cs_xtcs
-- ----------------------------
DROP TABLE IF EXISTS `t_cs_xtcs`;
CREATE TABLE `t_cs_xtcs` (
  `csbm` varchar(50) NOT NULL,
  `csz` varchar(100) NOT NULL,
  `csms` varchar(100) NOT NULL,
  `yxbz` char(1) NOT NULL,
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`csbm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_dm_xt_czlx
-- ----------------------------
DROP TABLE IF EXISTS `t_dm_xt_czlx`;
CREATE TABLE `t_dm_xt_czlx` (
  `dm` char(3) NOT NULL,
  `mc` varchar(50) NOT NULL,
  `yxbz` char(1) NOT NULL,
  PRIMARY KEY (`dm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_dm_xt_zhlx
-- ----------------------------
DROP TABLE IF EXISTS `t_dm_xt_zhlx`;
CREATE TABLE `t_dm_xt_zhlx` (
  `dm` char(2) NOT NULL,
  `mc` varchar(20) NOT NULL,
  `yxbz` char(1) NOT NULL,
  PRIMARY KEY (`dm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_dm_yw_wtlx
-- ----------------------------
DROP TABLE IF EXISTS `t_dm_yw_wtlx`;
CREATE TABLE `t_dm_yw_wtlx` (
  `dm` char(2) NOT NULL,
  `mc` varchar(50) NOT NULL,
  `yxbz` char(1) NOT NULL,
  PRIMARY KEY (`dm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_dm_yw_wtzt
-- ----------------------------
DROP TABLE IF EXISTS `t_dm_yw_wtzt`;
CREATE TABLE `t_dm_yw_wtzt` (
  `dm` char(2) NOT NULL,
  `mc` varchar(20) NOT NULL,
  `yxbz` char(1) NOT NULL,
  PRIMARY KEY (`dm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_dm_yw_ywmk
-- ----------------------------
DROP TABLE IF EXISTS `t_dm_yw_ywmk`;
CREATE TABLE `t_dm_yw_ywmk` (
  `dm` char(5) NOT NULL,
  `mc` varchar(50) NOT NULL,
  `yyxt_dm` varchar(255) NOT NULL,
  `yxbz` char(1) NOT NULL,
  PRIMARY KEY (`dm`),
  KEY `idx_dm_yw_ywmk_01` (`yyxt_dm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_dm_yw_yyxt
-- ----------------------------
DROP TABLE IF EXISTS `t_dm_yw_yyxt`;
CREATE TABLE `t_dm_yw_yyxt` (
  `dm` char(2) NOT NULL,
  `mc` varchar(50) NOT NULL,
  `yxbz` char(1) NOT NULL,
  PRIMARY KEY (`dm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_kp_dsdp
-- ----------------------------
DROP TABLE IF EXISTS `t_kp_dsdp`;
CREATE TABLE `t_kp_dsdp` (
  `id` varchar(32) NOT NULL,
  `ssgx_id` varchar(32) NOT NULL,
  `gtnlpf` float(2,1) NOT NULL,
  `gtnlpj` varchar(500) DEFAULT NULL,
  `ywnlpf` float(2,1) NOT NULL,
  `ywnlpj` varchar(500) DEFAULT NULL,
  `qtpf` float(2,1) DEFAULT NULL,
  `qtpj` varchar(500) DEFAULT NULL,
  `bmzb_id` varchar(32) NOT NULL,
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_kp_dsxx
-- ----------------------------
DROP TABLE IF EXISTS `t_kp_dsxx`;
CREATE TABLE `t_kp_dsxx` (
  `id` varchar(32) NOT NULL,
  `yh_id` varchar(32) NOT NULL,
  `jzrq` date DEFAULT NULL,
  `yxbz` char(1) NOT NULL,
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_kp_xsxx
-- ----------------------------
DROP TABLE IF EXISTS `t_kp_xsxx`;
CREATE TABLE `t_kp_xsxx` (
  `id` varchar(32) NOT NULL,
  `ds_id` varchar(32) NOT NULL,
  `yh_id` varchar(32) NOT NULL,
  `bz` varchar(500) DEFAULT NULL,
  `jzrq` date DEFAULT NULL,
  `yxbz` char(1) NOT NULL,
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_qx_js_cd
-- ----------------------------
DROP TABLE IF EXISTS `t_qx_js_cd`;
CREATE TABLE `t_qx_js_cd` (
  `id` varchar(32) NOT NULL,
  `js_id` varchar(32) NOT NULL,
  `gncd_id` varchar(32) DEFAULT NULL,
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_xt_js_zy_01` (`js_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_qx_js_gn
-- ----------------------------
DROP TABLE IF EXISTS `t_qx_js_gn`;
CREATE TABLE `t_qx_js_gn` (
  `id` varchar(32) NOT NULL,
  `js_id` varchar(32) NOT NULL,
  `gncd_id` varchar(32) DEFAULT NULL,
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_xt_js_zy_01` (`js_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_qx_yh_js
-- ----------------------------
DROP TABLE IF EXISTS `t_qx_yh_js`;
CREATE TABLE `t_qx_yh_js` (
  `id` varchar(32) NOT NULL,
  `yh_id` varchar(32) NOT NULL,
  `js_id` varchar(32) NOT NULL,
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_xt_yh_js_01` (`yh_id`),
  KEY `idx_xt_yh_js_02` (`js_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_xt_bmzb
-- ----------------------------
DROP TABLE IF EXISTS `t_xt_bmzb`;
CREATE TABLE `t_xt_bmzb` (
  `id` varchar(32) NOT NULL COMMENT '部门组别ID',
  `mc` varchar(50) NOT NULL COMMENT '名称',
  `ms` varchar(100) DEFAULT NULL COMMENT '描述',
  `xh` int(11) DEFAULT NULL,
  `sjbmzb_id` varchar(32) NOT NULL COMMENT '上级部门组别ID',
  `yxbz` char(1) NOT NULL,
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_xt_bmzb_01` (`sjbmzb_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_xt_czrz
-- ----------------------------
DROP TABLE IF EXISTS `t_xt_czrz`;
CREATE TABLE `t_xt_czrz` (
  `id` varchar(32) NOT NULL,
  `czlx_dm` varchar(32) NOT NULL,
  `cznr` varchar(200) NOT NULL,
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_xt_dlzh
-- ----------------------------
DROP TABLE IF EXISTS `t_xt_dlzh`;
CREATE TABLE `t_xt_dlzh` (
  `id` varchar(32) NOT NULL,
  `dlzh` varchar(50) NOT NULL COMMENT '登录账号',
  `mm` varchar(100) NOT NULL COMMENT '密码',
  `zhlx_dm` char(2) NOT NULL COMMENT '账号类型',
  `yh_id` varchar(32) NOT NULL COMMENT '用户ID',
  `yxbz` char(1) NOT NULL,
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_xt_dlzh_01` (`dlzh`),
  KEY `idx_xt_dlzh_02` (`yh_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_xt_gncd
-- ----------------------------
DROP TABLE IF EXISTS `t_xt_gncd`;
CREATE TABLE `t_xt_gncd` (
  `id` varchar(32) NOT NULL COMMENT '菜单ID',
  `qxbs` varchar(20) DEFAULT NULL COMMENT '权限标识',
  `mc` varchar(50) NOT NULL COMMENT '名称',
  `jc` varchar(20) DEFAULT NULL COMMENT '简称',
  `url` varchar(100) DEFAULT NULL COMMENT '地址',
  `lx` char(1) NOT NULL COMMENT '类型：0目录，1菜单，2功能',
  `dkfs` char(1) DEFAULT NULL COMMENT '打开方式（只对类型为1有效），0主窗口标签页，1本窗口，2新窗口',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `xh` int(11) DEFAULT NULL COMMENT '序号',
  `sjgncd_id` varchar(100) NOT NULL COMMENT '上级菜单ID',
  `yxbz` char(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_xt_cd_01` (`qxbs`),
  KEY `idx_xt_cd_02` (`sjgncd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_xt_js
-- ----------------------------
DROP TABLE IF EXISTS `t_xt_js`;
CREATE TABLE `t_xt_js` (
  `id` varchar(32) NOT NULL COMMENT '角色ID',
  `qxbs` varchar(20) DEFAULT NULL,
  `mc` varchar(50) NOT NULL COMMENT '名称',
  `ms` varchar(100) DEFAULT NULL COMMENT '描述',
  `xh` int(11) DEFAULT NULL,
  `sjjs_id` varchar(32) NOT NULL COMMENT '上级角色ID',
  `yxbz` char(1) DEFAULT NULL,
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_xt_js_01` (`sjjs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_xt_tzgg
-- ----------------------------
DROP TABLE IF EXISTS `t_xt_tzgg`;
CREATE TABLE `t_xt_tzgg` (
  `id` varchar(32) NOT NULL,
  `bt` varchar(100) DEFAULT NULL,
  `nr` varchar(4000) NOT NULL,
  `lx` char(1) DEFAULT NULL,
  `yxbz` char(1) NOT NULL,
  `gqsj` datetime DEFAULT NULL,
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_xt_yh_tzgg
-- ----------------------------
DROP TABLE IF EXISTS `t_xt_yh_tzgg`;
CREATE TABLE `t_xt_yh_tzgg` (
  `id` varchar(32) NOT NULL,
  `yh_id` varchar(32) NOT NULL,
  `tzgg_id` varchar(32) NOT NULL,
  `qrbz` char(1) DEFAULT NULL,
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_xt_yhxx
-- ----------------------------
DROP TABLE IF EXISTS `t_xt_yhxx`;
CREATE TABLE `t_xt_yhxx` (
  `id` varchar(32) NOT NULL COMMENT '用户ID',
  `xm` varchar(50) NOT NULL COMMENT '姓名',
  `xb` char(1) DEFAULT NULL COMMENT '性别：1男，0女',
  `csrq` date DEFAULT NULL COMMENT '出生日期',
  `yddh` char(11) DEFAULT NULL COMMENT '移动电话',
  `gddh` char(12) DEFAULT NULL COMMENT '固定电话',
  `dzyx` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `lx` char(1) DEFAULT NULL COMMENT '类型，1运维服务',
  `bmzb_id` varchar(32) DEFAULT NULL,
  `yxbz` char(1) NOT NULL,
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_xt_yhxx_kz
-- ----------------------------
DROP TABLE IF EXISTS `t_xt_yhxx_kz`;
CREATE TABLE `t_xt_yhxx_kz` (
  `id` varchar(32) NOT NULL COMMENT '用户ID',
  `dlsj` datetime DEFAULT NULL COMMENT '登录时间',
  `scdlsj` datetime DEFAULT NULL COMMENT '上次登录时间',
  `dlcs` int(11) DEFAULT NULL COMMENT '登录次数',
  `yh_id` varchar(32) NOT NULL,
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_yw_wtfj
-- ----------------------------
DROP TABLE IF EXISTS `t_yw_wtfj`;
CREATE TABLE `t_yw_wtfj` (
  `id` varchar(32) NOT NULL COMMENT '附件ID',
  `mc` varchar(50) NOT NULL COMMENT '名称',
  `fjhz` varchar(10) NOT NULL COMMENT '附件后缀',
  `url` varchar(50) NOT NULL COMMENT '路径',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `wtxx_id` varchar(32) NOT NULL COMMENT '问题ID',
  `bmzb_id` varchar(32) NOT NULL COMMENT '部门组别ID',
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_yw_wtfj_01` (`wtxx_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_yw_wthf
-- ----------------------------
DROP TABLE IF EXISTS `t_yw_wthf`;
CREATE TABLE `t_yw_wthf` (
  `id` varchar(32) NOT NULL COMMENT '反馈ID',
  `nr` varchar(4000) NOT NULL COMMENT '反馈内容',
  `wtxx_id` varchar(32) NOT NULL COMMENT '问题ID',
  `sfcn` char(1) DEFAULT NULL COMMENT '是否采纳',
  `bmzb_id` varchar(32) NOT NULL,
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_yw_wtfk_01` (`wtxx_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_yw_wtxx
-- ----------------------------
DROP TABLE IF EXISTS `t_yw_wtxx`;
CREATE TABLE `t_yw_wtxx` (
  `id` varchar(32) NOT NULL COMMENT '问题ID',
  `bt` varchar(200) NOT NULL COMMENT '标题',
  `ms` varchar(4000) NOT NULL COMMENT '描述',
  `wtlx_dm` char(2) NOT NULL COMMENT '问题类型代码',
  `yyxt_dm` char(2) NOT NULL COMMENT '应用系统代码',
  `ywmk_dm` char(5) DEFAULT NULL COMMENT '业务模块代码',
  `wtzt_dm` char(2) NOT NULL COMMENT '问题状态代码',
  `clfa` varchar(4000) DEFAULT NULL COMMENT '处理方案',
  `bmzb_id` varchar(32) NOT NULL COMMENT '部门组别ID',
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_yw_wtxx_01` (`bt`),
  KEY `idx_yw_wtxx_02` (`wtlx_dm`),
  KEY `idx_yw_wtxx_03` (`yyxt_dm`),
  KEY `idx_yw_wtxx_04` (`ywmk_dm`),
  KEY `idx_yw_wtxx_05` (`wtzt_dm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_yw_ywjb
-- ----------------------------
DROP TABLE IF EXISTS `t_yw_ywjb`;
CREATE TABLE `t_yw_ywjb` (
  `id` varchar(32) NOT NULL,
  `bt` varchar(200) NOT NULL,
  `ms` varchar(4000) NOT NULL,
  `yyxt_dm` char(2) NOT NULL,
  `jbnr` text NOT NULL,
  `bmzb_id` varchar(32) NOT NULL,
  `lrry` varchar(32) DEFAULT NULL,
  `lrsj` timestamp(6) NULL DEFAULT NULL,
  `xgry` varchar(32) DEFAULT NULL,
  `xgsj` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_xt_ywjb_01` (`bt`) USING BTREE,
  KEY `idx_xt_ywjb_02` (`yyxt_dm`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
