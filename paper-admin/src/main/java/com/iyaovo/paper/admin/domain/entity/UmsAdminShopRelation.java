/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: UmsAdminShopRelation
 * Author: 22932
 * Date: 2024/4/25 17:15:48
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
 * @ClassName: UmsAdminShopRelation
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/25 17:15:48
 */
@Schema(description = "用户店铺关联表")
@Slf4j
@Data
@AllArgsConstructor
@TableName("ums_admin_shop_relation")
public class UmsAdminShopRelation {

   /**
    * id
    */
   @TableId(type = IdType.AUTO)
   private Integer id;

   /**
    * 用户id
    */
   @TableField("admin_id")
   private Long adminId;

   /**
    * 店铺id
    */
   @TableField("shop_id")
   private Integer shopId;
}

