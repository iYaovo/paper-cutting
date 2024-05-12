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

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.foreground.domain.entity.GoodsFirstCategory;
import com.iyaovo.paper.foreground.domain.entity.GoodsInfo;
import com.iyaovo.paper.foreground.domain.entity.GoodsSecondCategory;
import com.iyaovo.paper.foreground.mapper.GoodsInfoMapper;
import com.iyaovo.paper.foreground.service.IGoodsInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: GoodsInfoServiceImpl
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/13 19:30:56
 */
@Service
public class GoodsInfoServiceImpl extends ServiceImpl<GoodsInfoMapper, GoodsInfo> implements IGoodsInfoService {


   @Override
   public List<GoodsFirstCategory> showGoodsFirstCategoryList() {
      return null;
   }

   @Override
<<<<<<< Updated upstream
   public List<GoodsSecondCategory> showGoodsSecondCategoryListById(Integer goodsFirstCategoryId) {
      return null;
=======
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
         if (goodsInfo != null) { // 添加空值检查
            //entity转为vo
            GoodsInfoVo goodsInfoVo = new GoodsInfoVo(goodsInfo.getGoodsId(),goodsInfo.getGoodsName(),goodsInfo.getGoodsIntroduction(),ImageToBase64Util.convertFileToBase64(Constants.RESOURCE_PATH+goodsInfo.getPicUrl()), goodsInfo.getPrice(),
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
         }
      });
      return goodsInfoVoList;
>>>>>>> Stashed changes
   }

   @Override
   public CommonPage<GoodsInfo> showRecommendedGoods(Integer pageNum, Integer pageSize) {
      return null;
   }

   @Override
   public List<GoodsInfo> showGoodsByGoodsSecondCategoryId(Integer goodsSecondCategoryId, Integer pageNum, Integer pageSize) {
      return null;
   }


}

