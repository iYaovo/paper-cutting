/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: GoodsCategoryVo
 * Author: 22932
 * Date: 2024/5/9 13:46:10
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.admin.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName: GoodsCategoryVo
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/5/9 13:46:10
 */
@Data
@AllArgsConstructor
@Schema(defaultValue = "商品类别Vo")
public class GoodsCategoryVo {
   /**
    * 商品类别id
    */
   private Integer goodsCategoryId;

   /**
    * 商品类别名称
    */
   private String goodCategoryName;

   /**
    * 商品类别名称
    */
   @Schema(defaultValue = "urlBase64")
   private String picUrl;

   /**
    * 商品上级类别id
    */
   private Integer categorySuperiorId;

   /**
    * 该类别下商品的数量
    */
   private Long goodsNumber;
}

