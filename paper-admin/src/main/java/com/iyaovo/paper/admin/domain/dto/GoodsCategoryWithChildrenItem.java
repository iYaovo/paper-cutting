/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: GoodsCategoryWithChildrenItem
 * Author: 22932
 * Date: 2024/4/22 16:23:45
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.admin.domain.dto;

import com.iyaovo.paper.admin.domain.entity.GoodsCategory;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: GoodsCategoryWithChildrenItem
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/22 16:23:45
 */
@Data
@AllArgsConstructor
public class GoodsCategoryWithChildrenItem {

   @Schema(defaultValue = "类别id")
   private Integer goodsCategoryId;

   @Schema(defaultValue = "类别名称")
   private String goodCategoryName;

   @Schema(defaultValue = "父类别id")
   private Integer categorySuperiorId;

   @Schema(defaultValue = "子级分类")
   private List<GoodsCategory> children;
}

