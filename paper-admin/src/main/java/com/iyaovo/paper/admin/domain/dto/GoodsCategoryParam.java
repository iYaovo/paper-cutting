package com.iyaovo.paper.admin.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 添加更新商品分类的参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode
public class GoodsCategoryParam {
    @Schema(defaultValue = "父分类的编号")
    private Integer parentId;
    @NotEmpty
    @Schema(defaultValue = "商品分类名称")
    private String name;

    @Schema(defaultValue = "类别url")
    private String picUrl;
}
