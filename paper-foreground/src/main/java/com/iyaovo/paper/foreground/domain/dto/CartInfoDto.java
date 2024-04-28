/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: CartInfoDto
 * Author: 22932
 * Date: 2024/4/12 23:47:03
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
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: CartInfoDto
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 23:47:03
 */
@Data
@Schema(defaultValue = "购物车DTO")
public class CartInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(defaultValue = "商品id")
    private Integer goodsId;

    @Schema(defaultValue = "商品数量")
    private Integer goodsNumber;


}

