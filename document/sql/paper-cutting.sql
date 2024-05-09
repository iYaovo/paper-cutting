-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.34 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 paper-cutting 的数据库结构
CREATE DATABASE IF NOT EXISTS `paper-cutting` /*!40100 DEFAULT CHARACTER SET utf8mb4   */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `paper-cutting`;

-- 导出  表 paper-cutting.buyer_info 结构
CREATE TABLE IF NOT EXISTS `buyer_info` (
                                            `buyer_id` bigint NOT NULL,
                                            `buyer_name` varchar(50) CHARACTER SET utf8mb4  NOT NULL COMMENT '买家账号',
    `buyer_password` varchar(200) CHARACTER SET utf8mb4  NOT NULL COMMENT '买家密码',
    `buyer_hobby` varchar(200) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '买家爱好',
    `buyer_autograph` varchar(200) CHARACTER SET utf8mb4  DEFAULT NULL,
    `pic_url` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '头像',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除(默认0)'
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4     COMMENT='买家信息表';

-- 正在导出表  paper-cutting.buyer_info 的数据：~9 rows (大约)
INSERT INTO `buyer_info` (`buyer_id`, `buyer_name`, `buyer_password`, `buyer_hobby`, `buyer_autograph`, `pic_url`, `create_time`, `update_time`, `del_flag`) VALUES
    (1782381108064657409, 'admin', '$2a$10$y.NBngNh6H1HRJtPFrxAo.mf9f8LCDAz.V8br6EAehIT4Tt1EVsO6', '3', '3', '', '2024-04-22 12:09:05', '2024-05-08 09:26:55', b'0');

-- 导出  表 paper-cutting.cart_info 结构
CREATE TABLE IF NOT EXISTS `cart_info` (
                                           `cart_id` int unsigned NOT NULL AUTO_INCREMENT,
                                           `buyer_id` bigint NOT NULL COMMENT '用户id',
                                           `goods_id` int NOT NULL DEFAULT '0' COMMENT '商品id',
                                           `goods_number` int NOT NULL DEFAULT '1' COMMENT '购物车中商品数量',
                                           PRIMARY KEY (`cart_id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4    ;

-- 正在导出表  paper-cutting.cart_info 的数据：~0 rows (大约)
INSERT INTO `cart_info` (`cart_id`, `buyer_id`, `goods_id`, `goods_number`) VALUES
                                                                                (9, 1782381108064657409, 1, 5),
                                                                                (10, 1782381108064657409, 3, 1),
                                                                                (11, 1782381108064657409, 5, 1);

-- 导出  表 paper-cutting.daily_sign 结构
CREATE TABLE IF NOT EXISTS `daily_sign` (
                                            `daily_sign_id` int NOT NULL AUTO_INCREMENT,
                                            `buyer_id` bigint NOT NULL COMMENT '买家id',
                                            `sign_time` varchar(50) NOT NULL COMMENT '签到时间',
    PRIMARY KEY (`daily_sign_id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4     COMMENT='每日签到表';

-- 正在导出表  paper-cutting.daily_sign 的数据：~3 rows (大约)
INSERT INTO `daily_sign` (`daily_sign_id`, `buyer_id`, `sign_time`) VALUES
                                                                        (2, 1782381108064657409, '2024-04-23'),
                                                                        (3, 1782381108064657409, '2024-04-24'),
                                                                        (6, 1782381108064657409, '2024-04-26');

-- 导出  表 paper-cutting.discuss_info 结构
CREATE TABLE IF NOT EXISTS `discuss_info` (
                                              `discuss_id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                              `buyer_id` bigint NOT NULL COMMENT '用户id',
                                              `parent_id` int NOT NULL COMMENT '讨论父id(0为一级讨论)',
                                              `discuss_content` varchar(255)   NOT NULL COMMENT '讨论内容',
    `favorite_number` int NOT NULL DEFAULT '0' COMMENT '点赞数',
    `comment_number` int NOT NULL DEFAULT '0' COMMENT '评论数',
    PRIMARY KEY (`discuss_id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4     COMMENT='广场讨论表';

-- 正在导出表  paper-cutting.discuss_info 的数据：~4 rows (大约)
INSERT INTO `discuss_info` (`discuss_id`, `buyer_id`, `parent_id`, `discuss_content`, `favorite_number`, `comment_number`) VALUES
                                                                                                                               (1, 1782381108064657409, 0, '一级评论1', 0, 0),
                                                                                                                               (2, 1782381108064657409, 0, '一级评论2', 1, 1),
                                                                                                                               (3, 1782381108064657409, 2, '一级评论2的二级评论', 0, 0),
                                                                                                                               (4, 1782381108064657409, 2, '一级评论2的二级评论', 0, 0);

-- 导出  表 paper-cutting.goods_category 结构
CREATE TABLE IF NOT EXISTS `goods_category` (
                                                `goods_category_id` tinyint unsigned NOT NULL AUTO_INCREMENT,
                                                `goods_category_name` varchar(50) CHARACTER SET utf8mb4  NOT NULL COMMENT '类别名称',
    `pic_url` varchar(255) NOT NULL COMMENT '类别url',
    `category_superior_id` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '0即为上级分类',
    PRIMARY KEY (`goods_category_id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4     COMMENT='商品第一类别表';

-- 正在导出表  paper-cutting.goods_category 的数据：~16 rows (大约)
INSERT INTO `goods_category` (`goods_category_id`, `goods_category_name`, `pic_url`, `category_superior_id`) VALUES
                                                                                                                 (1, '剪纸画', '', 0),
                                                                                                                 (2, '生肖', '', 0),
                                                                                                                 (3, '人像', '', 0),
                                                                                                                 (4, '窗花', '', 0),
                                                                                                                 (5, '中国风', '', 0),
                                                                                                                 (6, '福字', '', 0),
                                                                                                                 (7, '民俗', '', 0),
                                                                                                                 (8, '喜字', '', 0),
                                                                                                                 (9, '党史党建', '', 0),
                                                                                                                 (10, '剪纸定制', '', 0),
                                                                                                                 (12, '牛', 'Image\\2024-05-08CDCM.png', 2),
                                                                                                                 (14, '马', 'Image\\2024-05-08CDCM.png', 2),
                                                                                                                 (15, '猴', 'Image\\2024-05-08CDCM.png', 2),
                                                                                                                 (16, '吴昕开', 'Image\\2024-05-08CDCM.png', 3),
                                                                                                                 (17, '无心恺', 'Image\\2024-05-08CDCM.png', 3),
                                                                                                                 (18, '武信铠', 'Image\\2024-05-08CDCM.png', 3);

-- 导出  表 paper-cutting.goods_collection 结构
CREATE TABLE IF NOT EXISTS `goods_collection` (
                                                  `goods_collection_id` int unsigned NOT NULL AUTO_INCREMENT,
                                                  `goods_id` int NOT NULL COMMENT '商品id',
                                                  `buyer_id` bigint NOT NULL COMMENT '用户id',
                                                  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '收藏时间',
                                                  PRIMARY KEY (`goods_collection_id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4     COMMENT='商品收藏';

-- 正在导出表  paper-cutting.goods_collection 的数据：~1 rows (大约)
INSERT INTO `goods_collection` (`goods_collection_id`, `goods_id`, `buyer_id`, `create_time`) VALUES
                                                                                                  (1, 1, 1782381108064657409, '2024-04-23 07:18:59'),
                                                                                                  (3, 3, 1782381108064657409, '2024-05-09 08:43:50');

-- 导出  表 paper-cutting.goods_info 结构
CREATE TABLE IF NOT EXISTS `goods_info` (
                                            `goods_id` int unsigned NOT NULL AUTO_INCREMENT,
                                            `goods_category_id` tinyint NOT NULL COMMENT '商品第二类别表id',
                                            `shop_id` int NOT NULL DEFAULT '0' COMMENT '店铺id',
                                            `goods_name` varchar(50) NOT NULL COMMENT '商品名称',
    `goods_introduction` varchar(255) NOT NULL COMMENT '商品描述',
    `pic_url` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '商品标题图片',
    `price` decimal(10,2) NOT NULL COMMENT '商品原价',
    `promotion_price` decimal(10,2) NOT NULL COMMENT '促销价格',
    `sold_number` int NOT NULL DEFAULT '0' COMMENT '已售数量',
    `total_number` int NOT NULL DEFAULT '0' COMMENT '库存量',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除(默认0)',
    PRIMARY KEY (`goods_id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4     COMMENT='商品信息表';

-- 正在导出表  paper-cutting.goods_info 的数据：~6 rows (大约)
INSERT INTO `goods_info` (`goods_id`, `goods_category_id`, `shop_id`, `goods_name`, `goods_introduction`, `pic_url`, `price`, `promotion_price`, `sold_number`, `total_number`, `create_time`, `update_time`, `del_flag`) VALUES
                                                                                                                                                                                                                              (1, 12, 1, '大牛', '大牛介绍', 'Image\\2024-05-08CDCM.png', 100.00, 50.00, 0, 10052, '2024-04-16 07:13:24', '2024-05-08 08:46:50', b'0'),
                                                                                                                                                                                                                              (3, 12, 1, '大小牛', '大小牛介绍', 'Image\\2024-05-08CDCM.png', 100.00, 50.00, 0, 10052, '2024-04-23 05:34:20', '2024-05-08 08:46:54', b'0'),
                                                                                                                                                                                                                              (5, 12, 1, '小牛', '小牛介绍', 'Image\\2024-05-08CDCM.png', 50.00, 25.00, 0, 10000, '2024-04-24 13:04:51', '2024-05-08 08:46:56', b'0'),
                                                                                                                                                                                                                              (6, 15, 1, '小猴猴', '小猴猴介绍', 'Image\\2024-05-08CDCM.png', 50.00, 25.00, 0, 10000, '2024-04-24 13:29:03', '2024-05-08 08:46:57', b'0'),
                                                                                                                                                                                                                              (7, 15, 1, '小小猴猴猴猴', '小小猴猴猴猴介绍', 'Image\\2024-05-08CDCM.png', 5000.00, 2500.00, 0, 1000000, '2024-04-24 13:29:23', '2024-05-08 08:46:57', b'0'),
                                                                                                                                                                                                                              (8, 15, 722354179, '小小猴', '小小猴介绍', 'Image\\2024-05-08CDCM.png', 5000.00, 2500.00, 0, 1000000, '2024-04-24 13:30:19', '2024-05-08 08:46:58', b'0');

-- 导出  表 paper-cutting.goods_views 结构
CREATE TABLE IF NOT EXISTS `goods_views` (
                                             `goods_views_id` int unsigned NOT NULL AUTO_INCREMENT,
                                             `goods_id` int NOT NULL COMMENT '商品id',
                                             `buyer_id` bigint NOT NULL COMMENT '用户id',
                                             `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '浏览时间',
                                             PRIMARY KEY (`goods_views_id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4     COMMENT='近期浏览商品';

-- 正在导出表  paper-cutting.goods_views 的数据：~4 rows (大约)
INSERT INTO `goods_views` (`goods_views_id`, `goods_id`, `buyer_id`, `create_time`) VALUES
                                                                                        (5, 1, 1782381108064657409, '2024-05-09 08:46:54'),
                                                                                        (6, 3, 1782381108064657409, '2024-05-09 04:46:53'),
                                                                                        (7, 5, 1782381108064657409, '2024-05-09 04:46:54'),
                                                                                        (8, 6, 1782381108064657409, '2024-05-09 04:46:56');

-- 导出  表 paper-cutting.order_info 结构
CREATE TABLE IF NOT EXISTS `order_info` (
                                            `order_id` bigint NOT NULL,
                                            `goods_id` int NOT NULL COMMENT '商品id',
                                            `buyer_id` bigint NOT NULL COMMENT '用户id',
                                            `receiving_address_id` tinyint NOT NULL COMMENT '收货地址id',
                                            `order_status` tinyint NOT NULL COMMENT '订单状态(0待付款,1待发货,2待收货,3待评价,4售后)',
                                            `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                            `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                            `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除(默认0)',
    PRIMARY KEY (`order_id`) USING BTREE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4     COMMENT='订单信息表';

-- 正在导出表  paper-cutting.order_info 的数据：~2 rows (大约)
INSERT INTO `order_info` (`order_id`, `goods_id`, `buyer_id`, `receiving_address_id`, `order_status`, `create_time`, `update_time`, `del_flag`) VALUES
                                                                                                                                                    (1783712793834233858, 3, 1782381108064657409, 1, 3, '2024-04-26 04:20:44', '2024-04-26 05:58:12', b'1'),
                                                                                                                                                    (1783712793876176897, 1, 1782381108064657409, 1, 3, '2024-04-26 04:20:44', '2024-04-26 04:20:44', b'0');

-- 导出  表 paper-cutting.receiving_address 结构
CREATE TABLE IF NOT EXISTS `receiving_address` (
                                                   `receiving_address_id` int unsigned NOT NULL AUTO_INCREMENT,
                                                   `buyer_id` bigint NOT NULL COMMENT '用户id',
                                                   `recipient_name` varchar(50) CHARACTER SET utf8mb4  NOT NULL COMMENT '收件人姓名',
    `recipient_phone` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '收件人电话',
    `recipient_region` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '所在地区',
    `recipient_address` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '详细地址',
    PRIMARY KEY (`receiving_address_id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4     COMMENT='收货地址表';

-- 正在导出表  paper-cutting.receiving_address 的数据：~2 rows (大约)
INSERT INTO `receiving_address` (`receiving_address_id`, `buyer_id`, `recipient_name`, `recipient_phone`, `recipient_region`, `recipient_address`) VALUES
                                                                                                                                                       (1, 1782381108064657409, '收件人姓名2', '收件人电话', '收件人所在地区', '收件人详细地址'),
                                                                                                                                                       (2, 1, '1', '1', '1', '1');

-- 导出  表 paper-cutting.shop_follow 结构
CREATE TABLE IF NOT EXISTS `shop_follow` (
                                             `shop_follow_id` int unsigned NOT NULL AUTO_INCREMENT,
                                             `shop_id` int NOT NULL COMMENT '店铺id',
                                             `buyer_id` bigint NOT NULL COMMENT '用户id',
                                             `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '关注时间',
                                             PRIMARY KEY (`shop_follow_id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4     COMMENT='店铺关注表';

-- 正在导出表  paper-cutting.shop_follow 的数据：~1 rows (大约)
INSERT INTO `shop_follow` (`shop_follow_id`, `shop_id`, `buyer_id`, `create_time`) VALUES
                                                                                       (1, 1, 1782381108064657409, '2024-04-23 07:19:32'),
                                                                                       (3, 722354187, 1782381108064657409, '2024-05-09 08:45:03');

-- 导出  表 paper-cutting.shop_info 结构
CREATE TABLE IF NOT EXISTS `shop_info` (
                                           `shop_id` int unsigned NOT NULL AUTO_INCREMENT,
                                           `shop_name` varchar(50) NOT NULL COMMENT '店铺名称',
    `pic_url` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '店铺图片',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除(默认0)',
    PRIMARY KEY (`shop_id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=722354191 DEFAULT CHARSET=utf8mb4     COMMENT='店铺信息表';

-- 正在导出表  paper-cutting.shop_info 的数据：~3 rows (大约)
INSERT INTO `shop_info` (`shop_id`, `shop_name`, `pic_url`, `create_time`, `update_time`, `del_flag`) VALUES
                                                                                                          (1, '姿色纸缘', 'Image\\2024-05-08CDCM.png', '2024-04-16 07:26:15', '2024-05-08 08:51:23', b'0'),
                                                                                                          (722354187, '店铺名称', 'Image\\2024-05-08CDCM.png', '2024-04-25 11:24:41', '2024-05-08 08:51:24', b'0'),
                                                                                                          (722354190, '店铺名', 'Image\\2024-05-08CDCM.png', '2024-04-28 05:31:23', '2024-05-08 08:51:24', b'0');

-- 导出  表 paper-cutting.ums_admin 结构
CREATE TABLE IF NOT EXISTS `ums_admin` (
                                           `id` bigint NOT NULL AUTO_INCREMENT,
                                           `username` varchar(64) CHARACTER SET utf8mb3    DEFAULT NULL,
    `password` varchar(64) CHARACTER SET utf8mb3    DEFAULT NULL,
    `icon` varchar(500) CHARACTER SET utf8mb3    DEFAULT NULL COMMENT '头像',
    `email` varchar(100) CHARACTER SET utf8mb3    DEFAULT NULL COMMENT '邮箱',
    `nick_name` varchar(200) CHARACTER SET utf8mb3    DEFAULT NULL COMMENT '昵称',
    `note` varchar(500) CHARACTER SET utf8mb3    DEFAULT NULL COMMENT '备注信息',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
    `status` int DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
    PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='后台用户表';

-- 正在导出表  paper-cutting.ums_admin 的数据：~10 rows (大约)
INSERT INTO `ums_admin` (`id`, `username`, `password`, `icon`, `email`, `nick_name`, `note`, `create_time`, `login_time`, `status`) VALUES
                                                                                                                                        (1, '', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', '头像', '邮箱', '昵称', '备注信息', '2018-09-29 13:55:30', '2018-09-29 13:55:39', 0),
                                                                                                                                        (3, 'admin', '$2a$10$.E1FokumK5GIXWgKlg.Hc.i/0/2.qdAwYFL1zc5QHdyzpXOr38RZO', 'https://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/icon/github_icon_01.png', 'admin@163.com', '系统管理员', '系统管理员', '2018-10-08 13:32:47', '2019-04-20 12:45:16', 1),
                                                                                                                                        (4, 'macro', '$2a$10$Bx4jZPR7GhEpIQfefDQtVeS58GfT5n6mxs/b4nLLK65eMFa16topa', 'https://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/icon/github_icon_01.png', 'macro@qq.com', 'macro', 'macro专用', '2019-10-06 15:53:51', '2020-02-03 14:55:55', 1),
                                                                                                                                        (6, 'productAdmin', '$2a$10$6/.J.p.6Bhn7ic4GfoB5D.pGd7xSiD1a9M6ht6yO0fxzlKJPjRAGm', 'https://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/icon/github_icon_03.png', 'product@qq.com', '商品管理员', '只有商品权限', '2020-02-07 16:15:08', NULL, 1),
                                                                                                                                        (7, 'orderAdmin', '$2a$10$UqEhA9UZXjHHA3B.L9wNG.6aerrBjC6WHTtbv1FdvYPUI.7lkL6E.', 'https://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/icon/github_icon_04.png', 'order@qq.com', '订单管理员', '只有订单管理权限', '2020-02-07 16:15:50', NULL, 1),
                                                                                                                                        (8, 'test123', '$2a$10$M1qJguEzwoAN0la7PB8UO.HOGe1xZGku7xw1iTaUUpY0ZVRCxrxoO', 'string', 'abc@qq.com', 'string', 'string', '2022-08-07 14:45:42', NULL, 1),
                                                                                                                                        (9, 'test256', '$2a$10$kTMBrt8mkXcO8T4eHThFWOf3KuNK6tqevkiAf4YbtXtaCJ6ocYkJa', 'string', 'abc@qq.com', 'string', 'string', '2022-08-07 14:52:57', NULL, 1),
                                                                                                                                        (10, 'test1267', '$2a$10$VUywDhXVPY13YZxMD/uPWeDqkzSozN7o8u/3MX6sBig2NK2VaTJZ2', NULL, 'test1267@qq.com', 'test1267', 'test1267', '2023-01-04 16:13:34', NULL, 1),
                                                                                                                                        (11, 'iyaovo', '$2a$10$2FJclxrEQ8bLmhslSvYJhe0fqPTGc4jH9wlLq3wK3e4ptThLREOne', '用户头像', '邮箱', '用户昵称', '备注', '2024-04-25 17:47:13', NULL, 1),
                                                                                                                                        (16, 'iwqeqwe', '$2a$10$fdpixEGkKGbWdYUWlpU2v.7mkxijnyGsvZfzR2RtgmOnr1F40MhEa', '用户头像', '邮箱', '用户昵称', '备注', '2024-04-26 21:08:16', NULL, 1);

-- 导出  表 paper-cutting.ums_admin_login_log 结构
CREATE TABLE IF NOT EXISTS `ums_admin_login_log` (
                                                     `id` bigint NOT NULL AUTO_INCREMENT,
                                                     `admin_id` bigint DEFAULT NULL,
                                                     `create_time` datetime DEFAULT NULL,
                                                     `ip` varchar(64) CHARACTER SET utf8mb3    DEFAULT NULL,
    `address` varchar(100) CHARACTER SET utf8mb3    DEFAULT NULL,
    `user_agent` varchar(100) CHARACTER SET utf8mb3    DEFAULT NULL COMMENT '浏览器登录类型',
    PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=427 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='后台用户登录日志表';

-- 正在导出表  paper-cutting.ums_admin_login_log 的数据：~426 rows (大约)
INSERT INTO `ums_admin_login_log` (`id`, `admin_id`, `create_time`, `ip`, `address`, `user_agent`) VALUES
                                                                                                       (1, 3, '2018-12-23 14:27:00', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (2, 3, '2019-04-07 16:04:39', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (3, 3, '2019-04-08 21:47:52', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (4, 3, '2019-04-08 21:48:18', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (5, 3, '2019-04-18 22:18:40', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (6, 3, '2019-04-20 12:45:16', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (7, 3, '2019-05-19 14:52:12', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (8, 3, '2019-05-25 15:00:17', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (9, 3, '2019-06-19 20:11:42', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (10, 3, '2019-06-30 10:33:48', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (11, 3, '2019-06-30 10:34:31', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (12, 3, '2019-06-30 10:35:34', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (13, 3, '2019-07-27 17:11:01', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (14, 3, '2019-07-27 17:13:18', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (15, 3, '2019-07-27 17:15:35', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (16, 3, '2019-07-27 17:17:11', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (17, 3, '2019-07-27 17:18:34', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (18, 3, '2019-07-27 21:21:52', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (19, 3, '2019-07-27 21:34:29', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (20, 3, '2019-07-27 21:35:17', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (21, 3, '2019-07-27 21:35:48', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (22, 3, '2019-07-27 21:40:33', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (23, 3, '2019-08-18 16:00:38', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (24, 3, '2019-08-18 16:01:06', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (25, 3, '2019-08-18 16:47:01', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (26, 3, '2019-10-06 15:54:23', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (27, 3, '2019-10-06 16:03:28', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (28, 3, '2019-10-06 16:04:51', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (29, 3, '2019-10-06 16:06:44', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (30, 3, '2019-10-06 16:14:51', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (31, 1, '2019-10-06 16:15:09', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (32, 1, '2019-10-06 16:16:14', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (33, 3, '2019-10-06 16:16:35', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (34, 3, '2019-10-06 16:16:42', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (35, 3, '2019-10-07 15:20:48', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (36, 3, '2019-10-07 15:40:07', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (37, 3, '2019-10-07 16:34:15', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (38, 3, '2019-10-09 21:19:08', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (39, 4, '2019-10-09 21:30:35', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (40, 4, '2019-10-09 21:31:30', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (41, 4, '2019-10-09 21:32:39', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (42, 4, '2019-10-09 21:33:27', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (43, 4, '2019-10-09 21:33:50', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (44, 3, '2019-10-20 16:02:53', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (45, 3, '2019-10-23 21:20:55', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (46, 3, '2019-10-27 21:41:45', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (47, 3, '2019-11-09 16:44:57', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (48, 3, '2019-11-09 16:46:56', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (49, 3, '2019-11-09 16:49:55', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (50, 3, '2019-11-23 14:17:16', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (51, 6, '2019-11-23 14:52:30', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (52, 3, '2019-11-23 15:07:24', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (53, 3, '2019-11-30 21:25:30', '192.168.3.185', NULL, NULL),
                                                                                                       (54, 3, '2019-11-30 21:27:54', '192.168.3.185', NULL, NULL),
                                                                                                       (55, 3, '2019-12-28 15:23:01', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (56, 3, '2020-01-01 15:21:46', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (57, 3, '2020-01-04 16:00:54', '192.168.3.185', NULL, NULL),
                                                                                                       (58, 3, '2020-02-01 15:05:19', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (59, 3, '2020-02-01 15:36:05', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (60, 3, '2020-02-01 15:36:36', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (61, 3, '2020-02-01 15:37:30', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (62, 3, '2020-02-01 15:37:46', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (63, 3, '2020-02-01 15:38:20', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (64, 3, '2020-02-01 15:38:33', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (65, 3, '2020-02-01 15:39:06', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (66, 3, '2020-02-01 15:41:31', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (67, 3, '2020-02-01 15:43:17', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (68, 3, '2020-02-01 15:44:34', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (69, 3, '2020-02-01 15:45:10', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (70, 3, '2020-02-01 15:46:04', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (71, 3, '2020-02-01 15:48:33', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (72, 3, '2020-02-01 16:00:07', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (73, 3, '2020-02-01 16:07:25', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (74, 3, '2020-02-01 16:08:22', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (75, 3, '2020-02-02 15:28:13', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (76, 3, '2020-02-02 15:44:37', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (77, 3, '2020-02-02 15:45:25', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (78, 3, '2020-02-02 15:52:32', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (79, 3, '2020-02-02 15:53:44', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (80, 3, '2020-02-02 15:54:36', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (81, 3, '2020-02-02 16:01:00', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (82, 3, '2020-02-02 16:05:19', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (83, 3, '2020-02-02 16:06:31', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (84, 3, '2020-02-02 16:17:26', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (85, 3, '2020-02-02 16:18:45', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (86, 3, '2020-02-02 16:19:05', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (87, 3, '2020-02-02 16:19:23', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (88, 3, '2020-02-02 16:22:27', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (89, 3, '2020-02-02 16:23:30', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (90, 3, '2020-02-02 16:23:48', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (91, 3, '2020-02-02 16:24:38', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (92, 3, '2020-02-02 16:25:22', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (93, 3, '2020-02-02 16:26:19', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (94, 3, '2020-02-02 16:26:31', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (95, 3, '2020-02-02 16:27:08', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (96, 3, '2020-02-02 16:31:02', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (97, 3, '2020-02-02 16:31:08', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (98, 3, '2020-02-02 16:31:25', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (99, 3, '2020-02-02 16:31:50', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (100, 3, '2020-02-02 16:33:22', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (101, 3, '2020-02-02 16:33:41', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (102, 3, '2020-02-02 16:34:58', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (103, 3, '2020-02-02 16:38:42', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (104, 3, '2020-02-02 16:39:41', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (105, 3, '2020-02-02 16:42:22', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (106, 3, '2020-02-02 16:46:21', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (107, 3, '2020-02-02 16:50:23', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (108, 3, '2020-02-02 16:51:11', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (109, 3, '2020-02-02 16:51:22', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (110, 3, '2020-02-02 16:52:00', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (111, 3, '2020-02-02 17:01:05', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (112, 3, '2020-02-03 10:43:22', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (113, 3, '2020-02-03 10:45:29', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (114, 3, '2020-02-03 10:46:33', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (115, 3, '2020-02-03 10:54:33', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (116, 3, '2020-02-03 14:24:47', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (117, 3, '2020-02-03 14:25:38', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (118, 5, '2020-02-03 15:22:28', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (119, 5, '2020-02-03 15:23:00', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (120, 5, '2020-02-03 15:24:29', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (121, 3, '2020-02-03 15:24:50', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (122, 5, '2020-02-03 15:27:18', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (123, 3, '2020-02-03 15:27:33', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (124, 3, '2020-02-03 15:29:06', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (125, 5, '2020-02-03 15:33:25', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (126, 3, '2020-02-03 15:33:51', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (127, 1, '2020-02-03 15:34:35', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (128, 3, '2020-02-03 15:34:47', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (129, 3, '2020-02-04 14:14:46', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (130, 3, '2020-02-05 10:33:35', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (131, 3, '2020-02-05 10:36:21', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (132, 3, '2020-02-05 16:34:37', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (133, 4, '2020-02-05 16:58:37', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (134, 3, '2020-02-05 16:59:03', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (135, 3, '2020-02-06 10:25:02', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (136, 3, '2020-02-07 14:34:34', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (137, 3, '2020-02-07 14:36:20', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (138, 1, '2020-02-07 14:43:34', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (139, 3, '2020-02-07 15:18:06', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (140, 3, '2020-02-07 15:20:07', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (141, 3, '2020-02-07 15:22:20', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (142, 3, '2020-02-07 15:22:28', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (143, 3, '2020-02-07 15:55:11', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (144, 3, '2020-02-07 15:56:04', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (145, 3, '2020-02-07 15:58:49', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (146, 6, '2020-02-07 16:16:21', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (147, 7, '2020-02-07 16:16:37', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (148, 3, '2020-02-07 16:18:39', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (149, 7, '2020-02-07 16:20:06', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (150, 3, '2020-02-07 16:20:44', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (151, 3, '2020-02-07 16:32:31', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (152, 3, '2020-02-07 19:32:34', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (153, 3, '2020-02-07 19:32:48', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (154, 3, '2020-02-07 19:33:01', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (155, 3, '2020-02-07 19:33:06', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (156, 3, '2020-02-07 19:33:21', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (157, 3, '2020-02-07 19:35:33', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (158, 3, '2020-02-07 19:37:10', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (159, 3, '2020-02-07 19:37:14', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (160, 3, '2020-02-07 19:37:25', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (161, 3, '2020-02-07 19:45:41', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (162, 3, '2020-02-07 19:47:45', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (163, 3, '2020-02-07 20:02:25', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (164, 6, '2020-02-07 20:10:55', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (165, 6, '2020-02-07 20:11:02', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (166, 6, '2020-02-07 20:13:44', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (167, 6, '2020-02-07 20:17:14', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (168, 3, '2020-02-07 20:17:44', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (169, 6, '2020-02-07 20:18:13', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (170, 3, '2020-02-10 10:28:14', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (171, 3, '2020-02-10 10:45:15', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (172, 3, '2020-02-10 10:57:46', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (173, 3, '2020-02-10 10:59:06', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (174, 3, '2020-02-10 11:04:19', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (175, 3, '2020-02-10 11:05:55', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (176, 3, '2020-02-10 11:06:45', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (177, 3, '2020-02-10 11:07:41', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (178, 3, '2020-02-10 11:08:13', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (179, 3, '2020-02-10 11:10:02', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (180, 6, '2020-02-10 14:25:17', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (181, 6, '2020-02-10 14:29:14', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (182, 3, '2020-02-10 16:09:16', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (183, 3, '2020-02-20 14:39:19', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (184, 8, '2020-02-20 17:14:58', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (185, 8, '2020-02-20 17:17:04', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (186, 8, '2020-02-20 17:17:42', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (187, 8, '2020-02-21 10:26:56', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (188, 8, '2020-02-21 10:28:54', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (189, 8, '2020-02-21 10:32:25', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (190, 8, '2020-02-21 10:33:41', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (191, 8, '2020-02-21 10:35:58', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (192, 8, '2020-02-21 10:36:49', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (193, 3, '2020-02-21 11:10:11', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (194, 3, '2020-02-25 16:11:13', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (195, 3, '2020-02-25 16:46:29', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (196, 3, '2020-03-07 16:33:59', '192.168.3.185', NULL, NULL),
                                                                                                       (197, 6, '2020-03-07 16:35:38', '192.168.3.185', NULL, NULL),
                                                                                                       (198, 3, '2020-03-07 17:00:09', '192.168.3.185', NULL, NULL),
                                                                                                       (199, 3, '2020-03-14 14:32:08', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (200, 8, '2020-03-14 14:32:59', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (201, 3, '2020-03-14 14:33:26', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (202, 8, '2020-03-14 14:34:57', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (203, 3, '2020-03-14 14:35:23', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (204, 8, '2020-03-14 14:36:31', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (205, 3, '2020-03-14 14:36:51', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (206, 8, '2020-03-14 14:37:31', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (207, 3, '2020-03-14 14:37:44', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (208, 8, '2020-03-14 14:38:30', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (209, 3, '2020-03-14 14:38:50', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (210, 8, '2020-03-14 14:39:26', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (211, 3, '2020-03-14 14:39:41', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (212, 3, '2020-03-15 14:23:54', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (213, 3, '2020-03-22 14:33:17', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (214, 3, '2020-03-22 14:59:51', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (215, 3, '2020-03-22 15:04:32', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (216, 3, '2020-03-29 16:14:37', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (217, 3, '2020-03-29 17:17:00', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (218, 3, '2020-04-06 16:54:49', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (219, 3, '2020-04-12 15:01:40', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (220, 3, '2020-04-19 09:50:59', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (221, 3, '2020-05-04 10:45:45', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (222, 3, '2020-05-05 11:02:44', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (223, 3, '2020-05-16 15:17:21', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (224, 3, '2020-05-17 14:58:35', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (225, 3, '2020-05-18 15:47:46', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (226, 3, '2020-05-23 16:51:15', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (227, 3, '2020-05-23 16:54:53', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (228, 3, '2020-05-23 17:00:33', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (229, 3, '2020-05-24 10:38:00', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (230, 3, '2020-06-07 09:39:31', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (231, 3, '2020-06-14 14:23:30', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (232, 3, '2020-06-14 17:11:59', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (233, 3, '2020-06-20 14:53:51', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (234, 3, '2020-06-21 14:57:36', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (235, 3, '2020-06-27 10:41:31', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (236, 3, '2020-07-05 15:54:21', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (237, 3, '2020-07-11 10:40:28', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (238, 3, '2020-07-11 10:45:01', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (239, 3, '2020-07-19 11:00:16', '192.168.3.185', NULL, NULL),
                                                                                                       (240, 3, '2020-07-19 11:46:27', '192.168.3.185', NULL, NULL),
                                                                                                       (241, 3, '2020-07-19 11:53:47', '192.168.3.185', NULL, NULL),
                                                                                                       (242, 3, '2020-07-19 14:17:37', '192.168.3.185', NULL, NULL),
                                                                                                       (243, 3, '2020-07-19 14:44:24', '192.168.3.185', NULL, NULL),
                                                                                                       (244, 3, '2020-07-19 14:44:58', '192.168.3.185', NULL, NULL),
                                                                                                       (245, 3, '2020-07-19 14:48:27', '192.168.3.185', NULL, NULL),
                                                                                                       (246, 3, '2020-07-19 14:48:57', '192.168.3.185', NULL, NULL),
                                                                                                       (247, 3, '2020-07-19 14:49:30', '192.168.3.185', NULL, NULL),
                                                                                                       (248, 3, '2020-07-19 14:50:18', '192.168.3.185', NULL, NULL),
                                                                                                       (249, 3, '2020-07-19 14:51:51', '192.168.3.185', NULL, NULL),
                                                                                                       (250, 3, '2020-07-19 14:55:27', '192.168.3.185', NULL, NULL),
                                                                                                       (251, 3, '2020-07-19 14:58:14', '192.168.3.185', NULL, NULL),
                                                                                                       (252, 6, '2020-07-19 15:04:21', '192.168.3.185', NULL, NULL),
                                                                                                       (253, 3, '2020-07-19 15:38:49', '192.168.3.185', NULL, NULL),
                                                                                                       (254, 6, '2020-07-19 16:26:24', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (255, 3, '2020-08-08 10:39:12', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (256, 3, '2020-08-09 11:06:31', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (257, 3, '2020-08-10 20:41:30', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (258, 3, '2020-08-15 10:12:25', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (259, 1, '2020-08-19 21:23:59', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (260, 1, '2020-08-19 21:25:06', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (261, 3, '2020-09-05 16:14:50', '192.168.3.185', NULL, NULL),
                                                                                                       (262, 3, '2020-09-05 16:15:37', '192.168.3.185', NULL, NULL),
                                                                                                       (263, 3, '2020-09-12 16:07:35', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (264, 6, '2020-09-12 16:08:14', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (265, 1, '2020-09-12 16:08:26', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (266, 6, '2020-09-12 16:09:08', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (267, 1, '2020-09-12 16:09:17', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (268, 3, '2020-09-13 14:22:25', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (269, 3, '2020-09-13 14:23:07', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (270, 3, '2020-09-13 14:24:21', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (271, 3, '2020-09-13 14:32:32', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (272, 1, '2020-09-19 15:43:31', '192.168.3.185', NULL, NULL),
                                                                                                       (273, 3, '2020-09-19 15:43:58', '192.168.3.185', NULL, NULL),
                                                                                                       (274, 3, '2020-09-19 15:49:44', '192.168.3.185', NULL, NULL),
                                                                                                       (275, 6, '2020-09-19 15:50:12', '192.168.3.185', NULL, NULL),
                                                                                                       (276, 6, '2020-09-19 15:50:18', '192.168.3.185', NULL, NULL),
                                                                                                       (277, 1, '2020-09-19 15:50:41', '192.168.3.185', NULL, NULL),
                                                                                                       (278, 6, '2020-09-19 15:52:28', '192.168.3.185', NULL, NULL),
                                                                                                       (279, 1, '2020-09-19 15:53:01', '192.168.3.185', NULL, NULL),
                                                                                                       (280, 1, '2020-09-19 15:53:48', '192.168.3.185', NULL, NULL),
                                                                                                       (281, 6, '2020-09-19 15:54:37', '192.168.3.185', NULL, NULL),
                                                                                                       (282, 3, '2020-09-20 11:13:50', '192.168.3.185', NULL, NULL),
                                                                                                       (283, 1, '2020-10-08 14:26:58', '0:0:0:0:0:0:0:1', NULL, NULL),
                                                                                                       (284, 1, '2020-10-08 14:30:49', '192.168.3.185', NULL, NULL),
                                                                                                       (285, 3, '2021-04-11 10:27:43', '192.168.3.227', NULL, NULL),
                                                                                                       (286, 1, '2021-04-11 10:29:19', '192.168.3.227', NULL, NULL),
                                                                                                       (287, 3, '2021-04-11 10:30:40', '192.168.3.227', NULL, NULL),
                                                                                                       (288, 3, '2021-04-11 10:37:50', '192.168.3.227', NULL, NULL),
                                                                                                       (289, 3, '2021-12-08 10:44:09', '192.168.3.4', NULL, NULL),
                                                                                                       (290, 3, '2022-04-15 15:04:51', '192.168.56.1', NULL, NULL),
                                                                                                       (291, 1, '2022-05-10 15:25:58', '192.168.56.1', NULL, NULL),
                                                                                                       (292, 1, '2022-05-10 15:31:08', '192.168.56.1', NULL, NULL),
                                                                                                       (293, 1, '2022-05-10 15:32:18', '192.168.56.1', NULL, NULL),
                                                                                                       (294, 1, '2022-05-10 15:34:17', '192.168.56.1', NULL, NULL),
                                                                                                       (295, 1, '2022-05-10 15:34:38', '192.168.56.1', NULL, NULL),
                                                                                                       (296, 1, '2022-05-10 15:54:50', '192.168.56.1', NULL, NULL),
                                                                                                       (297, 1, '2022-05-10 16:31:20', '192.168.56.1', NULL, NULL),
                                                                                                       (298, 1, '2022-05-10 16:33:45', '192.168.56.1', NULL, NULL),
                                                                                                       (299, 1, '2022-05-10 16:39:07', '192.168.56.1', NULL, NULL),
                                                                                                       (300, 1, '2022-05-18 14:53:41', '192.168.56.1', NULL, NULL),
                                                                                                       (301, 3, '2022-06-07 17:28:29', '192.168.56.1', NULL, NULL),
                                                                                                       (302, 3, '2022-06-08 09:48:32', '192.168.56.1', NULL, NULL),
                                                                                                       (303, 3, '2022-06-08 10:34:20', '192.168.56.1', NULL, NULL),
                                                                                                       (304, 3, '2022-06-08 17:09:29', '192.168.56.1', NULL, NULL),
                                                                                                       (305, 3, '2022-06-08 17:10:11', '192.168.56.1', NULL, NULL),
                                                                                                       (306, 6, '2022-06-08 17:10:55', '192.168.56.1', NULL, NULL),
                                                                                                       (307, 3, '2022-06-08 17:23:05', '192.168.56.1', NULL, NULL),
                                                                                                       (308, 3, '2022-06-08 17:30:51', '192.168.56.1', NULL, NULL),
                                                                                                       (309, 3, '2022-06-08 17:31:42', '192.168.56.1', NULL, NULL),
                                                                                                       (310, 3, '2022-06-08 17:31:48', '192.168.56.1', NULL, NULL),
                                                                                                       (311, 3, '2022-06-08 21:03:56', '192.168.56.1', NULL, NULL),
                                                                                                       (312, 3, '2022-06-09 10:41:31', '192.168.56.1', NULL, NULL),
                                                                                                       (313, 3, '2022-06-09 15:18:46', '192.168.56.1', NULL, NULL),
                                                                                                       (314, 3, '2022-06-10 15:43:15', '192.168.56.1', NULL, NULL),
                                                                                                       (315, 3, '2022-06-10 15:52:27', '192.168.56.1', NULL, NULL),
                                                                                                       (316, 3, '2022-06-15 14:41:59', '192.168.56.1', NULL, NULL),
                                                                                                       (317, 3, '2022-06-23 16:24:09', '192.168.3.6', NULL, NULL),
                                                                                                       (318, 3, '2022-06-23 16:41:33', '192.168.3.6', NULL, NULL),
                                                                                                       (319, 3, '2022-06-23 16:42:50', '192.168.3.6', NULL, NULL),
                                                                                                       (320, 3, '2022-06-23 16:42:51', '192.168.3.6', NULL, NULL),
                                                                                                       (321, 3, '2022-06-23 16:42:52', '192.168.3.6', NULL, NULL),
                                                                                                       (322, 3, '2022-06-23 16:42:53', '192.168.3.6', NULL, NULL),
                                                                                                       (323, 3, '2022-06-23 16:43:07', '192.168.3.6', NULL, NULL),
                                                                                                       (324, 3, '2022-06-23 16:44:56', '192.168.3.6', NULL, NULL),
                                                                                                       (325, 3, '2022-06-23 16:45:42', '192.168.3.6', NULL, NULL),
                                                                                                       (326, 3, '2022-06-23 16:50:08', '192.168.3.6', NULL, NULL),
                                                                                                       (327, 3, '2022-06-24 15:19:04', '192.168.3.227', NULL, NULL),
                                                                                                       (328, 3, '2022-06-24 15:25:52', '192.168.3.227', NULL, NULL),
                                                                                                       (329, 3, '2022-06-24 15:40:29', '192.168.3.227', NULL, NULL),
                                                                                                       (330, 3, '2022-06-25 15:13:52', '192.168.56.1', NULL, NULL),
                                                                                                       (331, 3, '2022-06-25 15:25:12', '192.168.56.1', NULL, NULL),
                                                                                                       (332, 3, '2022-06-27 16:38:37', '192.168.56.1', NULL, NULL),
                                                                                                       (333, 3, '2022-07-24 10:10:06', '192.168.3.227', NULL, NULL),
                                                                                                       (334, 1, '2022-07-25 17:15:55', '192.168.56.1', NULL, NULL),
                                                                                                       (335, 3, '2022-07-27 09:41:32', '192.168.3.227', NULL, NULL),
                                                                                                       (336, 1, '2022-07-28 16:56:10', '192.168.56.1', NULL, NULL),
                                                                                                       (337, 1, '2022-07-28 16:56:25', '192.168.56.1', NULL, NULL),
                                                                                                       (338, 8, '2022-08-07 14:46:00', '192.168.56.1', NULL, NULL),
                                                                                                       (339, 9, '2022-08-07 14:53:32', '192.168.56.1', NULL, NULL),
                                                                                                       (340, 9, '2022-08-07 14:53:46', '192.168.56.1', NULL, NULL),
                                                                                                       (341, 9, '2022-08-07 14:56:19', '192.168.56.1', NULL, NULL),
                                                                                                       (342, 1, '2022-08-09 10:53:55', '192.168.56.1', NULL, NULL),
                                                                                                       (343, 1, '2022-08-09 10:54:36', '192.168.56.1', NULL, NULL),
                                                                                                       (344, 1, '2022-08-09 11:00:06', '192.168.56.1', NULL, NULL),
                                                                                                       (345, 1, '2022-08-09 11:02:04', '192.168.56.1', NULL, NULL),
                                                                                                       (346, 1, '2022-08-09 15:48:14', '192.168.56.1', NULL, NULL),
                                                                                                       (347, 1, '2022-08-16 16:35:24', '192.168.56.1', NULL, NULL),
                                                                                                       (348, 1, '2022-08-17 15:03:52', '192.168.56.1', NULL, NULL),
                                                                                                       (349, 1, '2022-08-20 16:49:19', '192.168.56.1', NULL, NULL),
                                                                                                       (350, 1, '2022-08-23 14:54:06', '192.168.56.1', NULL, NULL),
                                                                                                       (351, 1, '2022-08-31 17:16:35', '192.168.56.1', NULL, NULL),
                                                                                                       (352, 3, '2022-10-14 15:31:42', '192.168.56.1', NULL, NULL),
                                                                                                       (353, 3, '2022-10-14 15:42:39', '192.168.56.1', NULL, NULL),
                                                                                                       (354, 3, '2022-10-14 15:44:08', '192.168.56.1', NULL, NULL),
                                                                                                       (355, 3, '2022-10-14 15:46:23', '192.168.56.1', NULL, NULL),
                                                                                                       (356, 3, '2022-10-14 15:46:35', '192.168.56.1', NULL, NULL),
                                                                                                       (357, 3, '2022-10-14 16:06:11', '192.168.56.1', NULL, NULL),
                                                                                                       (358, 3, '2022-10-14 16:24:08', '192.168.56.1', NULL, NULL),
                                                                                                       (359, 3, '2022-10-17 16:44:52', '192.168.56.1', NULL, NULL),
                                                                                                       (360, 3, '2022-10-17 16:49:42', '192.168.56.1', NULL, NULL),
                                                                                                       (361, 3, '2022-10-17 16:49:53', '192.168.56.1', NULL, NULL),
                                                                                                       (362, 3, '2022-10-17 17:03:10', '192.168.56.1', NULL, NULL),
                                                                                                       (363, 3, '2022-10-17 17:03:22', '192.168.56.1', NULL, NULL),
                                                                                                       (364, 3, '2022-10-17 21:00:48', '192.168.56.1', NULL, NULL),
                                                                                                       (365, 3, '2022-10-24 16:32:31', '192.168.56.1', NULL, NULL),
                                                                                                       (366, 3, '2022-10-26 16:31:17', '192.168.56.1', NULL, NULL),
                                                                                                       (367, 3, '2022-10-26 16:50:48', '192.168.56.1', NULL, NULL),
                                                                                                       (368, 3, '2022-10-26 16:52:28', '192.168.56.1', NULL, NULL),
                                                                                                       (369, 3, '2022-10-27 17:21:28', '192.168.56.1', NULL, NULL),
                                                                                                       (370, 3, '2022-10-28 10:52:22', '192.168.56.1', NULL, NULL),
                                                                                                       (371, 3, '2022-11-04 16:09:08', '192.168.56.1', NULL, NULL),
                                                                                                       (372, 3, '2022-11-08 10:27:27', '192.168.56.1', NULL, NULL),
                                                                                                       (373, 3, '2022-11-09 10:42:30', '192.168.56.1', NULL, NULL),
                                                                                                       (374, 3, '2022-11-10 15:03:08', '192.168.56.1', NULL, NULL),
                                                                                                       (375, 3, '2022-11-11 10:11:11', '192.168.56.1', NULL, NULL),
                                                                                                       (376, 3, '2022-11-14 16:33:30', '192.168.56.1', NULL, NULL),
                                                                                                       (377, 3, '2022-11-15 10:54:02', '192.168.56.1', NULL, NULL),
                                                                                                       (378, 3, '2022-11-15 15:16:35', '192.168.56.1', NULL, NULL),
                                                                                                       (379, 3, '2022-11-15 15:17:41', '192.168.56.1', NULL, NULL),
                                                                                                       (380, 3, '2022-11-15 15:17:47', '192.168.56.1', NULL, NULL),
                                                                                                       (381, 1, '2022-11-15 15:19:56', '192.168.56.1', NULL, NULL),
                                                                                                       (382, 3, '2022-11-15 15:20:12', '192.168.56.1', NULL, NULL),
                                                                                                       (383, 3, '2022-11-15 15:22:22', '192.168.56.1', NULL, NULL),
                                                                                                       (384, 3, '2022-11-16 10:39:08', '192.168.56.1', NULL, NULL),
                                                                                                       (385, 1, '2022-11-24 20:02:12', '192.168.56.1', NULL, NULL),
                                                                                                       (386, 3, '2022-11-28 15:24:02', '192.168.56.1', NULL, NULL),
                                                                                                       (387, 3, '2022-11-30 09:34:28', '192.168.56.1', NULL, NULL),
                                                                                                       (388, 3, '2022-12-05 09:43:58', '192.168.56.1', NULL, NULL),
                                                                                                       (389, 3, '2022-12-09 17:18:09', '192.168.56.1', NULL, NULL),
                                                                                                       (390, 3, '2022-12-15 14:53:39', '192.168.56.1', NULL, NULL),
                                                                                                       (391, 3, '2022-12-15 16:11:54', '192.168.56.1', NULL, NULL),
                                                                                                       (392, 3, '2022-12-20 15:55:18', '192.168.56.1', NULL, NULL),
                                                                                                       (393, 3, '2022-12-21 14:49:30', '192.168.56.1', NULL, NULL),
                                                                                                       (394, 3, '2022-12-23 09:49:50', '192.168.56.1', NULL, NULL),
                                                                                                       (395, 3, '2023-01-04 10:17:44', '192.168.56.1', NULL, NULL),
                                                                                                       (396, 3, '2023-01-04 15:28:47', '192.168.56.1', NULL, NULL),
                                                                                                       (397, 3, '2023-01-05 10:13:43', '192.168.56.1', NULL, NULL),
                                                                                                       (398, 3, '2023-01-06 09:49:23', '192.168.56.1', NULL, NULL),
                                                                                                       (399, 3, '2023-01-06 10:04:19', '192.168.56.1', NULL, NULL),
                                                                                                       (400, 3, '2023-01-06 10:07:06', '192.168.56.1', NULL, NULL),
                                                                                                       (401, 3, '2023-01-06 16:21:31', '192.168.56.1', NULL, NULL),
                                                                                                       (402, 3, '2023-01-09 16:50:30', '192.168.56.1', NULL, NULL),
                                                                                                       (403, 3, '2023-01-10 10:05:52', '192.168.56.1', NULL, NULL),
                                                                                                       (404, 3, '2023-01-10 17:09:44', '192.168.56.1', NULL, NULL),
                                                                                                       (405, 3, '2023-01-11 10:17:17', '192.168.56.1', NULL, NULL),
                                                                                                       (406, 3, '2023-01-13 09:35:37', '192.168.56.1', NULL, NULL),
                                                                                                       (407, 3, '2023-01-13 09:40:51', '192.168.56.1', NULL, NULL),
                                                                                                       (408, 3, '2023-01-31 10:46:52', '192.168.56.1', NULL, NULL),
                                                                                                       (409, 3, '2023-02-08 17:11:11', '192.168.56.1', NULL, NULL),
                                                                                                       (410, 3, '2023-02-09 15:46:41', '192.168.56.1', NULL, NULL),
                                                                                                       (411, 3, '2023-02-10 17:23:52', '192.168.56.1', NULL, NULL),
                                                                                                       (412, 3, '2023-05-11 15:29:54', '192.168.56.1', NULL, NULL),
                                                                                                       (413, 3, '2024-04-20 19:16:21', '192.168.1.5', NULL, NULL),
                                                                                                       (414, 3, '2024-04-20 19:53:03', '192.168.1.5', NULL, NULL),
                                                                                                       (415, 3, '2024-04-22 11:34:12', '10.0.0.172', NULL, NULL),
                                                                                                       (416, 3, '2024-04-22 11:35:13', '10.0.0.172', NULL, NULL),
                                                                                                       (417, 3, '2024-04-23 13:33:52', '10.0.0.172', NULL, NULL),
                                                                                                       (418, 3, '2024-04-23 14:56:07', '10.0.0.172', NULL, NULL),
                                                                                                       (419, 3, '2024-04-23 15:04:01', '10.0.0.172', NULL, NULL),
                                                                                                       (420, 11, '2024-04-25 17:48:46', '10.0.0.172', NULL, NULL),
                                                                                                       (421, 3, '2024-04-25 18:15:08', '10.0.0.172', NULL, NULL),
                                                                                                       (422, 11, '2024-04-25 18:19:13', '10.0.0.172', NULL, NULL),
                                                                                                       (423, 3, '2024-04-26 20:53:17', '192.168.1.8', NULL, NULL),
                                                                                                       (424, 3, '2024-04-26 22:47:01', '192.168.1.8', NULL, NULL),
                                                                                                       (425, 11, '2024-04-28 13:29:33', '192.168.1.5', NULL, NULL),
                                                                                                       (426, 3, '2024-05-09 13:48:55', '10.0.0.172', NULL, NULL);

-- 导出  表 paper-cutting.ums_admin_permission_relation 结构
CREATE TABLE IF NOT EXISTS `ums_admin_permission_relation` (
                                                               `id` bigint NOT NULL AUTO_INCREMENT,
                                                               `admin_id` bigint DEFAULT NULL,
                                                               `permission_id` bigint DEFAULT NULL,
                                                               `type` int DEFAULT NULL,
                                                               PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='后台用户和权限关系表(除角色中定义的权限以外的加减权限)';

-- 正在导出表  paper-cutting.ums_admin_permission_relation 的数据：~0 rows (大约)

-- 导出  表 paper-cutting.ums_admin_role_relation 结构
CREATE TABLE IF NOT EXISTS `ums_admin_role_relation` (
                                                         `id` bigint NOT NULL AUTO_INCREMENT,
                                                         `admin_id` bigint DEFAULT NULL,
                                                         `role_id` bigint DEFAULT NULL,
                                                         PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='后台用户和角色关系表';

-- 正在导出表  paper-cutting.ums_admin_role_relation 的数据：~8 rows (大约)
INSERT INTO `ums_admin_role_relation` (`id`, `admin_id`, `role_id`) VALUES
                                                                        (26, 3, 5),
                                                                        (27, 6, 1),
                                                                        (28, 7, 2),
                                                                        (29, 1, 5),
                                                                        (30, 4, 5),
                                                                        (31, 8, 1),
                                                                        (33, 11, 1),
                                                                        (36, 16, 1);

-- 导出  表 paper-cutting.ums_admin_shop_relation 结构
CREATE TABLE IF NOT EXISTS `ums_admin_shop_relation` (
                                                         `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                                         `admin_id` bigint NOT NULL DEFAULT '0' COMMENT '用户id',
                                                         `shop_id` int NOT NULL COMMENT '店铺id',
                                                         PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=1519267843 DEFAULT CHARSET=utf8mb4     COMMENT='用户店铺关系表';

-- 正在导出表  paper-cutting.ums_admin_shop_relation 的数据：~1 rows (大约)
INSERT INTO `ums_admin_shop_relation` (`id`, `admin_id`, `shop_id`) VALUES
    (1, 11, 1);

-- 导出  表 paper-cutting.ums_menu 结构
CREATE TABLE IF NOT EXISTS `ums_menu` (
                                          `id` bigint NOT NULL AUTO_INCREMENT,
                                          `parent_id` bigint DEFAULT NULL COMMENT '父级ID',
                                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                          `title` varchar(100) CHARACTER SET utf8mb3    DEFAULT NULL COMMENT '菜单名称',
    `level` int DEFAULT NULL COMMENT '菜单级数',
    `sort` int DEFAULT NULL COMMENT '菜单排序',
    `name` varchar(100) CHARACTER SET utf8mb3    DEFAULT NULL COMMENT '前端名称',
    `icon` varchar(200) CHARACTER SET utf8mb3    DEFAULT NULL COMMENT '前端图标',
    `hidden` int DEFAULT NULL COMMENT '前端隐藏',
    PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='后台菜单表';

-- 正在导出表  paper-cutting.ums_menu 的数据：~24 rows (大约)
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES
                                                                                                                  (1, 0, '2020-02-02 14:50:36', '商品', 0, 0, 'pms', 'product', 0),
                                                                                                                  (2, 1, '2020-02-02 14:51:50', '商品列表', 1, 0, 'product', 'product-list', 0),
                                                                                                                  (3, 1, '2020-02-02 14:52:44', '添加商品', 1, 0, 'addProduct', 'product-add', 0),
                                                                                                                  (4, 1, '2020-02-02 14:53:51', '商品分类', 1, 0, 'productCate', 'product-cate', 0),
                                                                                                                  (5, 1, '2020-02-02 14:54:51', '商品类型', 1, 0, 'productAttr', 'product-attr', 0),
                                                                                                                  (6, 1, '2020-02-02 14:56:29', '品牌管理', 1, 0, 'brand', 'product-brand', 0),
                                                                                                                  (7, 0, '2020-02-02 16:54:07', '订单', 0, 0, 'oms', 'order', 0),
                                                                                                                  (8, 7, '2020-02-02 16:55:18', '订单列表', 1, 0, 'order', 'product-list', 0),
                                                                                                                  (9, 7, '2020-02-02 16:56:46', '订单设置', 1, 0, 'orderSetting', 'order-setting', 0),
                                                                                                                  (10, 7, '2020-02-02 16:57:39', '退货申请处理', 1, 0, 'returnApply', 'order-return', 0),
                                                                                                                  (11, 7, '2020-02-02 16:59:40', '退货原因设置', 1, 0, 'returnReason', 'order-return-reason', 0),
                                                                                                                  (12, 0, '2020-02-04 16:18:00', '营销', 0, 0, 'sms', 'sms', 0),
                                                                                                                  (13, 12, '2020-02-04 16:19:22', '秒杀活动列表', 1, 0, 'flash', 'sms-flash', 0),
                                                                                                                  (14, 12, '2020-02-04 16:20:16', '优惠券列表', 1, 0, 'coupon', 'sms-coupon', 0),
                                                                                                                  (16, 12, '2020-02-07 16:22:38', '品牌推荐', 1, 0, 'homeBrand', 'product-brand', 0),
                                                                                                                  (17, 12, '2020-02-07 16:23:14', '新品推荐', 1, 0, 'homeNew', 'sms-new', 0),
                                                                                                                  (18, 12, '2020-02-07 16:26:38', '人气推荐', 1, 0, 'homeHot', 'sms-hot', 0),
                                                                                                                  (19, 12, '2020-02-07 16:28:16', '专题推荐', 1, 0, 'homeSubject', 'sms-subject', 0),
                                                                                                                  (20, 12, '2020-02-07 16:28:42', '广告列表', 1, 0, 'homeAdvertise', 'sms-ad', 0),
                                                                                                                  (21, 0, '2020-02-07 16:29:13', '权限', 0, 0, 'ums', 'ums', 0),
                                                                                                                  (22, 21, '2020-02-07 16:29:51', '用户列表', 1, 0, 'admin', 'ums-admin', 0),
                                                                                                                  (23, 21, '2020-02-07 16:30:13', '角色列表', 1, 0, 'role', 'ums-role', 0),
                                                                                                                  (24, 21, '2020-02-07 16:30:53', '菜单列表', 1, 0, 'menu', 'ums-menu', 0),
                                                                                                                  (25, 21, '2020-02-07 16:31:13', '资源列表', 1, 0, 'resource', 'ums-resource', 0);

-- 导出  表 paper-cutting.ums_permission 结构
CREATE TABLE IF NOT EXISTS `ums_permission` (
                                                `id` bigint NOT NULL AUTO_INCREMENT,
                                                `pid` bigint DEFAULT NULL COMMENT '父级权限id',
                                                `name` varchar(100) CHARACTER SET utf8mb3    DEFAULT NULL COMMENT '名称',
    `value` varchar(200) CHARACTER SET utf8mb3    DEFAULT NULL COMMENT '权限值',
    `icon` varchar(500) CHARACTER SET utf8mb3    DEFAULT NULL COMMENT '图标',
    `type` int DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
    `uri` varchar(200) CHARACTER SET utf8mb3    DEFAULT NULL COMMENT '前端资源路径',
    `status` int DEFAULT NULL COMMENT '启用状态；0->禁用；1->启用',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `sort` int DEFAULT NULL COMMENT '排序',
    PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='后台用户权限表';

-- 正在导出表  paper-cutting.ums_permission 的数据：~18 rows (大约)
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES
                                                                                                                        (1, 0, '商品', NULL, NULL, 0, NULL, 1, '2018-09-29 16:15:14', 0),
                                                                                                                        (2, 1, '商品列表', 'pms:product:read', NULL, 1, '/pms/goods/index', 1, '2018-09-29 16:17:01', 0),
                                                                                                                        (3, 1, '添加商品', 'pms:product:create', NULL, 1, '/pms/product/add', 1, '2018-09-29 16:18:51', 0),
                                                                                                                        (4, 1, '商品分类', 'pms:productCategory:read', NULL, 1, '/pms/productCate/index', 1, '2018-09-29 16:23:07', 0),
                                                                                                                        (5, 1, '商品类型', 'pms:productAttribute:read', NULL, 1, '/pms/productAttr/index', 1, '2018-09-29 16:24:43', 0),
                                                                                                                        (6, 1, '品牌管理', 'pms:brand:read', NULL, 1, '/pms/brand/index', 1, '2018-09-29 16:25:45', 0),
                                                                                                                        (7, 2, '编辑商品', 'pms:product:update', NULL, 2, '/pms/product/updateProduct', 1, '2018-09-29 16:34:23', 0),
                                                                                                                        (8, 2, '删除商品', 'pms:product:delete', NULL, 2, '/pms/product/delete', 1, '2018-09-29 16:38:33', 0),
                                                                                                                        (9, 4, '添加商品分类', 'pms:productCategory:create', NULL, 2, '/pms/productCate/create', 1, '2018-09-29 16:43:23', 0),
                                                                                                                        (10, 4, '修改商品分类', 'pms:productCategory:update', NULL, 2, '/pms/productCate/update', 1, '2018-09-29 16:43:55', 0),
                                                                                                                        (11, 4, '删除商品分类', 'pms:productCategory:delete', NULL, 2, '/pms/productAttr/delete', 1, '2018-09-29 16:44:38', 0),
                                                                                                                        (12, 5, '添加商品类型', 'pms:productAttribute:create', NULL, 2, '/pms/productAttr/create', 1, '2018-09-29 16:45:25', 0),
                                                                                                                        (13, 5, '修改商品类型', 'pms:productAttribute:update', NULL, 2, '/pms/productAttr/update', 1, '2018-09-29 16:48:08', 0),
                                                                                                                        (14, 5, '删除商品类型', 'pms:productAttribute:delete', NULL, 2, '/pms/productAttr/delete', 1, '2018-09-29 16:48:44', 0),
                                                                                                                        (15, 6, '添加品牌', 'pms:brand:create', NULL, 2, '/pms/brand/add', 1, '2018-09-29 16:49:34', 0),
                                                                                                                        (16, 6, '修改品牌', 'pms:brand:update', NULL, 2, '/pms/brand/update', 1, '2018-09-29 16:50:55', 0),
                                                                                                                        (17, 6, '删除品牌', 'pms:brand:delete', NULL, 2, '/pms/brand/delete', 1, '2018-09-29 16:50:59', 0),
                                                                                                                        (18, 0, '首页', NULL, NULL, 0, NULL, 1, '2018-09-29 16:51:57', 0);

-- 导出  表 paper-cutting.ums_resource 结构
CREATE TABLE IF NOT EXISTS `ums_resource` (
                                              `id` bigint NOT NULL AUTO_INCREMENT,
                                              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                              `name` varchar(200) CHARACTER SET utf8mb3    DEFAULT NULL COMMENT '资源名称',
    `url` varchar(200) CHARACTER SET utf8mb3    DEFAULT NULL COMMENT '资源URL',
    `description` varchar(500) CHARACTER SET utf8mb3    DEFAULT NULL COMMENT '描述',
    `category_id` bigint DEFAULT NULL COMMENT '资源分类ID',
    PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='后台资源表';

-- 正在导出表  paper-cutting.ums_resource 的数据：~31 rows (大约)
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES
                                                                                                  (1, '2020-02-04 17:04:55', '商品品牌管理', '/shop/**', NULL, 1),
                                                                                                  (2, '2020-02-04 17:05:35', '商品属性分类管理', '/productAttribute/category/**', NULL, 1),
                                                                                                  (3, '2020-02-04 17:06:13', '商品属性管理', '/productAttribute/**', NULL, 1),
                                                                                                  (4, '2020-02-04 17:07:15', '商品分类管理', '/goodsCategory/**', NULL, 1),
                                                                                                  (5, '2020-02-04 17:09:16', '商品管理', '/goods/**', NULL, 1),
                                                                                                  (6, '2020-02-04 17:09:53', '商品库存管理', '/sku/**', NULL, 1),
                                                                                                  (8, '2020-02-05 14:43:37', '订单管理', '/order/**', '', 2),
                                                                                                  (9, '2020-02-05 14:44:22', ' 订单退货申请管理', '/returnApply/**', '', 2),
                                                                                                  (10, '2020-02-05 14:45:08', '退货原因管理', '/returnReason/**', '', 2),
                                                                                                  (11, '2020-02-05 14:45:43', '订单设置管理', '/orderSetting/**', '', 2),
                                                                                                  (12, '2020-02-05 14:46:23', '收货地址管理', '/companyAddress/**', '', 2),
                                                                                                  (13, '2020-02-07 16:37:22', '优惠券管理', '/coupon/**', '', 3),
                                                                                                  (14, '2020-02-07 16:37:59', '优惠券领取记录管理', '/couponHistory/**', '', 3),
                                                                                                  (15, '2020-02-07 16:38:28', '限时购活动管理', '/flash/**', '', 3),
                                                                                                  (16, '2020-02-07 16:38:59', '限时购商品关系管理', '/flashProductRelation/**', '', 3),
                                                                                                  (17, '2020-02-07 16:39:22', '限时购场次管理', '/flashSession/**', '', 3),
                                                                                                  (18, '2020-02-07 16:40:07', '首页轮播广告管理', '/home/advertise/**', '', 3),
                                                                                                  (19, '2020-02-07 16:40:34', '首页品牌管理', '/home/brand/**', '', 3),
                                                                                                  (20, '2020-02-07 16:41:06', '首页新品管理', '/home/newProduct/**', '', 3),
                                                                                                  (21, '2020-02-07 16:42:16', '首页人气推荐管理', '/home/recommendProduct/**', '', 3),
                                                                                                  (22, '2020-02-07 16:42:48', '首页专题推荐管理', '/home/recommendSubject/**', '', 3),
                                                                                                  (23, '2020-02-07 16:44:56', ' 商品优选管理', '/prefrenceArea/**', '', 5),
                                                                                                  (24, '2020-02-07 16:45:39', '商品专题管理', '/subject/**', '', 5),
                                                                                                  (25, '2020-02-07 16:47:34', '后台用户管理', '/admin/**', '', 4),
                                                                                                  (26, '2020-02-07 16:48:24', '后台用户角色管理', '/role/**', '', 4),
                                                                                                  (27, '2020-02-07 16:48:48', '后台菜单管理', '/menu/**', '', 4),
                                                                                                  (28, '2020-02-07 16:49:18', '后台资源分类管理', '/resourceCategory/**', '', 4),
                                                                                                  (29, '2020-02-07 16:49:45', '后台资源管理', '/resource/**', '', 4),
                                                                                                  (30, '2020-09-19 15:47:57', '会员等级管理', '/memberLevel/**', '', 7),
                                                                                                  (31, '2020-09-19 15:51:29', '获取登录用户信息', '/admin/info', '用户登录必配', 4),
                                                                                                  (32, '2020-09-19 15:53:34', '用户登出', '/admin/logout', '用户登出必配', 4);

-- 导出  表 paper-cutting.ums_resource_category 结构
CREATE TABLE IF NOT EXISTS `ums_resource_category` (
                                                       `id` bigint NOT NULL AUTO_INCREMENT,
                                                       `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                                       `name` varchar(200) CHARACTER SET utf8mb3    DEFAULT NULL COMMENT '分类名称',
    `sort` int DEFAULT NULL COMMENT '排序',
    PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='资源分类表';

-- 正在导出表  paper-cutting.ums_resource_category 的数据：~6 rows (大约)
INSERT INTO `ums_resource_category` (`id`, `create_time`, `name`, `sort`) VALUES
                                                                              (1, '2020-02-05 10:21:44', '商品模块', 0),
                                                                              (2, '2020-02-05 10:22:34', '订单模块', 0),
                                                                              (3, '2020-02-05 10:22:48', '营销模块', 0),
                                                                              (4, '2020-02-05 10:23:04', '权限模块', 0),
                                                                              (5, '2020-02-07 16:34:27', '内容模块', 0),
                                                                              (7, '2020-09-19 15:49:08', '其他模块', 0);

-- 导出  表 paper-cutting.ums_role 结构
CREATE TABLE IF NOT EXISTS `ums_role` (
                                          `id` bigint NOT NULL AUTO_INCREMENT,
                                          `name` varchar(100) CHARACTER SET utf8mb3    DEFAULT NULL COMMENT '名称',
    `description` varchar(500) CHARACTER SET utf8mb3    DEFAULT NULL COMMENT '描述',
    `admin_count` int DEFAULT NULL COMMENT '后台用户数量',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `status` int DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
    `sort` int DEFAULT '0',
    PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='后台用户角色表';

-- 正在导出表  paper-cutting.ums_role 的数据：~3 rows (大约)
INSERT INTO `ums_role` (`id`, `name`, `description`, `admin_count`, `create_time`, `status`, `sort`) VALUES
                                                                                                         (1, '商品管理员', '只能查看及操作商品', 0, '2020-02-03 16:50:37', 1, 0),
                                                                                                         (2, '订单管理员', '只能查看及操作订单', 0, '2018-09-30 15:53:45', 1, 0),
                                                                                                         (5, '超级管理员', '拥有所有查看和操作功能', 0, '2020-02-02 15:11:05', 1, 0);

-- 导出  表 paper-cutting.ums_role_menu_relation 结构
CREATE TABLE IF NOT EXISTS `ums_role_menu_relation` (
                                                        `id` bigint NOT NULL AUTO_INCREMENT,
                                                        `role_id` bigint DEFAULT NULL COMMENT '角色ID',
                                                        `menu_id` bigint DEFAULT NULL COMMENT '菜单ID',
                                                        PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='后台角色菜单关系表';

-- 正在导出表  paper-cutting.ums_role_menu_relation 的数据：~35 rows (大约)
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES
                                                                      (53, 2, 7),
                                                                      (54, 2, 8),
                                                                      (55, 2, 9),
                                                                      (56, 2, 10),
                                                                      (57, 2, 11),
                                                                      (72, 5, 1),
                                                                      (73, 5, 2),
                                                                      (74, 5, 3),
                                                                      (75, 5, 4),
                                                                      (76, 5, 5),
                                                                      (77, 5, 6),
                                                                      (78, 5, 7),
                                                                      (79, 5, 8),
                                                                      (80, 5, 9),
                                                                      (81, 5, 10),
                                                                      (82, 5, 11),
                                                                      (83, 5, 12),
                                                                      (84, 5, 13),
                                                                      (85, 5, 14),
                                                                      (86, 5, 16),
                                                                      (87, 5, 17),
                                                                      (88, 5, 18),
                                                                      (89, 5, 19),
                                                                      (90, 5, 20),
                                                                      (91, 5, 21),
                                                                      (92, 5, 22),
                                                                      (93, 5, 23),
                                                                      (94, 5, 24),
                                                                      (95, 5, 25),
                                                                      (121, 1, 1),
                                                                      (122, 1, 2),
                                                                      (123, 1, 3),
                                                                      (124, 1, 4),
                                                                      (125, 1, 5),
                                                                      (126, 1, 6);

-- 导出  表 paper-cutting.ums_role_permission_relation 结构
CREATE TABLE IF NOT EXISTS `ums_role_permission_relation` (
                                                              `id` bigint NOT NULL AUTO_INCREMENT,
                                                              `role_id` bigint DEFAULT NULL,
                                                              `permission_id` bigint DEFAULT NULL,
                                                              PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='后台用户角色和权限关系表';

-- 正在导出表  paper-cutting.ums_role_permission_relation 的数据：~17 rows (大约)
INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`) VALUES
                                                                                  (1, 1, 1),
                                                                                  (2, 1, 2),
                                                                                  (3, 1, 3),
                                                                                  (4, 1, 7),
                                                                                  (5, 1, 8),
                                                                                  (6, 2, 4),
                                                                                  (7, 2, 9),
                                                                                  (8, 2, 10),
                                                                                  (9, 2, 11),
                                                                                  (10, 3, 5),
                                                                                  (11, 3, 12),
                                                                                  (12, 3, 13),
                                                                                  (13, 3, 14),
                                                                                  (14, 4, 6),
                                                                                  (15, 4, 15),
                                                                                  (16, 4, 16),
                                                                                  (17, 4, 17);

-- 导出  表 paper-cutting.ums_role_resource_relation 结构
CREATE TABLE IF NOT EXISTS `ums_role_resource_relation` (
                                                            `id` bigint NOT NULL AUTO_INCREMENT,
                                                            `role_id` bigint DEFAULT NULL COMMENT '角色ID',
                                                            `resource_id` bigint DEFAULT NULL COMMENT '资源ID',
                                                            PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=249 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='后台角色资源关系表';

-- 正在导出表  paper-cutting.ums_role_resource_relation 的数据：~46 rows (大约)
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES
                                                                              (194, 5, 1),
                                                                              (195, 5, 2),
                                                                              (196, 5, 3),
                                                                              (197, 5, 4),
                                                                              (198, 5, 5),
                                                                              (199, 5, 6),
                                                                              (200, 5, 8),
                                                                              (201, 5, 9),
                                                                              (202, 5, 10),
                                                                              (203, 5, 11),
                                                                              (204, 5, 12),
                                                                              (205, 5, 13),
                                                                              (206, 5, 14),
                                                                              (207, 5, 15),
                                                                              (208, 5, 16),
                                                                              (209, 5, 17),
                                                                              (210, 5, 18),
                                                                              (211, 5, 19),
                                                                              (212, 5, 20),
                                                                              (213, 5, 21),
                                                                              (214, 5, 22),
                                                                              (215, 5, 23),
                                                                              (216, 5, 24),
                                                                              (217, 5, 25),
                                                                              (218, 5, 26),
                                                                              (219, 5, 27),
                                                                              (220, 5, 28),
                                                                              (221, 5, 29),
                                                                              (222, 5, 30),
                                                                              (232, 2, 8),
                                                                              (233, 2, 9),
                                                                              (234, 2, 10),
                                                                              (235, 2, 11),
                                                                              (236, 2, 12),
                                                                              (237, 2, 31),
                                                                              (238, 2, 32),
                                                                              (239, 1, 1),
                                                                              (240, 1, 2),
                                                                              (241, 1, 3),
                                                                              (242, 1, 4),
                                                                              (243, 1, 5),
                                                                              (244, 1, 6),
                                                                              (245, 1, 23),
                                                                              (246, 1, 24),
                                                                              (247, 1, 31),
                                                                              (248, 1, 32);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
