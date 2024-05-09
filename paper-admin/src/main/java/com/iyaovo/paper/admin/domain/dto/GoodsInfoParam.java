/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: GoodsInfoParam
 * Author: 22932
 * Date: 2024/4/22 11:24:45
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.admin.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName: GoodsInfoParam
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/22 11:24:45
 */
@Data
public class GoodsInfoParam {
   @NotEmpty
   @Schema(defaultValue = "商品名称",required = true)
   private String name;

   @NotEmpty
   @Schema(defaultValue = "商品logo",required = true)
   private String logo;

   @NotEmpty
   @Schema(defaultValue = "商品介绍",required = true)
   private String introduction;

   @NotEmpty
   @Schema(defaultValue = "商品分类id")
   private Integer goodsCategoryId;

   @NotEmpty
   @Schema(defaultValue = "商品店铺id")
   private Integer shopId;

   @NotEmpty
   @Schema(defaultValue = "商品原价")
   private BigDecimal price;

   @NotEmpty
   @Schema(defaultValue = "促销价")
   private BigDecimal promotionPrice;

   @NotEmpty
   @Schema(defaultValue = "库存")
   private Integer totalNumber;
}

