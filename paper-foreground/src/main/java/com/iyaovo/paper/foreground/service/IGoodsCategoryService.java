package com.iyaovo.paper.foreground.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iyaovo.paper.foreground.domain.dto.GoodsCategoryWithChildrenItem;
import com.iyaovo.paper.foreground.domain.entity.GoodsCategory;

import java.util.List;

public interface IGoodsCategoryService extends IService<GoodsCategory> {
    List<GoodsCategoryWithChildrenItem> listWithChildren();
}
