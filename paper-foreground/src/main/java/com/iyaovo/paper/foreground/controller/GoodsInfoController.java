/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: GoodsInfoController
 * Author: 22932
 * Date: 2024/4/13 20:55:26
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
import com.iyaovo.paper.foreground.domain.dto.IdsParam;
import com.iyaovo.paper.foreground.domain.vo.GoodsInfoVo;
import com.iyaovo.paper.foreground.service.IGoodsInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: GoodsInfoController
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/13 20:55:26
 */
@RestController
@RequestMapping("/goods")
@Tag(name = "商品信息接口")
@Slf4j
@RequiredArgsConstructor
public class GoodsInfoController {

   private final IGoodsInfoService iGoodsInfoService;



   @GetMapping("/getOne/{goodsId}")
   @Operation(summary = "通过id获取商品")
   public CommonResult getGoodsById(@PathVariable("goodsId") Integer goodsId) {
      iGoodsInfoService.getGoodsById(goodsId);
      return CommonResult.success();
   }

   /**
    * 展示推荐商品
    * @param
    */
   @GetMapping("/recommend")
   @Operation(summary = "展示推荐物品")
   public CommonResult<CommonPage<GoodsInfoVo>> showRecommendedGoods(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
      return CommonResult.success(iGoodsInfoService.showRecommendedGoods(pageNum,pageSize));
   }

   /**
    * 展示第二类别下的商品
    * @param
    */
   @GetMapping("/{goodsCategoryId}")
   @Operation(summary = "展示类别的商品")
   public CommonResult<CommonPage<GoodsInfoVo>> showGoodsByGoodsSecondCategoryId(@PathVariable("goodsCategoryId") Integer goodsCategoryId,
                                                           @RequestParam("pageNum") Integer pageNum,
                                                           @RequestParam("pageSize")Integer pageSize) {
      return CommonResult.success(iGoodsInfoService.showGoodsByGoodsCategoryId(goodsCategoryId,pageNum,pageSize));
   }

   /**
    * 展示购物车商品
    * @return
    */
   @GetMapping("/cart")
   @Operation(summary = "展示购物车商品")
   public CommonResult<List<GoodsInfoVo>> showCartGoods() {
      return CommonResult.success(iGoodsInfoService.showCartGoods());
   }


   /**
    * 展示结算商品
    */
   @PostMapping("/settle")
   @Operation(summary = "展示结算商品")
   public CommonResult<List<GoodsInfoVo>> showSettleGoods(@RequestBody IdsParam idsParam) {
      return CommonResult.success(iGoodsInfoService.showSettleGoods(idsParam));
   }

}

