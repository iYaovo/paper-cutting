/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: receivingAddress
 * Author: 22932
 * Date: 2024/4/12 16:50:20
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

/**
 * @ClassName: receivingAddress
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 16:50:20
 */
@AllArgsConstructor
@Data
@Schema(description = "收货地址")
@TableName(value = "receiving_address")
public class ReceivingAddress {

    /**
     * 收货地址id
     */
    @TableId(value = "receiving_address_id",type = IdType.AUTO)
    private Integer receivingAddressId;

    /**
     * 用户id
     */
    @TableField("buyer_id")
    private Long buyerId;

    /**
     * 收件人姓名
     */
    @TableField("recipient_name")
    private String recipientName;

    /**
     * 收件人电话
     */
    @TableField("recipient_phone")
    private String recipientPhone;

    /**
     * 收件人所在地区
     */
    @TableField("recipient_region")
    private String recipientRegion;

    /**
     * 详细地址
     */
    @TableField("recipient_address")
    private String recipientAddress;


}


