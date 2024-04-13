package com.iyaovo.paper.foreground.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.foreground.domain.entity.GoodsInfo;
import com.iyaovo.paper.foreground.domain.entity.ShopInfo;

import java.util.List;

public interface IShopInfoService extends IService<ShopInfo> {

    /**
     * 展示该店铺商品
     */
    CommonPage<GoodsInfo> showGoodsByShopId(Integer shopId,
                                            Integer pageNum,
                                            Integer pageSize);

    /**
     * 通过商品id获取店铺
     */
    ShopInfo showShopInfoByGoodsId(Integer goodsId);
}
