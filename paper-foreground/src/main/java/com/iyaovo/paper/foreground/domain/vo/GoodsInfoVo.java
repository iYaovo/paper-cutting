/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: GoodsInfoVo
 * Author: 22932
 * Date: 2024/4/15 21:44:24
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.domain.vo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.iyaovo.paper.foreground.domain.entity.ShopInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @ClassName: GoodsInfoVo
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/15 21:44:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(defaultValue = "商品类Vo")
public class GoodsInfoVo {

    @Schema(defaultValue = "商品id")
    private Integer goodsId;

    @Schema(defaultValue = "商品名称")
    private String goodsName;

    @Schema(defaultValue = "商品介绍")
    private String goodsIntroduction;

    @Schema(defaultValue = "标题图片base64形式")
    private String picUrl;

    @Schema(defaultValue = "原价")
    private BigDecimal price;

    @Schema(defaultValue = "促销价格")
    private BigDecimal promotionPrice;

    @Schema(defaultValue = "已售数量")
    private Integer soldNumber;

    @Schema(defaultValue = "库存量")
    private Integer totalNumber;

    @Schema(defaultValue = "店铺")
    private ShopInfo shopInfo;

    @Schema(defaultValue = "是否被收藏")
    private Boolean isCollection;

    @Schema(defaultValue = "是否加入购物车")
    private Boolean isJoinCart;


    public GoodsInfoVo(Integer goodsId, String goodsName, String goodsIntroduction, String picUrl, BigDecimal price, BigDecimal promotionPrice, Integer soldNumber, Integer totalNumber) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsIntroduction = goodsIntroduction;
        this.picUrl = picUrl;
        this.price = price;
        this.promotionPrice = promotionPrice;
        this.soldNumber = soldNumber;
        this.totalNumber = totalNumber;
    }


}

