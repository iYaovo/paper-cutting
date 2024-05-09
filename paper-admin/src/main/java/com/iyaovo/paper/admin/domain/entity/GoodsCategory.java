/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: GoodsFirstCategory
 * Author: 22932
 * Date: 2024/4/12 17:39:58
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.admin.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: GoodsFirstCategory
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 17:39:58
 */
@Schema(description = "商品类别")
@Slf4j
@Data
@AllArgsConstructor
@TableName("goods_category")
public class GoodsCategory {
   /**
    * 商品类别id
    */
   @TableId(value = "goods_category_id",type = IdType.AUTO)
   private Integer goodsCategoryId;

   /**
    * 商品类别名称
    */
   @TableField("goods_category_name")
   private String goodCategoryName;

   /**
    * 商品类别名称
    */
   @TableField("pic_url")
   private String picUrl;

   /**
    * 商品上级类别id
    */
   @TableField("category_superior_id")
   private Integer categorySuperiorId;

   /**
    * 该类别下商品的数量
    */
   @TableField(exist = false)
   private Long goodsNumber;

   public GoodsCategory(Integer goodsCategoryId, String goodCategoryName, String picUrl, Integer categorySuperiorId) {
      this.goodsCategoryId = goodsCategoryId;
      this.goodCategoryName = goodCategoryName;
      this.picUrl = picUrl;
      this.categorySuperiorId = categorySuperiorId;
   }
}

