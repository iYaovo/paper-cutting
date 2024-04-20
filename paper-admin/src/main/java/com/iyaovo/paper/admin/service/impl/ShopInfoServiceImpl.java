/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: ShopInfoServiceImpl
 * Author: 22932
 * Date: 2024/4/13 19:11:52
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iyaovo.paper.admin.domain.dto.ShopInfoParam;
import com.iyaovo.paper.admin.domain.entity.GoodsInfo;
import com.iyaovo.paper.admin.domain.entity.ShopInfo;
import com.iyaovo.paper.admin.mapper.ShopInfoMapper;
import com.iyaovo.paper.admin.service.IShopInfoService;
import com.iyaovo.paper.common.api.CommonPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ShopInfoServiceImpl
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/13 19:11:52
 */
@Service
public class ShopInfoServiceImpl extends ServiceImpl<ShopInfoMapper, ShopInfo> implements IShopInfoService {


   @Override
   public CommonPage<GoodsInfo> showGoodsByShopId(Integer shopId, Integer pageNum, Integer pageSize) {
      return null;
   }

   @Override
   public ShopInfo showShopInfoByGoodsId(Integer goodsId) {
      return null;
   }

   @Override
   public List<ShopInfo> listAllShop() {
      return null;
   }

   @Override
   public int createShop(ShopInfoParam shopInfoParam) {
      return 0;
   }

   @Override
   public int updateShop(Long id, ShopInfoParam shopInfoParam) {
      return 0;
   }


   @Override
   public int deleteShop(Long id) {
      return 0;
   }

   @Override
   public int deleteShop(List<Long> ids) {
      return 0;
   }

   @Override
   public List<ShopInfo> listShop(String keyword, Integer pageNum, Integer pageSize) {
      return null;
   }

}

