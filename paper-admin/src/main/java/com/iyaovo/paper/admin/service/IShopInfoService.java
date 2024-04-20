package com.iyaovo.paper.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iyaovo.paper.admin.domain.dto.ShopInfoParam;
import com.iyaovo.paper.admin.domain.entity.GoodsInfo;
import com.iyaovo.paper.admin.domain.entity.ShopInfo;
import com.iyaovo.paper.common.api.CommonPage;

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

    /**
     * 获取所以店铺
     */
    List<ShopInfo> listAllShop();

    /**
     * 创建
     * @param shopInfoParam
     * @return
     */
     int createShop(ShopInfoParam shopInfoParam);

    /**
     * 更新
     * @param id
     * @param shopInfoParam
     * @return
     */
    int updateShop(Long id, ShopInfoParam shopInfoParam);

    /**
     * 删除店铺
     * @param id
     * @return
     */
    int deleteShop(Long id);

    /**
     * 批量删除店铺
     * @param ids
     * @return
     */
    int deleteShop(List<Long> ids);

    /**
     * 通过关键词搜索店铺
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ShopInfo> listShop(String keyword, Integer pageNum, Integer pageSize);
}
