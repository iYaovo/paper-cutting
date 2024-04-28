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

import com.iyaovo.paper.admin.domain.dto.GoodsCategoryParam;
import com.iyaovo.paper.admin.domain.entity.GoodsCategory;
import com.iyaovo.paper.admin.mapper.GoodsCategoryMapper;
import com.iyaovo.paper.admin.service.IGoodsCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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



//   @Override
//   public List<GoodsCategory> showGoodsFirstCategoryList() {
//      return goodsCategoryMapper.selectList(null);
//   }
//
//   @Override
//   public List<GoodsCategory> showGoodsSecondCategoryListById(Integer goodsFirstCategoryId) {
//      QueryWrapper<GoodsCategory> goodsCategoryQueryWrapper = new QueryWrapper<>();
//      goodsCategoryQueryWrapper.eq("goods_first_category_id",goodsFirstCategoryId);
//      return goodsCategoryMapper.selectList(goodsCategoryQueryWrapper);
//   }



   @Override
   public int create(GoodsCategoryParam goodsCategoryParam) {
      return 0;
   }

   @Override
   public int delete(Integer goodsCategoryId) {
      return 0;
   }

   @Override
   public int update(Integer id, GoodsCategoryParam goodsCategoryParam) {
      return 0;
   }

   @Override
   public List<GoodsCategory> getList(Long parentId, Integer pageSize, Integer pageNum) {
      return null;
   }
}

