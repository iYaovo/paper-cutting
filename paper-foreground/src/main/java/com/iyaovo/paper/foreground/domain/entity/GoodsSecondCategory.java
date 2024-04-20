/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: GoodsSecondCategory
 * Author: 22932
 * Date: 2024/4/12 17:42:02
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
 * @ClassName: GoodsSecondCategory
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 17:42:02
 */
@Schema(description = "商品第二类别")
@Slf4j
@Data
@AllArgsConstructor
@TableName("goods_second_category")
public class GoodsSecondCategory {

   /**
    * 商品第二类别id
    */
   @TableId(value = "goods_second_category_id",type = IdType.AUTO)
   private Integer goodsSecondCategoryId;

   /**
    * 商品第一类别id
    */
   @TableField(value = "goods_first_category_id")
   private Integer goodsFirstCategoryId;

   /**
    * 商品第二类别名称
    */
   @TableField("goods_second_category_name")
   private String goodsSecondCategoryName;
}

