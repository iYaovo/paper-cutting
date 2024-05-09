/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: ShopInfoVo
 * Author: 22932
 * Date: 2024/5/9 14:13:57
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
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: ShopInfoVo
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/5/9 14:13:57
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "店铺vo")
public class ShopInfoVo {
   /**
    * 店铺id
    */
   private Integer shopId;

   /**
    * 店铺名称
    */
   private String shopName;

   /**
    * 标题图片
    */
   @Schema(description = "urlBase64")
   private String picUrl;
}

