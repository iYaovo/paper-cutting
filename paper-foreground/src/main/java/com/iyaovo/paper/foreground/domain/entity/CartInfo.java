/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: CartInfo
 * Author: 22932
 * Date: 2024/4/12 17:50:09
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
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: CartInfo
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 17:50:09
 */
@Schema(description = "购物车")
@Slf4j
@Data
@AllArgsConstructor
@TableName("cart_info")
public class CartInfo {

   /**
    * 购物车id
    */
   @TableId(value = "cart_id",type = IdType.AUTO)
   private Integer cartId;

   /**
    * 用户id
    */
   @TableField("buyer_id")
   private Long buyerId;

   /**
    * 商品id
    */
   @TableField("goods_id")
   private Integer goodsId;

   /**
    * 商品数量(默认1)
    */
   @TableField("goods_number")
   private Integer goodsNumber;
}

