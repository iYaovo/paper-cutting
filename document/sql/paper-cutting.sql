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
CREATE DATABASE IF NOT EXISTS `paper-cutting` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `paper-cutting`;

-- 导出  表 paper-cutting.buyer_info 结构
CREATE TABLE IF NOT EXISTS `buyer_info` (
  `buyer_id` bigint NOT NULL,
  `buyer_name` varchar(50) NOT NULL COMMENT '买家名称',
  `buyer_account` varchar(20) NOT NULL DEFAULT '' COMMENT '买家账号',
  `buyer_password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '买家密码',
  `buyer_sex` tinyint NOT NULL COMMENT '性别(0男,1女,2保密)',
  `buyer_hobby` varchar(50) NOT NULL COMMENT '买家爱好',
  `pic_url` varchar(255) NOT NULL COMMENT '头像',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除(默认0)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='买家信息表';

-- 正在导出表  paper-cutting.buyer_info 的数据：~0 rows (大约)

-- 导出  表 paper-cutting.cart_info 结构
CREATE TABLE IF NOT EXISTS `cart_info` (
  `cart_id` int unsigned NOT NULL DEFAULT '0',
  `buyer_id` bigint NOT NULL COMMENT '用户id',
  `goods_id` int NOT NULL DEFAULT '0' COMMENT '商品id',
  `goods_number` int NOT NULL DEFAULT '1' COMMENT '购物车中商品数量',
  PRIMARY KEY (`cart_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  paper-cutting.cart_info 的数据：~0 rows (大约)

-- 导出  表 paper-cutting.daily_sign 结构
CREATE TABLE IF NOT EXISTS `daily_sign` (
  `daily_sign_id` int NOT NULL AUTO_INCREMENT,
  `buyer_id` bigint NOT NULL COMMENT '买家id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '签到时间',
  PRIMARY KEY (`daily_sign_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='每日签到表';

-- 正在导出表  paper-cutting.daily_sign 的数据：~0 rows (大约)

-- 导出  表 paper-cutting.goods_collection 结构
CREATE TABLE IF NOT EXISTS `goods_collection` (
  `goods_collection_id` int unsigned NOT NULL AUTO_INCREMENT,
  `goods_id` int NOT NULL COMMENT '商品id',
  `buyer_id` bigint NOT NULL COMMENT '用户id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '收藏时间',
  PRIMARY KEY (`goods_collection_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品收藏';

-- 正在导出表  paper-cutting.goods_collection 的数据：~0 rows (大约)

-- 导出  表 paper-cutting.goods_first_category 结构
CREATE TABLE IF NOT EXISTS `goods_first_category` (
  `goods_first_category_id` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `goods_first_category_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '第一类别名称',
  PRIMARY KEY (`goods_first_category_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品第一类别表';

-- 正在导出表  paper-cutting.goods_first_category 的数据：~0 rows (大约)

-- 导出  表 paper-cutting.goods_info 结构
CREATE TABLE IF NOT EXISTS `goods_info` (
  `goods_id` int unsigned NOT NULL AUTO_INCREMENT,
  `goods_second_category_id` tinyint NOT NULL COMMENT '商品第二类别表id',
  `shop_id` int NOT NULL DEFAULT '0' COMMENT '店铺id',
  `goods_name` varchar(50) NOT NULL COMMENT '商品名称',
  `goods_introduction` varchar(255) NOT NULL COMMENT '商品描述',
  `pic_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品标题图片',
  `price` decimal(10,2) NOT NULL COMMENT '商品原价',
  `promotion_price` decimal(10,2) NOT NULL COMMENT '促销价格',
  `sold_number` int NOT NULL DEFAULT '0' COMMENT '已售数量',
  `total_number` int NOT NULL DEFAULT '0' COMMENT '库存总量',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除(默认0)',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品信息表';

-- 正在导出表  paper-cutting.goods_info 的数据：~0 rows (大约)

-- 导出  表 paper-cutting.goods_second_category 结构
CREATE TABLE IF NOT EXISTS `goods_second_category` (
  `goods_second_category_id` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `good_first_category_id` tinyint NOT NULL COMMENT '商品第一类别id',
  `good_first_category_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '第二类别名称',
  PRIMARY KEY (`goods_second_category_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品第二类别表';

-- 正在导出表  paper-cutting.goods_second_category 的数据：~0 rows (大约)

-- 导出  表 paper-cutting.goods_views 结构
CREATE TABLE IF NOT EXISTS `goods_views` (
  `goods_views_id` int unsigned NOT NULL AUTO_INCREMENT,
  `goods_id` int NOT NULL COMMENT '商品id',
  `buyer_id` bigint NOT NULL COMMENT '用户id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '浏览时间',
  PRIMARY KEY (`goods_views_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='近期浏览商品';

-- 正在导出表  paper-cutting.goods_views 的数据：~0 rows (大约)

-- 导出  表 paper-cutting.order_info 结构
CREATE TABLE IF NOT EXISTS `order_info` (
  `order_id` bigint NOT NULL,
  `goods_id` int NOT NULL COMMENT '商品id',
  `buyer_id` bigint NOT NULL COMMENT '用户id',
  `receiving_address_id` tinyint NOT NULL COMMENT '收货地址id',
  `order_status` tinyint NOT NULL COMMENT '订单状态(0待付款,1待发货,2待收货,3待评价,4售后)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除(默认0)',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单信息表';

-- 正在导出表  paper-cutting.order_info 的数据：~0 rows (大约)

-- 导出  表 paper-cutting.receiving_address 结构
CREATE TABLE IF NOT EXISTS `receiving_address` (
  `receiving_address_id` int unsigned NOT NULL AUTO_INCREMENT,
  `buyer_id` bigint NOT NULL COMMENT '用户id',
  `recipient_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收件人姓名',
  `recipient_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收件人电话',
  `recipient_region` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所在地区',
  `recipient_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '详细地址',
  `address_label` tinyint NOT NULL DEFAULT '0' COMMENT '地址标签(家,公司,学校,父母,朋友)',
  PRIMARY KEY (`receiving_address_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='收货地址表';

-- 正在导出表  paper-cutting.receiving_address 的数据：~0 rows (大约)

-- 导出  表 paper-cutting.shop_follow 结构
CREATE TABLE IF NOT EXISTS `shop_follow` (
  `shop_follow_id` int unsigned NOT NULL AUTO_INCREMENT,
  `shop_id` int NOT NULL COMMENT '店铺id',
  `buyer_id` bigint NOT NULL COMMENT '用户id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '关注时间',
  PRIMARY KEY (`shop_follow_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='店铺关注表';

-- 正在导出表  paper-cutting.shop_follow 的数据：~0 rows (大约)

-- 导出  表 paper-cutting.shop_info 结构
CREATE TABLE IF NOT EXISTS `shop_info` (
  `shop_id` int unsigned NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(50) NOT NULL COMMENT '店铺名称',
  `pic_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '店铺图片',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除(默认0)',
  PRIMARY KEY (`shop_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='店铺信息表';

-- 正在导出表  paper-cutting.shop_info 的数据：~0 rows (大约)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
