package com.iyaovo.paper.foreground.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.foreground.domain.dto.CartInfoDto;
import com.iyaovo.paper.foreground.domain.dto.IdsParam;
import com.iyaovo.paper.foreground.domain.dto.SettleCartGoodsParam;
import com.iyaovo.paper.foreground.domain.entity.CartInfo;
import com.iyaovo.paper.foreground.domain.entity.GoodsInfo;
import com.iyaovo.paper.foreground.domain.vo.GoodsInfoVo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ICartInfoService extends IService<CartInfo> {

    /**
     * 添加商品到购物车
     */
    void createGoodsToCart(CartInfoDto cartInfoDto);

    /**
     * 删除购物车中的商品
     */
    void deleteGoodsFromCart(IdsParam idsParam);

    /**
     * 更改商品数量
     */
    void updateGoodsNumber(Integer cartId,Integer goodsNumber);

    /**
     * 结算
     */
    void settleCartGoods(SettleCartGoodsParam settleCartGoodsParam);



}
