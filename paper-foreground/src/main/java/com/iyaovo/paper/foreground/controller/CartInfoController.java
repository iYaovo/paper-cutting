/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: CartInfoController
 * Author: 22932
 * Date: 2024/4/12 23:54:57
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
import com.iyaovo.paper.foreground.domain.dto.IdsParam;
import com.iyaovo.paper.foreground.domain.dto.SettleCartGoodsParam;
import com.iyaovo.paper.foreground.domain.entity.GoodsInfo;
import com.iyaovo.paper.foreground.domain.vo.GoodsInfoVo;
import com.iyaovo.paper.foreground.mapper.DailySignMapper;
import com.iyaovo.paper.foreground.service.ICartInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: CartInfoController
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 23:54:57
 */
@RestController
@RequestMapping("/cart")
@Tag(name = "买家购物车信息接口")
@Slf4j
@RequiredArgsConstructor
public class CartInfoController {

   @Autowired
   private ICartInfoService iCartInfoService;

   /**
    * 添加物品到购物车
    * @param cartInfoDto
    */
   @PostMapping("/create")
   @Operation(summary = "添加商品到购物车")
   public CommonResult createGoodsToCart(@RequestBody CartInfoDto cartInfoDto) {
      iCartInfoService.createGoodsToCart(cartInfoDto);
      return CommonResult.success();
   }

   /**
    * 更改商品数量
    * @param
    * @return
    */
   @GetMapping("/update")
   @Operation(summary = "通过购物车id更改商品数量")
   public CommonResult updateGoodsNumber(@RequestParam("cartId") Integer cartId,@RequestParam("goodsNumber") Integer goodsNumber) {
      iCartInfoService.updateGoodsNumber(cartId,goodsNumber);
      return CommonResult.success();
   }

   /**
    * 结算购物车商品
    * @param
    * @return
    */
   @PostMapping("/settle")
   @Operation(summary = "结算购物车商品")
   public CommonResult settleCartGoods(@RequestBody SettleCartGoodsParam settleCartGoodsParam) {
      iCartInfoService.settleCartGoods(settleCartGoodsParam);
      return CommonResult.success();
   }

   /**
    * 删除购物车商品
    * @param
    * @return
    */
   @PostMapping("/delete")
   @Operation(summary = "删除购物车商品")
   public CommonResult deleteGoodsFromCart(@RequestBody IdsParam idsParam) {
      iCartInfoService.deleteGoodsFromCart(idsParam);
      return CommonResult.success();
   }
}

