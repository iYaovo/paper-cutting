package com.iyaovo.paper.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.iyaovo.paper.admin.domain.dto.ShopInfoParam;
import com.iyaovo.paper.admin.domain.entity.ShopInfo;
import com.iyaovo.paper.admin.domain.vo.ShopInfoVo;

import java.util.List;

public interface IShopInfoService extends IService<ShopInfo> {

//    /**
//     * 展示该店铺商品
//     */
//    List<GoodsInfo> showGoodsByShopId(Integer shopId,
//                                            Integer pageNum,
//                                            Integer pageSize);
//
//    /**
//     * 通过商品id获取店铺
//     */
//    ShopInfo showShopInfoByGoodsId(Integer goodsId);

    /**
     * 获取所以店铺
     */
    List<ShopInfoVo> listAllShop();

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
    int updateShop(Integer id, ShopInfoParam shopInfoParam);

    /**
     * 删除店铺
     * @param id
     * @return
     */
    int deleteShop(Integer id);

    /**
     * 批量删除店铺
     * @param ids
     * @return
     */
    int deleteShop(List<Integer> ids);

    /**
     * 通过关键词搜索店铺
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<ShopInfoVo> listShop(String keyword, Integer pageNum, Integer pageSize);

    ShopInfoVo getOneShop(Integer shopId);
}
