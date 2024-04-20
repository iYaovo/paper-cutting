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
package com.iyaovo.paper.admin.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iyaovo.paper.admin.domain.dto.GoodsInfoQueryParam;
import com.iyaovo.paper.admin.domain.entity.GoodsInfo;
import com.iyaovo.paper.admin.domain.vo.GoodsInfoVo;
import com.iyaovo.paper.admin.mapper.GoodsCategoryMapper;
import com.iyaovo.paper.admin.mapper.GoodsInfoMapper;
import com.iyaovo.paper.admin.mapper.ShopInfoMapper;
import com.iyaovo.paper.admin.service.IGoodsInfoService;
import com.iyaovo.paper.common.api.CommonPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

   private final GoodsCategoryMapper goodsFirstCategoryMapper;





   @Override
   public CommonPage<GoodsInfoVo> showGoods(Integer pageNum, Integer pageSize) {
      PageHelper.startPage(pageNum,pageSize);
      return CommonPage.restPage(goodsInfoToGoodsInfoVo(goodsInfoMapper.selectList(null)));
   }

   @Override
   public CommonPage<GoodsInfoVo> showGoodsByGoodsSecondCategoryId(Integer goodsSecondCategoryId, Integer pageNum, Integer pageSize) {
      PageHelper.startPage(pageNum,pageSize);
      QueryWrapper<GoodsInfo> goodsInfoQueryWrapper = new QueryWrapper<>();
      goodsInfoQueryWrapper.eq("goods_second_category_id",goodsSecondCategoryId);
      return CommonPage.restPage(goodsInfoToGoodsInfoVo( goodsInfoMapper.selectList(goodsInfoQueryWrapper)));
   }

   @Override
   public int create(GoodsInfo goodsInfo) {
      return goodsInfoMapper.insert(goodsInfo);

   }

   @Override
   public int update(Integer id ,GoodsInfo goodsInfo) {
      return goodsInfoMapper.updateById(goodsInfo);
   }

   @Override
   public void deleteGoods(Integer goodsId) {
      goodsInfoMapper.deleteById(goodsId);
   }

   @Override
   public List<GoodsInfoVo> list(GoodsInfoQueryParam goodsInfoQueryParam, Integer pageSize, Integer pageNum) {
      return null;
   }

   @Override
   public List<GoodsInfoVo> list(String keyWord) {
      return null;
   }

//TODO 重写

   private List<GoodsInfoVo> goodsInfoToGoodsInfoVo(List<GoodsInfo> goodsInfoList){
//      List<GoodsInfoVo> goodsInfoVoList = new ArrayList<GoodsInfoVo>();
//      goodsInfoList.forEach(goodsInfo ->{
//         //entity转为vo
//         GoodsInfoVo goodsInfoVo = new GoodsInfoVo(goodsInfo.getGoodsId(),goodsInfo.getGoodsName(),goodsInfo.getGoodsIntroduction(), goodsInfo.getPicUrl(), goodsInfo.getPrice(),
//                 goodsInfo.getPromotionPrice(),goodsInfo.getSoldNumber(),goodsInfo.getTotalNumber(),null,null);
//         //把店铺信息封装到vo
//         goodsInfoVo.setShopInfo(shopInfoMapper.selectById(goodsInfo.getShopId()));
//         GoodsSecondCategory goodsSecondCategory = goodsSecondCategoryMapper.selectById(goodsInfo.getGoodsSecondCategoryId());
//         //类别信息封装到vo
//         Map<Integer,String> map = new HashMap<Integer,String>();
//         map.put(Constants.FIRST_CATEGORY,goodsFirstCategoryMapper.selectById(goodsSecondCategory.getGoodsFirstCategoryId()).getGoodsFirstCategoryName());
//         map.put(Constants.SECOND_CATEGORY,goodsSecondCategory.getGoodsSecondCategoryName());
//         goodsInfoVo.setCategoryMap(map);
//         goodsInfoVoList.add(goodsInfoVo);
//      });
//      return goodsInfoVoList;
      return null;
   }

}

