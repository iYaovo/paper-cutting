/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: GoodsCollection
 * Author: 22932
 * Date: 2024/4/12 17:43:12
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

import java.time.LocalDateTime;

/**
 * @ClassName: GoodsCollection
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 17:43:12
 */
@Schema(description = "商品收藏")
@Slf4j
@Data
@AllArgsConstructor
@TableName("goods_collection")
public class GoodsCollection {

   /**
    * 商品收藏id
    */
   @TableId(value = "goods_collection_id",type = IdType.AUTO)
   private Integer goodsCollectionId;

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
    * 收藏时间
    */
   @TableField("create_time")
   private LocalDateTime createTime;
}

