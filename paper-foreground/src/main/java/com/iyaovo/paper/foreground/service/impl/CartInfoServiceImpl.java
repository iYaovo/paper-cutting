/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: CartInfoServiceImpl
 * Author: 22932
 * Date: 2024/4/12 23:48:50
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
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.common.domain.OrderStatusEnum;
import com.iyaovo.paper.foreground.domain.dto.CartInfoDto;
import com.iyaovo.paper.foreground.domain.dto.IdsParam;
import com.iyaovo.paper.foreground.domain.dto.SettleCartGoodsParam;
import com.iyaovo.paper.foreground.domain.entity.*;
import com.iyaovo.paper.foreground.domain.vo.GoodsInfoVo;
import com.iyaovo.paper.foreground.mapper.*;
import com.iyaovo.paper.foreground.service.IBuyerInfoService;
import com.iyaovo.paper.foreground.service.ICartInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CartInfoServiceImpl
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 23:48:50
 */
@Service
@RequiredArgsConstructor
public class CartInfoServiceImpl extends ServiceImpl<CartInfoMapper,CartInfo> implements ICartInfoService {

   private final IBuyerInfoService iBuyerInfoService;

   private final CartInfoMapper cartInfoMapper;

   private final BuyerInfoMapper buyerInfoMapper;

   private final GoodsInfoMapper goodsInfoMapper;

   private final OrderInfoMapper orderInfoMapper;

   @Override
   public void createGoodsToCart(CartInfoDto cartInfoDto) {
      cartInfoMapper.insert(new CartInfo(null,iBuyerInfoService.getBuyerInfo().getBuyerId(),cartInfoDto.getGoodsId(),cartInfoDto.getGoodsNumber()));
   }

   @Override
   public void deleteGoodsFromCart(IdsParam idsParam) {
      for (long cartId : idsParam.getIds()) {
         cartInfoMapper.deleteById(cartId);
      }
   }

   @Override
   public void updateGoodsNumber(Integer cartId,Integer goodsNumber) {
      cartInfoMapper.updateById(new CartInfo(cartId,null,null,goodsNumber));
   }

   @Override
   public void settleCartGoods(SettleCartGoodsParam settleCartGoodsParam) {
      Integer receivingAddressId = settleCartGoodsParam.getReceivingAddressId();
      for (int cartId : settleCartGoodsParam.getCartIds()) {
         CartInfo cartInfo = cartInfoMapper.selectById(cartId);
         orderInfoMapper.insert(new OrderInfo(null, cartInfo.getGoodsId(), iBuyerInfoService.getBuyerInfo().getBuyerId(), OrderStatusEnum.PENDING_EVALUATE, receivingAddressId));
         cartInfoMapper.deleteById(cartId);
      }
   }




}

