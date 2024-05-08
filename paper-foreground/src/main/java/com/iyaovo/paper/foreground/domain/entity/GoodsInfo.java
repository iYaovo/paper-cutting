/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: GoodsInfo
 * Author: 22932
 * Date: 2024/4/12 17:31:11
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iyaovo.paper.common.domain.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @ClassName: GoodsInfo
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 17:31:11
 */
@Schema(description = "商品类")
@Slf4j
@Data
@AllArgsConstructor
@TableName("goods_info")
public class GoodsInfo extends BaseEntity {

   /**
    *商品id
    */
   @TableId(value = "goods_id",type = IdType.AUTO)
   private Integer goodsId;

   /**
    * 商品类id
    */
   @TableField("goods_category_id")
   private Integer goodsCategoryId;

   /**
    * 店铺id
    */
   @TableField("shop_id")
   private Integer shopId;

   /**
    * 商品名称
    */
   @TableField("goods_name")
   private String goodsName;

   /**
    * 商品描述
    */
   @TableField("goods_introduction")
   private String goodsIntroduction;

   /**
    * 标题图片
    */
   @TableField("pic_url")
   private String picUrl;

   /**
    * 原价
    */
   @TableField("price")
   private BigDecimal price;

   /**
    * 现价
    */
   @TableField("promotion_price")
   private BigDecimal promotionPrice;

   /**
    * 已售数量
    */
   @TableField("sold_number")
   private Integer soldNumber;

   /**
    * 库存总量
    */
   @TableField("total_number")
   private Integer totalNumber;

}


