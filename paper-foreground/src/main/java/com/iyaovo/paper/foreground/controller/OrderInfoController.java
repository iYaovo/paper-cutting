/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: OrderInfoController
 * Author: 22932
 * Date: 2024/4/13 21:01:49
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
import com.iyaovo.paper.foreground.domain.entity.OrderInfo;
import com.iyaovo.paper.foreground.service.IOrderInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: OrderInfoController
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/13 21:01:49
 */
@RestController
@RequestMapping("/order")
@Tag(name = "订单信息接口")
@Slf4j
@RequiredArgsConstructor
public class OrderInfoController {

   private final IOrderInfoService iOrderInfoService;

   /**
    * 展示全部订单
    * @param
    */
   @GetMapping("")
   @Operation(summary = "展示全部订单")
   public CommonResult<CommonPage<OrderInfo>> showOrderInfo(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
      return CommonResult.success(iOrderInfoService.showOrderInfo(pageNum,pageSize));
   }

   /**
    * 展示订单by状态
    * @param
    */
   @GetMapping("/{orderStatus}")
   @Operation(summary = "展示订单by状态")
   public CommonResult<CommonPage<OrderInfo>> showOrderInfoByStatus(@PathVariable("orderStatus") Integer orderStatus,
                                                      @RequestParam("pageNum") Integer pageNum,
                                                      @RequestParam("pageSize") Integer pageSize) {
      return CommonResult.success(iOrderInfoService.showOrderInfoByStatus(orderStatus,pageNum,pageSize));
   }

   /**
    * 删除订单
    * @param idsParam
    * @return
    */
   @PostMapping("/delete")
   @Operation(summary = "通过ids删除订单")
   public CommonResult<CommonPage<OrderInfo>> deleteOrderInfo(@RequestBody IdsParam idsParam) {
      System.out.println(idsParam.getIds()[0]);
      iOrderInfoService.deleteOrderInfo(idsParam);
      return CommonResult.success();
   }
}

