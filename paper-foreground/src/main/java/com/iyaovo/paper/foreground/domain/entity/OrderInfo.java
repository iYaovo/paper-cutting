/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: OrderInfo
 * Author: 22932
 * Date: 2024/4/12 17:16:21
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
import com.iyaovo.paper.common.domain.BaseEntity;
import com.iyaovo.paper.common.domain.OrderStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: OrderInfo
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 17:16:21
 */
@Schema(description = "订单类")
@Slf4j
@Data
@AllArgsConstructor
@TableName("order_info")
public class OrderInfo extends BaseEntity {

   /**
    * 订单id
    */
   @TableId(value = "order_id",type = IdType.ASSIGN_ID)
   private Long orderId;

   /**
    * 商品id
    */
   @TableField("goods_id")
   private Integer goodsId;

   /**
    * 用户id
    */
   @TableField("buyer_id")
   private Long buyerId;

   /**
    * 订单状态
    */
   @TableField("order_status")
   private OrderStatusEnum orderStatus;

   /**
    * 收货地址id
    */
   @TableField("receiving_address_id")
   private Integer receivingAddressId;
}

