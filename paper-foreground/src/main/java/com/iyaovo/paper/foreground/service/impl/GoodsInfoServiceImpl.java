/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: GoodsInfoServiceImpl
 * Author: 22932
 * Date: 2024/4/13 19:30:56
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

import com.github.pagehelper.PageHelper;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.common.constant.Constants;
import com.iyaovo.paper.foreground.domain.dto.IdsParam;
import com.iyaovo.paper.foreground.domain.entity.BuyerInfo;
import com.iyaovo.paper.foreground.domain.entity.CartInfo;
import com.iyaovo.paper.foreground.domain.entity.GoodsCategory;
import com.iyaovo.paper.foreground.domain.entity.GoodsInfo;
import com.iyaovo.paper.foreground.domain.vo.CartGoodsVo;
import com.iyaovo.paper.foreground.domain.vo.GoodsInfoVo;
import com.iyaovo.paper.foreground.mapper.*;
import com.iyaovo.paper.foreground.service.IBuyerInfoService;
import com.iyaovo.paper.foreground.service.IGoodsInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: GoodsInfoServiceImpl
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/13 19:30:56
 */
@Service
@RequiredArgsConstructor
public class GoodsInfoServiceImpl extends ServiceImpl<GoodsInfoMapper, GoodsInfo> implements IGoodsInfoService {

   private final GoodsInfoMapper goodsInfoMapper;

   private final ShopInfoMapper shopInfoMapper;

   private final GoodsCategoryMapper goodsCategoryMapper;

   private final CartInfoMapper cartInfoMapper;

   private final IBuyerInfoService iBuyerInfoService;



   @Override
   public CommonPage<GoodsInfoVo> showRecommendedGoods(Integer pageNum, Integer pageSize) {
      Page<GoodsInfo> goodsInfoPage = goodsInfoMapper.selectPage(new Page<>(pageNum,pageSize), null);
      List<GoodsInfoVo> goodsInfoVos = goodsInfoToGoodsInfoVo(goodsInfoPage.getRecords());
      Page<GoodsInfoVo> goodsInfoVoPage = new Page<>(pageNum,pageSize,goodsInfoPage.getTotal());
      goodsInfoVoPage.setPages(goodsInfoPage.getPages());
      goodsInfoVoPage.setRecords(goodsInfoVos);
      return CommonPage.restPage(goodsInfoVoPage);
   }

   @Override
   public CommonPage<GoodsInfoVo> showGoodsByGoodsCategoryId(Integer goodsCategoryId, Integer pageNum, Integer pageSize) {
      QueryWrapper<GoodsInfo> goodsInfoQueryWrapper = new QueryWrapper<>();
      goodsInfoQueryWrapper.eq("goods_category_id",goodsCategoryId);
      Page<GoodsInfo> goodsInfoPage = goodsInfoMapper.selectPage(new Page<>(pageNum,pageSize), goodsInfoQueryWrapper);
      List<GoodsInfoVo> goodsInfoVos = goodsInfoToGoodsInfoVo(goodsInfoPage.getRecords());
      Page<GoodsInfoVo> goodsInfoVoPage = new Page<>(pageNum,pageSize,goodsInfoPage.getTotal());
      goodsInfoVoPage.setPages(goodsInfoPage.getPages());
      goodsInfoVoPage.setRecords(goodsInfoVos);
      return CommonPage.restPage(goodsInfoVoPage);
   }




   private List<GoodsInfoVo> goodsInfoToGoodsInfoVo(List<GoodsInfo> goodsInfoList){
      List<GoodsInfoVo> goodsInfoVoList = new ArrayList<GoodsInfoVo>();
      goodsInfoList.forEach(goodsInfo ->{
         //entity转为vo
         GoodsInfoVo goodsInfoVo = new GoodsInfoVo(goodsInfo.getGoodsId(),goodsInfo.getGoodsName(),goodsInfo.getGoodsIntroduction(), goodsInfo.getPicUrl(), goodsInfo.getPrice(),
                 goodsInfo.getPromotionPrice(),goodsInfo.getSoldNumber(),goodsInfo.getTotalNumber());
         //把店铺id封装到vo
         goodsInfoVo.setShopId(goodsInfo.getShopId());

//         QueryWrapper<GoodsCategory> categorySecondQueryWrapper = new QueryWrapper<GoodsCategory>();
//         categorySecondQueryWrapper.eq("goods_category_id",goodsInfo.getGoodsCategoryId());
//         GoodsCategory goodsSecondCategory = goodsCategoryMapper.selectOne(categorySecondQueryWrapper);
//         QueryWrapper<GoodsCategory> categoryFirstQueryWrapper = new QueryWrapper<GoodsCategory>();
//         categoryFirstQueryWrapper.eq("goods_category_id",goodsSecondCategory.getCategorySuperiorId());
//         GoodsCategory goodsFirstCategory = goodsCategoryMapper.selectOne(categoryFirstQueryWrapper);
         //类别信息封装到vo
         goodsInfoVoList.add(goodsInfoVo);
      });
      return goodsInfoVoList;
   }

   @Override
   public List<GoodsInfoVo> showCartGoods() {
      QueryWrapper<GoodsInfoVo> goodsInfoVoQueryWrapper = new QueryWrapper<>();
      QueryWrapper<CartInfo> cartInfoQueryWrapper = new QueryWrapper<>();
      cartInfoQueryWrapper.eq("buyer_id",iBuyerInfoService.getBuyerInfo().getBuyerId());
      List<CartInfo> cartInfoList = cartInfoMapper.selectList(cartInfoQueryWrapper);
      List<GoodsInfo> goodsInfoList = new ArrayList<>();
      cartInfoList.forEach(cartInfo -> {
         goodsInfoList.add(goodsInfoMapper.selectById(cartInfo.getGoodsId()));
      });
      return goodsInfoToGoodsInfoVo(goodsInfoList);
   }

   @Override
   public List<GoodsInfoVo> showSettleGoods(IdsParam idsParam) {
      List<GoodsInfo> goodsInfoList = new ArrayList<>();
      for (long goodsId : idsParam.getIds()) {
         goodsInfoList.add(goodsInfoMapper.selectById(goodsId));
      }
      return goodsInfoToGoodsInfoVo(goodsInfoList);
   }

}

