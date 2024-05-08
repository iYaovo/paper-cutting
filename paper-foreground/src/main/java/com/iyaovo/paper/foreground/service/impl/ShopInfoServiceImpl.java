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

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.common.constant.Constants;
import com.iyaovo.paper.common.util.ImageToBase64Util;
import com.iyaovo.paper.foreground.domain.entity.GoodsInfo;
import com.iyaovo.paper.foreground.domain.entity.ShopInfo;
import com.iyaovo.paper.foreground.domain.vo.GoodsInfoVo;
import com.iyaovo.paper.foreground.domain.vo.ShopInfoVo;
import com.iyaovo.paper.foreground.mapper.GoodsInfoMapper;
import com.iyaovo.paper.foreground.mapper.ShopInfoMapper;
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
         //把店铺id封装到vo
         goodsInfoVo.setShopId(goodsInfo.getShopId());
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
      return new ShopInfoVo(shopInfo.getShopId(),shopInfo.getShopName(),ImageToBase64Util.convertFileToBase64(Constants.RESOURCE_PATH+shopInfo.getPicUrl()));
   }

}

