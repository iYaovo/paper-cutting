/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: ReceivingAddressDto
 * Author: 22932
 * Date: 2024/4/13 20:37:44
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.iyaovo.paper.common.domain.AddressLabelEnum;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @ClassName: ReceivingAddressDto
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/13 20:37:44
 */

@Schema(defaultValue = "收货地址DTO")
public class ReceivingAddressDto {

   @Schema(defaultValue = "收货地址id")
   private Integer receivingAddressId;

   @Schema(defaultValue = "收件人姓名")
   private String recipientName;

   @Schema(defaultValue = "收件人电话")
   private String recipientPhone;

   @Schema(defaultValue = "收件人所在地区")
   private String recipientRegion;

   @Schema(defaultValue = "收件人详细地址")
   private String recipientAddress;

   @Schema(defaultValue = "地址标签")
   private AddressLabelEnum addressLabel;
}

