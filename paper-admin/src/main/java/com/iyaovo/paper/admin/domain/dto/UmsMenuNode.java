package com.iyaovo.paper.admin.domain.dto;

import com.iyaovo.paper.admin.domain.entity.UmsMenu;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 后台菜单节点封装
 * Created by macro on 2020/2/4.
 */
@Getter
@Setter
public class UmsMenuNode extends UmsMenu {
    @Schema(defaultValue="子级菜单")
    private List<UmsMenuNode> children;
}
