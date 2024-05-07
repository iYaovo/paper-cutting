/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: discussInfo
 * Author: 22932
 * Date: 2024/5/7 14:29:06
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
 * @ClassName: discussInfo
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/5/7 14:29:06
 */
@Schema(description = "广场讨论区")
@Slf4j
@Data
@AllArgsConstructor
@TableName("discuss_info")
public class DiscussInfo {

   @TableId(value = "discuss_id",type = IdType.AUTO)
   private Integer discussId;

   @TableField(value = "buyer_id")
   private Long buyerId;

   @TableField(value = "parent_id")
   private Integer parentId;

   @TableField(value = "discuss_content")
   private String discussContent;

   @TableField(value = "favorite_number")
   private Integer favoriteNumber;

   @TableField(value = "comment_number")
   private Integer commentNumber;

   public DiscussInfo(Integer discussId, Long buyerId, Integer parentId, String discussContent) {
      this.discussId = discussId;
      this.buyerId = buyerId;
      this.parentId = parentId;
      this.discussContent = discussContent;
   }
}

