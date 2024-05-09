/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: ShopInfoVo
 * Author: 22932
 * Date: 2024/5/8 16:17:07
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
import lombok.NoArgsConstructor;

/**
 * @ClassName: ShopInfoVo
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/5/8 16:17:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(defaultValue = "店铺类Vo")
public class ShopInfoVo {
   /**
    * 店铺id
    */
   @Schema(defaultValue = "店铺id")
   private Integer shopId;

   /**
    * 店铺名称
    */
   @Schema(defaultValue = "店铺名称")
   private String shopName;

   /**
    * 标题图片
    */
   @Schema(defaultValue = "店铺图片base64形式")
   private String picUrl;

   /**
    * 店铺是否被关注
    */
   @Schema(defaultValue = "店铺是否被关注")
   private Boolean isFavorite;

   public ShopInfoVo(Integer shopId, String shopName, String picUrl) {
      this.shopId = shopId;
      this.shopName = shopName;
      this.picUrl = picUrl;
   }
}

