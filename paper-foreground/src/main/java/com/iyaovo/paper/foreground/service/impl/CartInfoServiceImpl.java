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

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.foreground.domain.dto.CartInfoDto;
import com.iyaovo.paper.foreground.domain.entity.CartInfo;
import com.iyaovo.paper.foreground.domain.entity.GoodsInfo;
import com.iyaovo.paper.foreground.mapper.CartInfoMapper;
import com.iyaovo.paper.foreground.service.ICartInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: CartInfoServiceImpl
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 23:48:50
 */
@Service
public class CartInfoServiceImpl extends ServiceImpl<CartInfoMapper,CartInfo> implements ICartInfoService {
   @Override
   public void addGoodsToCart(CartInfoDto cartInfoDto) {

   }

   @Override
   public void deleteGoodsFromCart(Integer goodsId) {

   }

   @Override
   public void changeGoodsNumber(Integer goodsId,Integer goodsNumber) {

   }

   @Override
   public void settleAccounts(List<CartInfoDto> cartInfoDtoList) {

   }


}

