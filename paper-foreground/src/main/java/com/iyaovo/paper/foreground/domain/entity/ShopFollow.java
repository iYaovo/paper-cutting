/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: shopFollow
 * Author: 22932
 * Date: 2024/4/12 16:39:13
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

import java.time.LocalDateTime;

/**
 * @ClassName: shopFollow
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 16:39:13
 */
@Data
@AllArgsConstructor
@Schema(description = "店铺收藏")
@TableName(value = "shop_follow")
public class ShopFollow {
   /**
    * 店铺收藏id
    */
   @TableId(value = "shop_follow_id",type = IdType.AUTO)
   private Integer shopFollowId;

   /**
    * 店铺id
    */
   @TableField("shop_id")
   private Integer shopId;

   /**
    * 用户id
    */
   @TableField("buyer_id")
   private Long buyerId;

   /**
    * 关注时间
    */
   @TableField("create_time")
   private LocalDateTime createTime;
}

