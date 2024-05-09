/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: IGoodsInfoService
 * Author: 22932
 * Date: 2024/4/13 19:16:44
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.foreground.domain.dto.IdsParam;
import com.iyaovo.paper.foreground.domain.entity.GoodsInfo;
import com.iyaovo.paper.foreground.domain.vo.GoodsInfoVo;

import java.util.List;

/**
 * @ClassName: IGoodsInfoService
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/13 19:16:44
 */
public interface IGoodsInfoService extends IService<GoodsInfo> {


   /**
    * 展示首页商品/精品推荐(随机分页)
    */
   CommonPage<GoodsInfoVo> showRecommendedGoods(Integer pageNum,
                                                Integer pageSize);

   /**
    * 通过小类id获取商品(分页)
    */
   CommonPage<GoodsInfoVo> showGoodsByGoodsCategoryId(Integer goodsSecondCategoryId,
                                                    Integer pageNum,
                                                    Integer pageSize);

   List<GoodsInfoVo> showCartGoods();

   List<GoodsInfoVo> showSettleGoods(IdsParam idsParam);

   void getGoodsById(Integer goodsId);
}

