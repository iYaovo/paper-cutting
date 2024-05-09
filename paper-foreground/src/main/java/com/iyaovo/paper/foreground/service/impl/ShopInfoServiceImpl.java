/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: ShopInfoServiceImpl
 * Author: 22932
 * Date: 2024/4/13 19:11:52
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.common.constant.Constants;
import com.iyaovo.paper.common.util.ImageToBase64Util;
import com.iyaovo.paper.foreground.domain.entity.*;
import com.iyaovo.paper.foreground.domain.vo.GoodsInfoVo;
import com.iyaovo.paper.foreground.domain.vo.ShopInfoVo;
import com.iyaovo.paper.foreground.mapper.*;
import com.iyaovo.paper.foreground.service.IBuyerInfoService;
import com.iyaovo.paper.foreground.service.IGoodsInfoService;
import com.iyaovo.paper.foreground.service.IShopInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ShopInfoServiceImpl
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/13 19:11:52
 */
@Service
@RequiredArgsConstructor
public class ShopInfoServiceImpl extends ServiceImpl<ShopInfoMapper, ShopInfo> implements IShopInfoService {

   private final IGoodsInfoService iGoodsInfoService;

   private final ShopInfoMapper shopInfoMapper;

   private final GoodsInfoMapper goodsInfoMapper;

   private final GoodsCollectionMapper goodsCollectionMapper;

   private final IBuyerInfoService iBuyerInfoService;

   private final ShopFollowMapper shopFollowMapper;

   private final CartInfoMapper cartInfoMapper;

   @Override
   public CommonPage<GoodsInfoVo> showGoodsByShopId(Integer shopId, Integer pageNum, Integer pageSize) {
      QueryWrapper<GoodsInfo> goodsInfoQueryWrapper = new QueryWrapper<GoodsInfo>();
      goodsInfoQueryWrapper.eq("shop_id",shopId);
      Page<GoodsInfo> goodsInfoPage = goodsInfoMapper.selectPage(new Page<>(pageNum,pageSize), goodsInfoQueryWrapper);
      List<GoodsInfo> goodsInfoList = goodsInfoPage.getRecords();
      List<GoodsInfoVo> goodsInfoVoList = new ArrayList<GoodsInfoVo>();
      goodsInfoList.forEach(goodsInfo ->{
         //entity转为vo
         GoodsInfoVo goodsInfoVo = new GoodsInfoVo(goodsInfo.getGoodsId(),goodsInfo.getGoodsName(),goodsInfo.getGoodsIntroduction(),
                 ImageToBase64Util.convertFileToBase64(Constants.RESOURCE_PATH+goodsInfo.getPicUrl()), goodsInfo.getPrice(),
                 goodsInfo.getPromotionPrice(),goodsInfo.getSoldNumber(),goodsInfo.getTotalNumber());
         QueryWrapper<GoodsCollection> goodsCollectionQueryWrapper = new QueryWrapper<>();
         goodsCollectionQueryWrapper.eq("goods_id",goodsInfo.getGoodsId())
                 .eq("buyer_id",iBuyerInfoService.getBuyerInfo().getBuyerId());
         GoodsCollection goodsCollection = goodsCollectionMapper.selectOne(goodsCollectionQueryWrapper);
         if(ObjectUtil.isEmpty(goodsCollection)){
            goodsInfoVo.setIsCollection(false);
         }else{
            goodsInfoVo.setIsCollection(true);
         }
         //判断商品是否被加入购物车
         QueryWrapper<CartInfo> cartInfoQueryWrapper = new QueryWrapper<>();
         cartInfoQueryWrapper.eq("goods_id",goodsInfo.getGoodsId())
                 .eq("buyer_id",iBuyerInfoService.getBuyerInfo().getBuyerId());
         CartInfo cartInfo = cartInfoMapper.selectOne(cartInfoQueryWrapper);
         if(ObjectUtil.isEmpty(cartInfo)){
            goodsInfoVo.setIsJoinCart(false);
         }else{
            goodsInfoVo.setIsJoinCart(true);
         }
         //把店铺信息封装到vo
         goodsInfoVo.setShopInfo(shopInfoMapper.selectById(goodsInfo.getShopId()));

         goodsInfoVoList.add(goodsInfoVo);
      });
      Page<GoodsInfoVo> goodsInfoVoPage = new Page<>(pageNum,pageSize,goodsInfoPage.getTotal());
      goodsInfoVoPage.setPages(goodsInfoPage.getPages());
      goodsInfoVoPage.setRecords(goodsInfoVoList);
      return CommonPage.restPage(goodsInfoVoPage);
   }


   @Override
   public ShopInfoVo showShopsByShopId(Integer shopId) {
      ShopInfo shopInfo = shopInfoMapper.selectById(shopId);
      ShopInfoVo shopInfoVo = new ShopInfoVo(shopInfo.getShopId(), shopInfo.getShopName(), ImageToBase64Util.convertFileToBase64(Constants.RESOURCE_PATH + shopInfo.getPicUrl()));
      QueryWrapper<ShopFollow> shopFollowQueryWrapper = new QueryWrapper<>();
      shopFollowQueryWrapper.eq("shop_id",shopId)
              .eq("buyer_id",iBuyerInfoService.getBuyerInfo().getBuyerId());
      ShopFollow shopFollow = shopFollowMapper.selectOne(shopFollowQueryWrapper);
      if(ObjectUtil.isEmpty(shopFollow)){
         shopInfoVo.setIsFavorite(false);
      }else{
         shopInfoVo.setIsFavorite(true);
      }
      return shopInfoVo;
   }

}

