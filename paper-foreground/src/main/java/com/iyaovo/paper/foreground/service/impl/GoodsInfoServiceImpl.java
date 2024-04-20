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
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.common.constant.Constants;
import com.iyaovo.paper.foreground.domain.entity.GoodsFirstCategory;
import com.iyaovo.paper.foreground.domain.entity.GoodsInfo;
import com.iyaovo.paper.foreground.domain.entity.GoodsSecondCategory;
import com.iyaovo.paper.foreground.domain.vo.GoodsInfoVo;
import com.iyaovo.paper.foreground.mapper.*;
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

   private final GoodsFirstCategoryMapper goodsFirstCategoryMapper;

   private final GoodsSecondCategoryMapper goodsSecondCategoryMapper;

   private final CartInfoMapper cartInfoMapper;

   @Override
   public List<GoodsFirstCategory> showGoodsFirstCategoryList() {
      return null;
   }

   @Override
   public List<GoodsSecondCategory> showGoodsSecondCategoryListById(Integer goodsFirstCategoryId) {
      return null;
   }

   @Override
   public CommonPage<GoodsInfoVo> showRecommendedGoods(Integer pageNum, Integer pageSize) {
      PageHelper.startPage(pageNum,pageSize);
      List<GoodsInfo> goodsInfoList = goodsInfoMapper.selectRandomProducts(Constants.LIMIT_NUMBER);
      return CommonPage.restPage(goodsInfoToGoodsInfoVo(goodsInfoList));
   }

   @Override
   public CommonPage<GoodsInfoVo> showGoodsByGoodsSecondCategoryId(Integer goodsSecondCategoryId, Integer pageNum, Integer pageSize) {
      PageHelper.startPage(pageNum,pageSize);
      QueryWrapper<GoodsInfo> goodsInfoQueryWrapper = new QueryWrapper<>();
      goodsInfoQueryWrapper.eq("goods_second_category_id",goodsSecondCategoryId);
      List<GoodsInfo> goodsInfoList = goodsInfoMapper.selectList(goodsInfoQueryWrapper);
      return CommonPage.restPage(goodsInfoToGoodsInfoVo(goodsInfoList));
   }

   @Override
   public CommonPage<GoodsInfoVo> showCartGoods(Integer pageNum, Integer pageSize) {
//      PageHelper.startPage(pageNum,pageSize);
//      List<C> goodsInfoList = cartInfoMapper.selectList(null);
//      return CommonPage.restPage(goodsInfoToGoodsInfoVo(goodsInfoList));
      return null;
   }


   private List<GoodsInfoVo> goodsInfoToGoodsInfoVo(List<GoodsInfo> goodsInfoList){
      List<GoodsInfoVo> goodsInfoVoList = new ArrayList<GoodsInfoVo>();
      goodsInfoList.forEach(goodsInfo ->{
         //entity转为vo
         GoodsInfoVo goodsInfoVo = new GoodsInfoVo(goodsInfo.getGoodsId(),goodsInfo.getGoodsName(),goodsInfo.getGoodsIntroduction(), goodsInfo.getPicUrl(), goodsInfo.getPrice(),
                 goodsInfo.getPromotionPrice(),goodsInfo.getSoldNumber(),goodsInfo.getTotalNumber(),null,null);
         //把店铺信息封装到vo
         goodsInfoVo.setShopInfo(shopInfoMapper.selectById(goodsInfo.getShopId()));
         GoodsSecondCategory goodsSecondCategory = goodsSecondCategoryMapper.selectById(goodsInfo.getGoodsSecondCategoryId());
         //类别信息封装到vo
         Map<Integer,String> map = new HashMap<Integer,String>();
         map.put(Constants.FIRST_CATEGORY,goodsFirstCategoryMapper.selectById(goodsSecondCategory.getGoodsFirstCategoryId()).getGoodsFirstCategoryName());
         map.put(Constants.SECOND_CATEGORY,goodsSecondCategory.getGoodsSecondCategoryName());
         goodsInfoVo.setCategoryMap(map);
         goodsInfoVoList.add(goodsInfoVo);
      });
      return goodsInfoVoList;
   }

}

