/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: shopInfo
 * Author: 22932
 * Date: 2024/4/11 21:05:40
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
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName: shopInfo
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/11 21:05:40
 */
@TableName(value = "shop_info")
@Schema(description = "店铺")
@Data
@AllArgsConstructor
public class ShopInfo extends BaseEntity {
    /**
     * 店铺id
     */
    @TableId(value = "shop_id",type = IdType.AUTO)
    private Integer shopId;

    /**
     * 店铺名称
     */
    @TableField("shop_name")
    private String shopName;

    /**
     * 标题图片
     */
    @TableField("pic_url")
    private String picUrl;
}

