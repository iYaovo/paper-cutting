/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: GoodsCategoryServiceImpl
 * Author: 22932
 * Date: 2024/4/24 19:29:23
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iyaovo.paper.foreground.domain.dto.GoodsCategoryWithChildrenItem;
import com.iyaovo.paper.foreground.domain.entity.CartInfo;
import com.iyaovo.paper.foreground.domain.entity.GoodsCategory;
import com.iyaovo.paper.foreground.mapper.CartInfoMapper;
import com.iyaovo.paper.foreground.mapper.GoodsCategoryMapper;
import com.iyaovo.paper.foreground.service.ICartInfoService;
import com.iyaovo.paper.foreground.service.IGoodsCategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: GoodsCategoryServiceImpl
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/24 19:29:23
 */
@Service
@RequiredArgsConstructor
public class GoodsCategoryServiceImpl extends ServiceImpl<GoodsCategoryMapper, GoodsCategory> implements IGoodsCategoryService{

    private final GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public List<GoodsCategoryWithChildrenItem> listWithChildren() {
        QueryWrapper<GoodsCategory> goodsCategoryQueryWrapper = new QueryWrapper<GoodsCategory>();
        goodsCategoryQueryWrapper.eq("category_superior_id",0);
        List<GoodsCategory> goodsCategories = goodsCategoryMapper.selectList(goodsCategoryQueryWrapper);
        List<GoodsCategoryWithChildrenItem> goodsCategoryWithChildrenItems = new ArrayList<>();
        goodsCategories.forEach(goodsCategory -> {
            QueryWrapper<GoodsCategory> goodsCategoryChildrenQueryWrapper = new QueryWrapper<GoodsCategory>();
            goodsCategoryChildrenQueryWrapper.eq("category_superior_id",goodsCategory.getGoodsCategoryId());
            GoodsCategoryWithChildrenItem goodsCategoryWithChildrenItem = new GoodsCategoryWithChildrenItem(goodsCategory.getGoodsCategoryId(),
                    goodsCategory.getGoodCategoryName(),goodsCategory.getCategorySuperiorId(),goodsCategoryMapper.selectList(goodsCategoryChildrenQueryWrapper));
            goodsCategoryWithChildrenItems.add(goodsCategoryWithChildrenItem);
        });
        return goodsCategoryWithChildrenItems;
    }
}

