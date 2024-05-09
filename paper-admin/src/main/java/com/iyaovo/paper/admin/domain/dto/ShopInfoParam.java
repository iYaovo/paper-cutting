package com.iyaovo.paper.admin.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 品牌请求参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode
public class ShopInfoParam {
    @NotEmpty
    @Schema(defaultValue = "店铺名称",required = true)
    private String shopName;

    @NotEmpty
    @Schema(defaultValue = "品牌logo",required = true)
    private String picUrl;

}
