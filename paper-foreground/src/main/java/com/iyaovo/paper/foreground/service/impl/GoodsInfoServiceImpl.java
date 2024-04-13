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
   public List<GoodsSecondCategory> showGoodsSecondCategoryListById(Integer goodsFirstCategoryId) {
      return null;
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

