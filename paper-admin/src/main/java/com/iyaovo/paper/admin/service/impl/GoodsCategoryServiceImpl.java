/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: GoodsCategoryServiceImpl
 * Author: 22932
 * Date: 2024/4/19 12:11:05
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
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iyaovo.paper.admin.domain.dto.GoodsCategoryParam;
import com.iyaovo.paper.admin.domain.dto.GoodsCategoryWithChildrenItem;
import com.iyaovo.paper.admin.domain.entity.GoodsCategory;
import com.iyaovo.paper.admin.domain.vo.GoodsCategoryVo;
import com.iyaovo.paper.admin.mapper.GoodsCategoryMapper;
import com.iyaovo.paper.admin.mapper.GoodsInfoMapper;
import com.iyaovo.paper.admin.service.IGoodsCategoryService;
import com.iyaovo.paper.common.constant.Constants;
import com.iyaovo.paper.common.util.ImageToBase64Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: GoodsCategoryServiceImpl
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/19 12:11:05
 */
@Service
@RequiredArgsConstructor
public class GoodsCategoryServiceImpl implements IGoodsCategoryService {

   private final GoodsCategoryMapper goodsCategoryMapper;

   private final GoodsInfoMapper goodsInfoMapper;

   @Override
   public int create(GoodsCategoryParam goodsCategoryParam) {
      return goodsCategoryMapper.insert(new GoodsCategory(null,goodsCategoryParam.getName(),goodsCategoryParam.getPicUrl(),goodsCategoryParam.getParentId()));
   }

   @Override
   public int delete(Integer goodsCategoryId) {
      return goodsCategoryMapper.deleteById(goodsCategoryId);
   }

   @Override
   public int update(Integer id, GoodsCategoryParam goodsCategoryParam) {
      return goodsCategoryMapper.updateById(new GoodsCategory(id, goodsCategoryParam.getName(),goodsCategoryParam.getPicUrl(),goodsCategoryParam.getParentId()));
   }

   @Override
   public Page<GoodsCategoryVo> getList(Long parentId, Integer pageSize, Integer pageNum) {
      QueryWrapper<GoodsCategory> goodsCategoryQueryWrapper = new QueryWrapper<GoodsCategory>();
      goodsCategoryQueryWrapper.eq("category_superior_id",parentId);
      Page<GoodsCategory> page = new Page<>(pageNum, pageSize);
      Page<GoodsCategory> goodsCategories = goodsCategoryMapper.selectPage(page,goodsCategoryQueryWrapper);
      List<GoodsCategory> records = goodsCategories.getRecords();
      List<GoodsCategoryVo> goodsCategoryVos = new ArrayList<>();
      records.forEach(goodsCategory -> {
         goodsCategory.setGoodsNumber(getGoodsNumber(goodsCategory.getGoodsCategoryId(),goodsCategory.getCategorySuperiorId()));
         goodsCategoryVos.add(new GoodsCategoryVo(goodsCategory.getGoodsCategoryId(),goodsCategory.getGoodCategoryName(),
                 ImageToBase64Util.convertFileToBase64(Constants.RESOURCE_PATH+goodsCategory.getPicUrl()),goodsCategory.getCategorySuperiorId(),goodsCategory.getGoodsNumber()));
      });
      Page<GoodsCategoryVo> goodsCategoryVoPage = new Page<>(pageNum,pageSize,goodsCategories.getTotal());
      goodsCategoryVoPage.setPages(goodsCategories.getPages());
      goodsCategoryVoPage.setRecords(goodsCategoryVos);
      return goodsCategoryVoPage;
   }

   private Long getGoodsNumber(Integer categoryId, Integer parentId){
      final long[] number = {0L};
      if(parentId == 0){
         QueryWrapper queryCategoryWrapper = new QueryWrapper<>();
         queryCategoryWrapper.eq("category_superior_id",categoryId);
         List<GoodsCategory> goodsCategories = goodsCategoryMapper.selectList(queryCategoryWrapper);
         goodsCategories.forEach(goodsCategory -> {
            QueryWrapper queryGoodsNumberWrapper = new QueryWrapper<>();
            queryGoodsNumberWrapper.eq("goods_category_id",goodsCategory.getGoodsCategoryId());
            number[0] += goodsInfoMapper.selectCount(queryGoodsNumberWrapper);
         });
         return number[0];
      }else{
         QueryWrapper queryGoodsNumberWrapper = new QueryWrapper<>();
         queryGoodsNumberWrapper.eq("goods_category_id",categoryId);
         return goodsInfoMapper.selectCount(queryGoodsNumberWrapper);
      }
   }

   @Override
   public List<GoodsCategoryWithChildrenItem> listWithChildren() {
      QueryWrapper<GoodsCategory> goodsCategoryQueryWrapper = new QueryWrapper<GoodsCategory>();
      goodsCategoryQueryWrapper.eq("category_superior_id",0);
      List<GoodsCategory> goodsCategories = goodsCategoryMapper.selectList(goodsCategoryQueryWrapper);
      List<GoodsCategoryWithChildrenItem> goodsCategoryWithChildrenItems = new ArrayList<>();
      goodsCategories.forEach(goodsCategory -> {
         QueryWrapper<GoodsCategory> goodsCategoryChildrenQueryWrapper = new QueryWrapper<GoodsCategory>();
         goodsCategoryChildrenQueryWrapper.eq("category_superior_id",goodsCategory.getGoodsCategoryId());
         GoodsCategoryWithChildrenItem goodsCategoryWithChildrenItem = new GoodsCategoryWithChildrenItem(goodsCategory.getGoodsCategoryId(),
                 goodsCategory.getGoodCategoryName(),goodsCategory.getCategorySuperiorId(),goodsCategoryMapper.selectList(goodsCategoryChildrenQueryWrapper));
         goodsCategoryWithChildrenItems.add(goodsCategoryWithChildrenItem);
      });
      return goodsCategoryWithChildrenItems;
   }

   @Override
   public GoodsCategoryVo getOneGoodsCategory(Integer goodsCategoryId) {
      GoodsCategory goodsCategory = goodsCategoryMapper.selectById(goodsCategoryId);
      return new GoodsCategoryVo(goodsCategory.getGoodsCategoryId(),goodsCategory.getGoodCategoryName(),ImageToBase64Util.convertFileToBase64(Constants.RESOURCE_PATH+goodsCategory.getPicUrl()),goodsCategory.getCategorySuperiorId(),goodsCategory.getGoodsNumber());
   }
}

