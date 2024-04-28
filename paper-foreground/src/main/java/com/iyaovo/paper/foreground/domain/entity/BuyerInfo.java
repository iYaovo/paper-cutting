/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: BuyerInfo
 * Author: 22932
 * Date: 2024/4/12 17:54:52
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
import com.iyaovo.paper.common.domain.BaseEntity;
import com.iyaovo.paper.common.domain.SexEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: BuyerInfo
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 17:54:52
 */
@Schema(description = "买家")
@Slf4j
@Data
@AllArgsConstructor
@TableName("buyer_info")
public class BuyerInfo extends BaseEntity {

   /**
    * 买家id
    */
   @TableId(value = "buyer_id",type = IdType.ASSIGN_ID)
   private Long buyerId;

   /**
    * 买家名称
    */
   @TableField("buyer_name")
   private String buyerName;

   /**
    * 买家密码
    */
   @TableField("buyer_password")
   private String buyerPassword;


   /**
    * 买家爱好
    */
   @TableField("buyer_hobby")
   private String buyerHobby;

   /**
    * 买家个签
    */
   @TableField("buyer_autograph")
   private String buyerAutograph;

   /**
    * 头像
    */
   @TableField("pic_url")
   private String picUrl;
}

