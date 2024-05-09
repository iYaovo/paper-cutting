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
package com.iyaovo.paper.admin.domain.vo;

import com.iyaovo.paper.admin.domain.entity.ShopInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName: GoodsInfoVo
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/15 21:44:24
 */
@Data
@AllArgsConstructor
@Schema(defaultValue = "商品类Vo")
public class GoodsInfoVo {

    @Schema(defaultValue = "商品id")
    private Integer goodsId;

    @Schema(defaultValue = "商品名称")
    private String goodsName;

    @Schema(defaultValue = "商品介绍")
    private String goodsIntroduction;

    @Schema(defaultValue = "标题图片base64")
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

   @Schema(defaultValue = "分类id")
    private Integer goodsCategoryId;

    @Schema(defaultValue = "分类父id")
    private Integer SuperiorCategoryId;

    public GoodsInfoVo(Integer goodsId, String goodsName, String goodsIntroduction, String picUrl, BigDecimal price, BigDecimal promotionPrice, Integer soldNumber, Integer totalNumber, Integer goodsCategoryId) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsIntroduction = goodsIntroduction;
        this.picUrl = picUrl;
        this.price = price;
        this.promotionPrice = promotionPrice;
        this.soldNumber = soldNumber;
        this.totalNumber = totalNumber;
        this.goodsCategoryId = goodsCategoryId;
    }
}

