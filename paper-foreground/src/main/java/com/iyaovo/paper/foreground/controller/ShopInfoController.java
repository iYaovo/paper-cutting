/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: ShopInfoController
 * Author: 22932
 * Date: 2024/4/13 21:08:00
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.controller;

import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.common.api.CommonResult;
import com.iyaovo.paper.foreground.domain.entity.GoodsInfo;
import com.iyaovo.paper.foreground.domain.entity.ShopInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: ShopInfoController
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/13 21:08:00
 */
@RestController
@RequestMapping("/foreground/shop")
@Tag(name = "收货地址接口")
@Slf4j
@RequiredArgsConstructor
public class ShopInfoController {

   /**
    * 展示商品by店铺id
    * @param
    */
   @GetMapping("{shopId}")
   @Operation(summary = "展示商品by店铺id")
   public CommonResult<CommonPage<GoodsInfo>> showGoodsByShopId(@PathVariable("shopId") Integer shopId,
                                                  @RequestParam("pageNum") Integer pageNum,
                                                  @RequestParam("pageSize") Integer pageSize) {
      return CommonResult.success();
   }

   /**
    * 展示商品by店铺id
    * @param
    */
   @GetMapping("{goodsId}")
   @Operation(summary = "展示商品by店铺id")
   public CommonResult<ShopInfo> showShopInfoByGoodsId(@PathVariable("goodsId") Integer goodsId) {
      return CommonResult.success();
   }
}

