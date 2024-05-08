/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: BuyerInfoSimpleVo
 * Author: 22932
 * Date: 2024/4/22 18:01:51
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.annotation.XmlType;

/**
 * @ClassName: BuyerInfoSimpleVo
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/22 18:01:51
 */
@Schema(description = "买家简易vo")
@Slf4j
@Data
@AllArgsConstructor
public class BuyerInfoSimpleVo {
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
    * 头像
    */
   @Schema(defaultValue = "头像base64")
   private String picUrl;

   /**
    * 收藏数量
    */
   @Schema(defaultValue = "收藏数量")
   private Long collectionNumber;

   /**
    * 店铺关注数量
    */
   @Schema(defaultValue = "店铺关注数量")
   private Long shopFollowNumber;

   /**
    * 近期浏览量
    */
   @Schema(defaultValue = "近期浏览量")
   private Long goodsViewNumber;
}

