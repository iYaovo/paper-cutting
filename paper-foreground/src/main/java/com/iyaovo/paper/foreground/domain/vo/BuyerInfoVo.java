/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: BuyerInfoVo
 * Author: 22932
 * Date: 2024/4/22 18:00:32
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: BuyerInfoVo
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/22 18:00:32
 */
@Schema(description = "买家vo")
@Slf4j
@Data
@AllArgsConstructor
public class BuyerInfoVo {
   /**
    * 买家id
    */
   @Schema(defaultValue = "买家id")
   private String buyerId;

   /**
    * 买家名称
    */
   @Schema(defaultValue ="买家名称")
   private String buyerName;

   /**
    * 买家爱好
    */
   @TableField("buyer_hobby")
   private String buyerHobby;

   /**
    * 买家个签
    */
   @TableField("buyer_autograph")
   private String buyerAutograph;

   /**
    * 头像
    */
   @TableField("pic_url")
   private String picUrl;
}

