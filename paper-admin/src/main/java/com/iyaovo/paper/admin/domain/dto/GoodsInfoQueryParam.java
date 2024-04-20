package com.iyaovo.paper.admin.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品查询参数
 * Created by macro on 2018/4/27.
 */
@Data
@EqualsAndHashCode
public class GoodsInfoQueryParam {

    @Schema(defaultValue="商品名称模糊关键字")
    private String keyword;

    @Schema(defaultValue="商品分类编号")
    private Long goodsSecondCategoryId;

    @Schema(defaultValue="商品品牌编号")
    private Long shopId;
}
