/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: SettleCartGoodsParam
 * Author: 22932
 * Date: 2024/4/26 12:07:15
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: SettleCartGoodsParam
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/26 12:07:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(defaultValue = "结算购物车param")
public class SettleCartGoodsParam{
   @Schema(defaultValue = "收货地址id")
   private Integer receivingAddressId;

   @Schema(defaultValue = "购物车ids")
   private int[] cartIds;
}

