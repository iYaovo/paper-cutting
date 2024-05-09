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


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.iyaovo.paper.admin.domain.dto.GoodsInfoParam;
import com.iyaovo.paper.admin.domain.dto.IdsParam;
import com.iyaovo.paper.admin.domain.entity.GoodsInfo;
import com.iyaovo.paper.admin.domain.vo.GoodsInfoVo;

import java.util.List;

/**
 * @ClassName: IGoodsInfoService
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/13 19:16:44
 */
public interface IGoodsInfoService extends IService<GoodsInfo> {

   /**
    * 添加商品
    */
   int create(GoodsInfoParam goodsInfoParam);

   /**
    * 修改商品
    */
   int update(Integer id,GoodsInfoParam goodsInfoParam);

   /**
    * 删除商品
    */
   void deleteGoods(IdsParam idsParam);

   /**
    * 查询商品
    * @param
    * @param pageSize
    * @param pageNum
    * @return
    */
   Page<GoodsInfoVo> list(String keyword,
                          Integer goodsCategoryId,
                          Integer shopId,
                          Integer pageSize,
                          Integer pageNum);

   /**
    * 根据关键字查询
    * @param keyWord
    * @return
    */
   List<GoodsInfoVo> list(String keyWord);

   GoodsInfoVo getOneGoods(Integer goodsId);
}

