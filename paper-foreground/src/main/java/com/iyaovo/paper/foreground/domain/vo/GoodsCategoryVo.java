/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: GoodsCategoryVo
 * Author: 22932
 * Date: 2024/5/8 17:10:44
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
 * @ClassName: GoodsCategoryVo
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/5/8 17:10:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(defaultValue = "商品类型Vo")
public class GoodsCategoryVo {
   /**
    * 商品类别id
    */
   @Schema(defaultValue = "商品id")
   private Integer goodsCategoryId;

   /**
    * 商品类别名称
    */
   @Schema(defaultValue = "商品类别名称")
   private String goodCategoryName;

   /**
    * 商品上级类别id
    */
   @Schema(defaultValue = "商品上级类别id")
   private Integer categorySuperiorId;

   /**
    * 商品类别url
    */
   @Schema(defaultValue = "商品类别url")
   private String picUrl;

}

