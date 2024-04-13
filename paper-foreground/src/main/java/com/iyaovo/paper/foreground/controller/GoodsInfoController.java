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
import com.iyaovo.paper.foreground.domain.dto.CartInfoDto;
import com.iyaovo.paper.foreground.domain.entity.GoodsFirstCategory;
import com.iyaovo.paper.foreground.domain.entity.GoodsInfo;
import com.iyaovo.paper.foreground.domain.entity.GoodsSecondCategory;
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
@RequestMapping("/foreground/goods")
@Tag(name = "商品信息接口")
@Slf4j
@RequiredArgsConstructor
public class GoodsInfoController {

   /**
    * 展示第一类别
    * @param
    */
   @GetMapping("/firstCategory")
   @Operation(summary = "展示第一类别")
   public List<GoodsFirstCategory> showGoodsFirstCategoryList() {
      return null;
   }

   /**
    * 展示第二类别
    * @param
    */
   @GetMapping("/secondCategory/{goodsFirstCategoryId}")
   @Operation(summary = "展示第二类别")
   public List<GoodsSecondCategory> showGoodsSecondCategoryListById(@PathVariable("goodsFirstCategoryId") Integer goodsFirstCategoryId) {
      return null;
   }

   /**
    * 展示推荐商品
    * @param
    */
   @GetMapping("/recommend")
   @Operation(summary = "展示推荐物品")
   public CommonResult<CommonPage<GoodsInfo>> showRecommendedGoods(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
      return CommonResult.success();
   }

   /**
    * 展示第二类别下的商品
    * @param
    */
   @GetMapping("/{goodsSecondCategoryId}")
   @Operation(summary = "展示第二类别下的商品")
   public CommonResult<List<GoodsInfo>> showGoodsByGoodsSecondCategoryId(@PathVariable("goodsSecondCategoryId") Integer goodsSecondCategoryId,
                                                           @RequestParam("pageNum") Integer pageNum,
                                                           @RequestParam("pageSize")Integer pageSize) {
      return CommonResult.success();
   }
}

