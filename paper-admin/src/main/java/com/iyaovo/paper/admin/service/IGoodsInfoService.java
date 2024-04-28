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
package com.iyaovo.paper.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.iyaovo.paper.admin.domain.dto.GoodsInfoQueryParam;
import com.iyaovo.paper.admin.domain.entity.GoodsInfo;
import com.iyaovo.paper.admin.domain.vo.GoodsInfoVo;
import com.iyaovo.paper.common.api.CommonPage;

import java.util.List;

/**
 * @ClassName: IGoodsInfoService
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/13 19:16:44
 */
public interface IGoodsInfoService extends IService<GoodsInfo> {


   /**
    * 展示首页商品
    */
   CommonPage<GoodsInfoVo> showGoods(Integer pageNum,
                                                Integer pageSize);

   /**
    * 通过小类id获取商品(分页)
    */
   CommonPage<GoodsInfoVo> showGoodsByGoodsSecondCategoryId(Integer goodsSecondCategoryId,
                                                    Integer pageNum,
                                                    Integer pageSize);
   /**
    * 添加商品
    */
   int create(GoodsInfo goodsInfo);

   /**
    * 修改商品
    */
   int update(Integer id,GoodsInfo goodsInfo);

   /**
    * 删除商品
    */
   void deleteGoods(Integer goodsId);

   /**
    * 查询商品
    * @param goodsInfoQueryParam
    * @param pageSize
    * @param pageNum
    * @return
    */
   List<GoodsInfoVo> list(GoodsInfoQueryParam goodsInfoQueryParam, Integer pageSize, Integer pageNum);

   /**
    * 根据关键字查询
    * @param keyWord
    * @return
    */
   List<GoodsInfoVo> list(String keyWord);

   // TODO 按条件查询
}

